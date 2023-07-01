package id.co.mii.serverapp.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    // private ModelMapper modelMapper;
    // private RoleService roleService;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Employee not found!!!"));
    }

    // public Employee create(EmployeeRequest employeerRequest) {
        
    //     Employee employee = modelMapper.map(employeerRequest, Employee.class);
    //     User user = modelMapper.map(employeerRequest,User.class);

    //     // set default role
    //     List<Role> roles = new ArrayList<>();
    //     roles.add(roleService.getById(1));
    //     user.setRoles(roles);

    //     employee.setUser(user);
    //     user.setEmployee(employee);

    //     return employeeRepository.save(employee);
    // }

    public Employee update(Integer id, Employee employee) {
        getById(id);
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public Employee delete(Integer id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

}
