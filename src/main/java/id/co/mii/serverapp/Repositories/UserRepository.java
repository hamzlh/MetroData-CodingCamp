package id.co.mii.serverapp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.mii.serverapp.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    //    public Boolean existsByUsername(String username);
    public Optional<User> findByUsername(String username);
}
