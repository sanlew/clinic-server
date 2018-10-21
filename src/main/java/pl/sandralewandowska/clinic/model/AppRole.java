package pl.sandralewandowska.clinic.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "app_role")
public class AppRole {
       
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
     
    @Id
	@SequenceGenerator(name="new_seq_app_role", sequenceName="app_role_id_seq")
	@GeneratedValue(strategy = SEQUENCE ,generator="new_seq_app_role")
    @Column(name = "id", nullable = false)
    private Long id;
  
    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;
  
    public Long getRoleId() {
        return id;
    }
  
    public void setRoleId(Long id) {
        this.id = id;
    }
  
    public String getRoleName() {
        return roleName;
    }
  
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
     
}