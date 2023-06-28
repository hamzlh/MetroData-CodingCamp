package id.co.mii.serverapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.mii.serverapp.Model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    // Query Method

    public Boolean existsByName(String name);
    
}
