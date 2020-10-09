package project.service;

import project.entity.User;

import java.util.List;

public interface UserService {
	List<User> allUser();
	void add(User u);
	User getUserIdByEdit(String id);
	void editUser(User user);
	void delete(String u);
	void addRoleAdmin(String u);
//	User getUserByDelete(String id);
}
