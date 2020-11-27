package by.grodno.pvt.site.webappsample.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.service.UserRepository;

@Service
public class HibernateUserService implements UserRepository {

	private EntityManagerFactory sessionProvider;

	public HibernateUserService(EntityManagerFactory sessionProvider) {
		this.sessionProvider = sessionProvider;
	}

	@Override
	public void addUser(OldUser user) {
		EntityManager entityManager = sessionProvider.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<OldUser> getUsers() {

		EntityManager entityManager = sessionProvider.createEntityManager();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<OldUser> cr = cb.createQuery(OldUser.class);

		return entityManager.createQuery(cr.select(cr.from(OldUser.class))).getResultList();

	}

	@Override
	public void deleteUser(Integer number) {

		EntityManager entityManager = sessionProvider.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(new OldUser(number, null, null, null, false));
		entityManager.getTransaction().commit();

	}
}
