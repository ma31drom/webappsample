package by.grodno.pvt.site.webappsample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import by.grodno.pvt.site.webappsample.domain.OldUser;

public interface UserService {

	List<OldUser> getUsers();
	
	OldUser getUser(Integer id);
	
	void addUser(List<OldUser> user);

	void saveUser(OldUser user);
	
	void deleteUser(Integer number);

	List<OldUser> findByExample(OldUser userSample);

	Page<OldUser> getPage(Integer pageNum, Integer pageSize);

	List<OldUser> findByFName(String fname);

	Optional<OldUser> findByUserName(String userName);
}
