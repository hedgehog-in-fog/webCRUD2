package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Role;
import project.repository.UserDao;
import project.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public List<User> allUser() {
		return userDao.allUser();
	}

	@Override
	public void add(User u) {
		User userFromDB = userDao.getUserByName(u.getName());
		if (userFromDB == null) {
			u.setRoleList(userDao.getRole("ROLE_USER"));
			userDao.add(u);
		}
	}

	@Override
	public User getUserIdByEdit(String id) {
		long longId = Long.parseLong(id);
		return userDao.getUserId(longId);
	}

	@Override
	public void delete(String id) {
		long longID =Long.parseLong(id);
		userDao.delete(longID);
	}

	@Override
	public void editUser(User user) {
		user.setRoleList(userDao.getUserId(user.getId()).getRoleList());
		userDao.editUser(user);
	}

	@Override
	public void addRoleAdmin(String id) {
		User user = userDao.getUserId(Long.parseLong(id));
		List<Role> roleUser = user.getRoleList();
		List<Role> role= userDao.getRole("ROLE_ADMIN");
		role.addAll(roleUser);
		user.setRoleList(role);
		userDao.addRoleAdmin(user);
	}

	//
//	@Override
//	public User getUserByDelete(String id) {
//		return userDao.getUserIdByDelete(id);
//	}
}
