package id.co.mii.serverapp.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Role;
import id.co.mii.serverapp.Model.User;
import id.co.mii.serverapp.Repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleService roleService;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!!!"));
    }

    // add role
    public User addRole(Integer id, Role role) {
        // cek user
        User user = getById(id);

        // cek role & set role
        List<Role> roles = user.getRoles();
        roles.add(roleService.getById(role.getId()));
        user.setRoles(roles);
        return userRepository.save(user);
    }

}
