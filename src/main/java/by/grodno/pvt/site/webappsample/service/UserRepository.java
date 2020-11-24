package by.grodno.pvt.site.webappsample.service;

import java.util.List;

import by.grodno.pvt.site.webappsample.domain.OldUser;

public interface UserRepository {

	List<OldUser> getUsers();

	void addUser(OldUser user);

	void deleteUser(Integer number);

}
