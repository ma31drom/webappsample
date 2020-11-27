package by.grodno.pvt.site.webappsample.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.service.UserRepository;

@Service
public class HibernateUserService implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private TransactionTemplate txTemplate;

	@Override
	public void addUser(List<OldUser> users) {

		txTemplate.execute(tx -> {
			for (OldUser user : users) {
				entityManager.persist(user);
			}
			return null;
		});

	}

	@Override
	public List<OldUser> getUsers() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<OldUser> cr = cb.createQuery(OldUser.class);

		return entityManager.createQuery(cr.select(cr.from(OldUser.class))).getResultList();

	}

	@Override
	public void deleteUser(Integer number) {

		entityManager.getTransaction().begin();
		entityManager.remove(new OldUser(number, null, null, null, false));
		entityManager.getTransaction().commit();

	}
}
