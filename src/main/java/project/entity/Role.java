package project.entity;

import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority{

    @ManyToMany
    @JoinTable(name="users_roles",
            joinColumns=@JoinColumn(name="role_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<User> userList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long Id;

    @Column(name = "name")
    private  String roleName;

    public Role(List<User> userList, long id, String roleName) {
        this.userList = userList;
        Id = id;
        this.roleName = roleName;
    }

    public Role(){}

    public long getId() {
        return Id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}
