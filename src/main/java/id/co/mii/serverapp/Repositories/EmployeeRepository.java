package id.co.mii.serverapp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.mii.serverapp.Model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    public Optional<Employee> findByEmail(String email);
}
