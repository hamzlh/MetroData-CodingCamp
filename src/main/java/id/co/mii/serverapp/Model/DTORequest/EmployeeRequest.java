package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String email;
    private String name;
    private Integer phone;
    // private Integer userId;
    private String username;
    private String password;
    // private String roleName;
    

}
