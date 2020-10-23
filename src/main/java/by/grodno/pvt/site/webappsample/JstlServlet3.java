package by.grodno.pvt.site.webappsample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

public class JstlServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("number");

		UserService.getService().deleteUser(Integer.valueOf(parameter));

		resp.sendRedirect("/webappsample/jstl1");
	}

}
