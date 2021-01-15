package by.grodno.pvt.site.webappsample.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import by.grodno.pvt.site.webappsample.exception.UserDiedException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(UserDiedException.class)
	public String handleUserNotFoundException(UserDiedException ex, Model model) {
		model.addAttribute("userId", ex.getUserId());
		return "errors/userDied";
	}
	
	
}
