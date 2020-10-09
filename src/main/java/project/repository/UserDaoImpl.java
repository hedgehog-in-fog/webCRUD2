package project.repository;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.entity.Role;
import project.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public List<User> allUser() {
		Query cq = entityManager.createQuery("from User");
		return cq.getResultList();
	}

	@Transactional
	@Override
	public void add(User user) {
		entityManager.persist(user);
	}

	@Override
	public User getUserId(long longID) {
		return (User) entityManager.createQuery("from User where id =:longID")
				.setParameter("longID", longID)
				.getSingleResult();
	}

	@Transactional
	@Override
	public void delete(long user) {
		entityManager.remove(entityManager.createQuery("from User where id =:id")
				.setParameter("id", user)
				.getSingleResult());
	}

	@Transactional
	@Override
	public void editUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserByName(String name) {
			User user = (User) entityManager.createQuery("from User where name =:name").setParameter("name", name).getResultList().stream().findFirst().orElse(null);
		return user;
	}

	@Transactional
	@Override
	public void addRoleAdmin(User user) {
		entityManager.persist(user);

	}

	@Override
	public List<Role> getRole(String role) {
		return entityManager.createQuery("from Role where name=:role").setParameter("role", role).getResultList();
	}
	//	@Override
//	public User getUserIdByDelete(String id) {
//		return (User) entityManager.createQuery("from User where id ="+ id).getSingleResult();
//	}
}
