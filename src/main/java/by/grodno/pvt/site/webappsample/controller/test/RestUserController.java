package by.grodno.pvt.site.webappsample.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.service.impl.JPAUserService;

@RestController
public class RestUserController {

	@Autowired
	private JPAUserService service;

	@GetMapping("/test/user/{id}")
	public User getUserById(@PathVariable Integer id) {
		return service.getUser(id);
	}

	@PutMapping("/test/user/{id}")
	public void updateUser(@RequestBody User user) {
		service.updateUserName(user);
	}
}
