package id.co.mii.serverapp.Service;

import java.util.List;


// import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.User;
// import id.co.mii.serverapp.Model.DTORequest.UserRequest;
import id.co.mii.serverapp.Repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    // private ModelMapper modelMapper;
    // private EmployeeService employeeService;
    
    

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.findById(id)
        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!!!"));
    }

    public User create(User user){
        // if (userRepository.existsByUsername(userRequest.getUsername())) {
        //     throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists!!!" );
        // }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists!!!");
        }
        // User user = modelMapper.map(userRequest, User.class);
        // user.setEmployee(employeeService.getById(userRequest.getEmployeeId()));
        
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
