package by.grodno.pvt.site.webappsample.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.dto.Avatar;
import by.grodno.pvt.site.webappsample.dto.UserDTO;
import by.grodno.pvt.site.webappsample.exception.UserNotFoundException;
import by.grodno.pvt.site.webappsample.service.StorageService;
import by.grodno.pvt.site.webappsample.service.UserService;

@Controller
public class UsersSellingController {

	static public final Integer SIZE = 5;

	@Autowired
	private UserService service;
	@Autowired
	private ConversionService convertionService;

	@GetMapping("/users/buy/{id}")
	public String editUserForm(@PathVariable Integer id, HttpSession session) {

		List<UserDTO> attribute = getSoldUsers(session);

		if (attribute == null) {
			session.setAttribute("soldUsers", new ArrayList<User>());
		}

		getSoldUsers(session).add(convertionService.convert(service.getUser(id), UserDTO.class));

		return "redirect:/users";
	}

	private List<UserDTO> getSoldUsers(HttpSession session) {
		return (List<UserDTO>) session.getAttribute("soldUsers");
	}

	@GetMapping("/sold")
	public String sold(Model model, HttpSession session) {

		List<UserDTO> attribute = getSoldUsers(session);

		if (attribute == null) {
			session.setAttribute("soldUsers", new ArrayList<UserDTO>());
		}

		model.addAttribute("users", getSoldUsers(session));

		return "soldUserList";
	}

	@GetMapping("/sold/apply")
	public String soldApply(Model model, HttpSession session) {

		List<UserDTO> attribute = getSoldUsers(session);

		//cartService.submitOrder(attribute);

		session.setAttribute("soldUsers", new ArrayList<User>());
		
		return "sold";
	}
}
