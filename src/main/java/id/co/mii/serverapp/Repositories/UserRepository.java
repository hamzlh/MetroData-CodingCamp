package id.co.mii.serverapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.mii.serverapp.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
       
}
