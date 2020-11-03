package by.grodno.pvt.site.webappsample.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import by.grodno.pvt.site.webappsample.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUserService implements UserRepository {

	private static UserRepository userService;

	public static UserRepository getService() {
		if (userService == null) {
			userService = new HibernateUserService();
		}
		return userService;
	}

	@Override
	public void addUser(User user) {
		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<User> getUsers() {

		EntityManager entityManager = HibernateUtil.getEntityManager().createEntityManager();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> cr = cb.createQuery(User.class);

		return entityManager.createQuery(cr.select(cr.from(User.class))).getResultList();

	}

	@Override
	public void deleteUser(Integer number) {

		EntityManager entityManager = HibernateUtil.getEntityManager().createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(new User(number, null, null, null, false));
		entityManager.getTransaction().commit();

	}
}
