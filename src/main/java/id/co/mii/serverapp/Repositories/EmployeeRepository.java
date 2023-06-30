package id.co.mii.serverapp.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import java.util.List;
import id.co.mii.serverapp.Model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
    public Boolean existsByEmail(String email);

    // @Query("SELECT e FROM Employee e")
    // public List<Employee> getAllEmployees();

}
