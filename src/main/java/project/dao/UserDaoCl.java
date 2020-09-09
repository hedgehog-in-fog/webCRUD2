package project.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoCl implements UserDao {


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
	public User getUserIdByEdit(long longID) {
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

//	@Override
//	public User getUserIdByDelete(String id) {
//		return (User) entityManager.createQuery("from User where id ="+ id).getSingleResult();
//	}
}
