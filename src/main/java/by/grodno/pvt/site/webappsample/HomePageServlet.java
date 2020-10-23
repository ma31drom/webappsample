package by.grodno.pvt.site.webappsample;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OurTestJavaBean o = new OurTestJavaBean();
		o.setValue("Something from real servlet");
		req.getSession().setAttribute("data1", "Something from real servlet");

		getServletContext().getRequestDispatcher("/test.jsp").forward(req, resp);
	}

}
