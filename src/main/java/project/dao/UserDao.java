package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
	List<User> allUser();
	void add(User user);
	User getUserIdByEdit(long id);
	void delete(long user);
	void editUser(User user);
//	User getUserIdByDelete(String id);
}
