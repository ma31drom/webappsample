package by.grodno.pvt.site.webappsample.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.UserDTO;
import by.grodno.pvt.site.webappsample.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;
	@Autowired
	private ConversionService convertionService;

	@PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody List<OldUser> user) {
		userService.addUser(user);
	}

	@GetMapping("/users")
	public String getAllUsers(Model model) {

		List<UserDTO> users = userService.getUsers()
				.stream()
				.map(u -> convertionService.convert(u, UserDTO.class))
				.collect(Collectors.toList());
		
		model.addAttribute("users", users);

		return "userList";
	}

	@GetMapping("/users/filter")
	public List<OldUser> findByExample(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam(value = "male", required = false) Boolean male) {
		OldUser oldUser = new OldUser(null, firstName, lastName, null, male);
		return userService.findByExample(oldUser);
	}

	@GetMapping("/users/page")
	public List<OldUser> getUsersPage(@RequestParam("pnum") Integer pnum, @RequestParam("psize") Integer psize) {
		return userService.getPage(pnum, psize).getContent();
	}

	@GetMapping("/users/{fname}")
	public List<OldUser> getUserByFName(@PathVariable("fname") String fname) {
		return userService.findByFName(fname);
	}
}
