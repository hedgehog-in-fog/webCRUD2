package project.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public List<User> allUser() {
		return userDao.allUser();
	}

	@Override
	public void add(User u) {
		userDao.add(u);
	}

	@Override
	public User getUserIdByEdit(String id) {
		long longId = Long.parseLong(id);
		return userDao.getUserIdByEdit(longId);
	}

	@Override
	public void delete(String id) {
		long longID =Long.parseLong(id);
		userDao.delete(longID);
	}

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
	}
//
//	@Override
//	public User getUserByDelete(String id) {
//		return userDao.getUserIdByDelete(id);
//	}
}
