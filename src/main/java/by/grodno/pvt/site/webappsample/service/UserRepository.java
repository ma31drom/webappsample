package by.grodno.pvt.site.webappsample.service;

import java.util.List;

import by.grodno.pvt.site.webappsample.model.User;

public interface UserRepository {

	List<User> getUsers();

	void addUser(User user);

	void deleteUser(Integer number);

}
