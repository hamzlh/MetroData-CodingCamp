package id.co.mii.serverapp.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import id.co.mii.serverapp.Model.Role;
import id.co.mii.serverapp.Repositories.RoleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
    
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getById(Integer id){
        return roleRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found!!!"));
    }

    public Role create (Role role){
        
        // if (roleRepository.findByName(role.getName()).equals(role)) {
        //     throw new ResponseStatusException(HttpStatus.CONFLICT, "Role already exists!!!");        
        // }
        return roleRepository.save(role);
    }

    public Role update (Integer Id, Role role){
        getById(Id);
        role.setId(Id);
        return role;
    }

    public Role delete(Integer id){
        Role role = getById(id);
        roleRepository.delete(role);
        return role;
    }

}
