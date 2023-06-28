package id.co.mii.serverapp.Service;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Model.User;
import id.co.mii.serverapp.Model.DTORequest.CountryRequest;
import id.co.mii.serverapp.Model.DTORequest.UserRequest;
import id.co.mii.serverapp.Repositories.EmployeeRepository;
import id.co.mii.serverapp.Repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    
    

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.findById(id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!!!"));
    }

    public User create(UserRequest userRequest){
        User user = modelMapper.map(userRequest, User.class);
        // user.setEmployee(employeeService));
        // kurang employee_id
        return userRepository.save(user);
    }

    public User update(Integer id, User user){
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Integer id){
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
