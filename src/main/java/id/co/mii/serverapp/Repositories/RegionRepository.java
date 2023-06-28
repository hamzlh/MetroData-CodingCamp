package id.co.mii.serverapp.Repositories;

import id.co.mii.serverapp.Model.Region;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    // JPQL
    @Query("SELECT r FROM Region r WHERE r.name = ?1") //position base parameter
    public List<Region> findAllName(String name);

    // Native Query 
    @Query(
        value = "SELECT * FROM TB_REGION WHERE REGION_NAME = :name",
        nativeQuery = true
    )
    public List<Region> findAllNameNative(@Param("name") String name);

    // Query Method
    public Optional<Region> findByName(String name);
    
    
}