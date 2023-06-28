package id.co.mii.serverapp.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import id.co.mii.serverapp.Model.Region;
import id.co.mii.serverapp.Repositories.RegionRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegionService {

  private RegionRepository regionRepository;

  public List<Region> getAll() {
    return regionRepository.findAll();
  }

  public Region getById(Integer id) {
    return regionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Region not found!!!"));
  }

  public Region create(Region region) {
    if (regionRepository.findByName(region.getName()).isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Name already exsist!!!");
    }
    return regionRepository.save(region);
  }

  public Region update(Integer id, Region region) {
    getById(id);
    region.setId(id);
    return region;
  }

  public Region delete(Integer id){
    Region region = getById(id);
    regionRepository.delete(region);
    return region;
  }
  
  // JPQL
  public List<Region> findAllName(String name) {
    return regionRepository.findAllName(name);
  }

  // Native
  public List<Region> findAllNameNative(String name){
    return regionRepository.findAllNameNative(name);
  }
}