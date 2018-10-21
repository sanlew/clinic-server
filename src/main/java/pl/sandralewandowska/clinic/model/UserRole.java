package pl.sandralewandowska.clinic.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
  
    @Id
    @SequenceGenerator(name="new_seq_user_role", sequenceName="useer_role_id_seq")
	@GeneratedValue(strategy = SEQUENCE ,generator="new_seq_user_role")
    @Column(name = "id", nullable = false)
    private Long id;
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",  nullable = false)
    private User user;
  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private AppRole appRole;
  
    public Long getId() {
        return id;
    }
  
    public void setId(Long id) {
        this.id = id;
    }
  
    public AppRole getAppRole() {
        return appRole;
    }
  
    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
  
}