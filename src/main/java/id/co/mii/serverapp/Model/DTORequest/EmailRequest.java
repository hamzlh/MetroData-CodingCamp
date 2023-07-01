package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailRequest {
    private String to;
    private String subject;
    private String text;
    private String attach;

}
