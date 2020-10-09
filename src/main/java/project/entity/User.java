package project.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "age")
	private int age;

	@Column(name = "role")
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name="users_roles",
			joinColumns=@JoinColumn (name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<Role> roleList;

	public User(Long id, String name, String password, int age, List<Role> roleList) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.roleList = roleList;
	}

	public User(){}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public int getAge() {
		return age;
	}

	public String getName(){return name;}

	public List<Role> getRoleList(){return roleList;}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roleList;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", age=" + age +
				", roleList=" + roleList +
				'}';
	}
}
