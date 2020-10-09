package project.repository;

import project.entity.Role;
import project.entity.User;

import java.util.List;

public interface UserDao {
	List<User> allUser();
	void add(User user);
	User getUserId(long id);
	void delete(long user);
	void editUser(User user);
	User getUserByName(String name);
	void addRoleAdmin(User user);
	List<Role> getRole(String role);
//	User getUserIdByDelete(String id);
}
