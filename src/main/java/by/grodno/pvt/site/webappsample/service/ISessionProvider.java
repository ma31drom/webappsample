package by.grodno.pvt.site.webappsample.service;

import org.hibernate.SessionFactory;

public interface ISessionProvider {
	SessionFactory getEntityManager();
}
