package by.grodno.pvt.site.webappsample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.pvt.site.webappsample.service.HibernateUserService;

public class JstlServlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("number");

		HibernateUserService.getService().deleteUser(Integer.valueOf(parameter));

		resp.sendRedirect("/webappsample/jstl1");
	}

}
