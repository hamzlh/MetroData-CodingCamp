package id.co.mii.serverapp.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Column(name = "employee_name", nullable = false, length = 50)
    private String name;

    @Column(name = "employee_email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "employe_phone", nullable = false, unique = true)
    private Integer phone;

    @OneToOne(mappedBy = "employee")
    private User user;


}
