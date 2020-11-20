package by.grodno.pvt.site.webappsample.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grodno.pvt.site.webappsample.model.OldUser;
import by.grodno.pvt.site.webappsample.service.ISessionProvider;
import by.grodno.pvt.site.webappsample.service.UserRepository;

@Component
public class HibernateUserService implements UserRepository {

	@Autowired
	private ISessionProvider sessionProvider;

	public HibernateUserService(ISessionProvider sessionProvider) {
		this.sessionProvider = sessionProvider;
	}
	
	@Override
	public void addUser(OldUser user) {
		Session entityManager = sessionProvider.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

	@Override
	public List<OldUser> getUsers() {

		EntityManager entityManager = sessionProvider.getEntityManager().createEntityManager();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<OldUser> cr = cb.createQuery(OldUser.class);

		return entityManager.createQuery(cr.select(cr.from(OldUser.class))).getResultList();

	}

	@Override
	public void deleteUser(Integer number) {

		EntityManager entityManager = sessionProvider.getEntityManager().createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(new OldUser(number, null, null, null, false));
		entityManager.getTransaction().commit();

	}
}
