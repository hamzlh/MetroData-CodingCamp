package id.co.mii.serverapp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// import java.util.List;
// import org.hibernate.mapping.Set;
import java.util.Set;
import lombok.AllArgsConstructor;
// import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_role")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name", nullable = false, length = 50)
    private String name;
    
    @ManyToMany(mappedBy = "role")
    // @JsonIgnore
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonIgnoreProperties("role")
    private Set<User> user;


}
