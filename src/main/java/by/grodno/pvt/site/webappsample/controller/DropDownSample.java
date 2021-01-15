package by.grodno.pvt.site.webappsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.repo.UserRepo;

@Controller
public class DropDownSample {

	@GetMapping("/dropdown")
	public String dropdown(Model model) {
		model.addAttribute("currentRole", UserRole.TEACHER);
		model.addAttribute("values", UserRole.values());
		return "dropdownSample";
	}

	@PostMapping("/dropdown")
	public String index(@RequestParam UserRole role) {
		System.out.println();
		return "redirect:/users";
	}

}
