package id.co.mii.serverapp.Service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Role;
import id.co.mii.serverapp.Model.User;
import id.co.mii.serverapp.Model.DTORequest.RoleRequest;
import id.co.mii.serverapp.Repositories.RoleRepository;
import id.co.mii.serverapp.Repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!!!"));
    }

    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists!!!");
        }
        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        getById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public User delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    public User addRolesToUser(Integer Id, Set<RoleRequest> roleRequests) {
        User user = getById(Id);

        Set<Role> roles = new HashSet<>();
        for (RoleRequest roleRequest : roleRequests) {
            Role role = roleRepository.findByName(roleRequest.getName());
            if (role != null) {
                roles.add(role);
            }
        }
        user.setRole(roles);
        return userRepository.save(user);

    }
}
