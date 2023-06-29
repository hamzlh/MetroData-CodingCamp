package id.co.mii.serverapp.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Model.DTORequest.EmployeeRequest;
import id.co.mii.serverapp.Repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id){
        return employeeRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "Employee not found!!!"));
    }

    public Employee create(EmployeeRequest employeerRequest){
        // if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
        //     throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!!!");
        // }
        if (employeeRepository.existsByEmail(employeerRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists!!!" );
        }
        Employee employee = modelMapper.map(employeerRequest, Employee.class);
        employee.setUser(userService.getById(employeerRequest.getUserId()));
        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, Employee employee){
        getById(id);
        employee.setId(id);
        return employee;
    }

    public Employee delete(Integer id){
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }




}
