package by.grodno.pvt.site.webappsample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.repo.UserRepo;
import by.grodno.pvt.site.webappsample.service.UserService;

@Service
@Transactional
public class JPAUserService implements UserService {

	@Autowired
	private UserRepo repo;

	@Override
	public void addUser(List<OldUser> users) {
		repo.saveAll(users);
	}

	@Override
	public List<OldUser> getUsers() {
		return repo.findAll();
	}

	@Override
	public void deleteUser(Integer number) {
		repo.deleteById(number);
	}

	@Override
	public List<OldUser> findByExample(OldUser userSample) {
		Example<OldUser> exp = Example.of(userSample,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
		return repo.findAll(exp);
	}

	@Override
	public Page<OldUser> getPage(Integer pageNum, Integer pageSize) {
		return repo.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.ASC, "firstName"));
	}

	@Override
	public List<OldUser> findByFName(String fname) {
		return repo.findByFirstName(fname);
	}
}
