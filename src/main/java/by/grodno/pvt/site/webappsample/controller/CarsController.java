package by.grodno.pvt.site.webappsample.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.grodno.pvt.site.webappsample.domain.Car;
import by.grodno.pvt.site.webappsample.domain.UserWIthId;
import by.grodno.pvt.site.webappsample.dto.CarsListDTO;
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

	@GetMapping("/cars/counting")
	public String getCountSelector(Model model) {
		return "addCarsCount";
	}
	
	@GetMapping("/cars/add")
	public String getCarsAddingPage(@RequestParam Integer count, Model model) {

		List<Car> car = IntStream.range(0, count).mapToObj(i -> new Car()).collect(Collectors.toList());

		model.addAttribute("carsListDTO", new CarsListDTO(car));

		return "addCarsList";

	}

	@PostMapping("/cars/add")
	public String createCars(@ModelAttribute CarsListDTO carsListDTO, Model model) {

		carSerice.save(carsListDTO.getCars());

		model.addAttribute("cars", carSerice.availableCars());
		
		return "carsList";

	}

}
