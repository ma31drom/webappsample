package by.grodno.pvt.site.webappsample.controller;

import static org.junit.Assert.fail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.service.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService repo;

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody List<OldUser> user) {
		repo.addUser(user);
	}

	@GetMapping("/users")
	public List<OldUser> getAllUsers() {
		return repo.getUsers();
	}

	@GetMapping("/users/filter")
	public List<OldUser> findByExample(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam(value = "male", required = false) 
	          Boolean male) {
		OldUser oldUser = new OldUser(null, firstName, lastName, null, male);
		return repo.findByExample(oldUser);
	}

	@GetMapping("/users/page")
	public List<OldUser> getUsersPage(@RequestParam("pnum") Integer pnum, @RequestParam("psize") Integer psize) {
		return repo.getPage(pnum, psize).getContent();
	}

	@GetMapping("/users/{fname}")
	public List<OldUser> getUserByFName(@PathVariable("fname") String fname) {
		return repo.findByFName(fname);
	}
}
