package id.co.mii.serverapp.Model.DTORequest;

import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryRequest {
    private String code;
    private String name;
    private Integer regionId;
}
