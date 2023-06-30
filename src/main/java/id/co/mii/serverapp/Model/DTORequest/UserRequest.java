package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    // private String roleName;
    // private Integer employeeId;
    
}
