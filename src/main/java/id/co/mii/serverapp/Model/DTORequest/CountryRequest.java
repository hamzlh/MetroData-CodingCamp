package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    private String code;
    private String name;
    private Integer regionId;
}
