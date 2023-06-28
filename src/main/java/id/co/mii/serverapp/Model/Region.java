package id.co.mii.serverapp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_region")
public class Region{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "region_id")
  private Integer id;

  @Column(name = "region_name", nullable = false, length = 50)
  private String name;

  @OneToMany(mappedBy = "region")
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private List<Country> countries;
}
