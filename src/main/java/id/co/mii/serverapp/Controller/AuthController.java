package id.co.mii.serverapp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Model.DTORequest.EmployeeRequest;
import id.co.mii.serverapp.Service.AuthService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/registration")
    public Employee create(@RequestBody EmployeeRequest employeeRequest){
        return authService.create(employeeRequest);
    }
}
