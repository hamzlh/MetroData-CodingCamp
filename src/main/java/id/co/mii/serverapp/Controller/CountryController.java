package id.co.mii.serverapp.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.mii.serverapp.Model.Country;
import id.co.mii.serverapp.Model.DTORequest.CountryRequest;
import id.co.mii.serverapp.Service.CountryService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {
    
    private CountryService countryService;

    @GetMapping
    public List<Country> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public Country getById(@PathVariable Integer id){
        return countryService.getById(id);
    }

    @PostMapping
    public Country create(@RequestBody Country country){
        return countryService.create(country);
    }

    // with DTO
    @PostMapping("/dto")
    public Country createDTO(@RequestBody CountryRequest countryRequest){
        return countryService.createDTO(countryRequest);
    }

    // with DTO model mapper
    @PostMapping("/dto-mm")
    public Country createDTOModelMapper(@RequestBody CountryRequest countryRequest){
        return countryService.createDTOModelMapper(countryRequest);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Integer id, @RequestBody Country country){
        return countryService.update(id, country);
    }

    @DeleteMapping("/{id}")
    public Country delete(@PathVariable Integer id){
        return countryService.delete(id);
    }
}
