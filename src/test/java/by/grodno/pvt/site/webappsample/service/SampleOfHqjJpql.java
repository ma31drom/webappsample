package by.grodno.pvt.site.webappsample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import by.grodno.pvt.site.webappsample.domain.Credentials;
import by.grodno.pvt.site.webappsample.domain.Role;
import by.grodno.pvt.site.webappsample.domain.User;

public class SampleOfHqjJpql {

	@Test
	public void testHql() {

		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();

		Credentials creds1 = new Credentials();
		creds1.setActive(true);
		creds1.setCreateDate(new Date());
		creds1.setPassword("SomePass");

		entityManager.persist(creds1);

		Credentials creds2 = new Credentials();
		creds2.setActive(false);
		creds2.setCreateDate(new Date());
		creds2.setPassword("SomePass");
		entityManager.persist(creds2);

		User user = new User();
		user.setEmail("bla1@bla.bla");
		user.setLastName("adgha");
		user.setLogin("12345678");
		user.setRole(Role.STUDENT);

		ArrayList<Credentials> arrayList = new ArrayList<Credentials>();
		arrayList.add(creds1);
		arrayList.add(creds2);

		user.setCredentials(arrayList);
		entityManager.persist(user);

		creds1.setOwnerUser(user);
		creds2.setOwnerUser(user);

		entityManager.persist(creds1);
		entityManager.persist(creds2);

		entityManager.getTransaction().commit();

	}

	@Test
	public void getFilteringByRole() {

		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();

		Query<User> createQuery = entityManager.createQuery("from User u where u.role = " + Role.ADMIN.ordinal(),
				User.class);

		createQuery.getResultList().forEach(System.out::println);

		entityManager.getTransaction().commit();
	}

	@Test
	public void getFilteringJoin() {

		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();

		Query<User> createQuery = entityManager
				.createQuery("select u from User u join u.credentials c on c.active = 'TRUE'", User.class);

		List<User> resultList = createQuery.getResultList();
		resultList.forEach(System.out::println);

		entityManager.getTransaction().commit();
	}

	@Test
	public void getFilteringJoinWithJpaCriteria() {

		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> createQuery = cb.createQuery(User.class);

		Root<User> from = createQuery.from(User.class);

		CriteriaQuery<User> where = createQuery.select(from).where(cb.equal(from.get("role"), Role.ADMIN.ordinal()));

		List<User> resultList = entityManager.createQuery(where).getResultList();
		resultList.forEach(System.out::println);
		entityManager.getTransaction().commit();
	}

	@Test
	public void getFilteringJoinCriteria() {

		Session entityManager = HibernateUtil.getEntityManager().getCurrentSession();

		entityManager.getTransaction().begin();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> q = cb.createQuery(User.class);

		Root<User> users = q.from(User.class);
		Join<Object, Object> join = users.join("credentials", JoinType.INNER);

		q.where(cb.equal(join.get("active"), Boolean.TRUE));

		List<User> resultList = entityManager.createQuery(q).getResultList();
		resultList.forEach(System.out::println);

		entityManager.getTransaction().commit();
	}

}
