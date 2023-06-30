package id.co.mii.serverapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Model.Role;
import id.co.mii.serverapp.Model.User;
import id.co.mii.serverapp.Model.DTORequest.EmployeeRequest;
import id.co.mii.serverapp.Repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private RoleService roleService;

    public Employee create(EmployeeRequest employeeRequest){
        Employee employee = modelMapper.map(employeeRequest, Employee.class);
        User user = modelMapper.map(employeeRequest, User.class);

        // set default role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1));
        user.setRoles(roles);

        employee.setUser(user);
        user.setEmployee(employee);
        return employeeRepository.save(employee);
    }
}
