package id.co.mii.serverapp.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import id.co.mii.serverapp.Model.Country;
import id.co.mii.serverapp.Model.Region;
import id.co.mii.serverapp.Model.DTORequest.CountryRequest;
import id.co.mii.serverapp.Repositories.CountryRepository;
import id.co.mii.serverapp.Repositories.RegionRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CountryService {
    private CountryRepository countryRepository;
    private RegionRepository regionRepository;
    private RegionService regionService;

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Country not found!!!"));
    }

    // without DTO
    public Country create(Country country) {
        if (countryRepository.existsByName(country.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Name is already exists!!! - Country");
        }

        if (regionRepository.findByName(country.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Name is already exists!!! - Region");
        }

        return countryRepository.save(country);
    }

    // with DTO
    public Country createDTO(CountryRequest countryRequest) {
        if (countryRepository.existsByName(countryRequest.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Name is already exists!!! - Country");
        }

        if (regionRepository.findByName(countryRequest.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Name is already exists!!! - Region");
        }

        Country country = new Country();
        country.setCode(countryRequest.getCode());
        country.setName(countryRequest.getName());

        Region region = regionService.getById(countryRequest.getRegionId());
        country.setRegion(region);
        return countryRepository.save(country);
    }

    public Country update(Integer id, Country country){
        getById(id);
        country.setId(id);
        return countryRepository.save(country);
    }

    public Country delete(Integer id){
        Country country = getById(id);
        countryRepository.delete(country);
        return country;
    }

    
}
