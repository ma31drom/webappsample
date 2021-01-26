package by.grodno.pvt.site.webappsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.grodno.pvt.site.webappsample.domain.UserRole;
import by.grodno.pvt.site.webappsample.dto.DropDownDTO;
import by.grodno.pvt.site.webappsample.repo.UserRepo;

@Controller
public class MultiDropDownSample {

	@GetMapping("/dropdown/multi")
	public String dropdown(Model model) {
		
		model.addAttribute("values", UserRole.values());
		
		model.addAttribute("dto", new DropDownDTO());
		
		return "dropdownMultiSample";
	}

	@PostMapping("/dropdown/multi")
	public String index(DropDownDTO dto) {
		System.out.println();
		return "redirect:/users";
	}

}
