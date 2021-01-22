package by.grodno.pvt.site.webappsample.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import by.grodno.pvt.site.webappsample.domain.UserWIthId;
import by.grodno.pvt.site.webappsample.service.UserService;
import by.grodno.pvt.site.webappsample.service.impl.CarRentService;

@Controller
public class CarsController {

	@Autowired
	CarRentService carSerice;
	@Autowired
	UserService userService;

	@GetMapping("/cars")
	public String getCarsTable(Model model) {

		model.addAttribute("cars", carSerice.availableCars());

		return "carsList";
	}

	@GetMapping("/cars/rent/{carId}")
	public String rentCar(@PathVariable Integer carId, Model model) {
		Date startDate = new Date();
		Date endDate = new Date(startDate.getTime() + 20 * 1000);
		UserWIthId principal = (UserWIthId) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		carSerice.rentCar(userService.getUser(principal.getId()), carId, startDate, endDate);

		return "redirect:/cars";
	}
}
