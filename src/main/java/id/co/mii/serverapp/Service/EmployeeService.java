package id.co.mii.serverapp.Service;


import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Employee;

import id.co.mii.serverapp.Model.User;
import id.co.mii.serverapp.Model.DTORequest.EmployeeRequest;
import id.co.mii.serverapp.Repositories.EmployeeRepository;
import id.co.mii.serverapp.Repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    private UserRepository userRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Employee not found!!!"));
    }

    public Employee create(EmployeeRequest employeerRequest) {
        
        if (employeeRepository.existsByEmail(employeerRequest.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!!!");
        }
        Employee employee = modelMapper.map(employeerRequest, Employee.class);
        User user = new User();
        user.setUsername(employeerRequest.getUsername());
        user.setPassword(employeerRequest.getPassword());
        userService.create(user);
        User emp = userRepository.findByUsername(user.getUsername()).get();
        employee.setUser(userService.getById(emp.getId()));

        return employeeRepository.save(employee);
    }

    public Employee update(Integer id, EmployeeRequest employeeRequest) {
        Employee employee = getById(id);
        // Employee employee = modelMapper.map(employeeRequest, Employee.class);
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        User user = employee.getUser();
        user.setUsername(employeeRequest.getUsername());
        user.setPassword(employeeRequest.getPassword());
        // userService.create(user);
        // User emp = userRepository.findByUsername(user.getUsername()).get();

        employee.setUser(user);
        user.setEmployee(employee);
        // employee.setUser(User user);
        return employeeRepository.save(employee);
    }

    public Employee delete(Integer id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
        return employee;
    }

}
