package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String email;
    private String name;
    private String phone;
    private Integer userId;

}
