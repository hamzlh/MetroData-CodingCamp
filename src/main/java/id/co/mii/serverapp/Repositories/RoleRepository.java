package id.co.mii.serverapp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.mii.serverapp.Model.Employee;
import id.co.mii.serverapp.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Optional<Employee> findByName(String name);
}
