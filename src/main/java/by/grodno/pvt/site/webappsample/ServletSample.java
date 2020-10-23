package by.grodno.pvt.site.webappsample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletSample extends HttpServlet {

	private static final String NAME = "name";
	private static final String WORLD = "World";

	public String env;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		storeNameInSession(req);

		String name = getNameFromSession(req);

		String testCookie = getTestCookie(req, resp);

		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		if (testCookie != null) {
			writer.print("Cookie: ".concat(testCookie).concat("<br/><br/><br/>"));
		}

		writer.print("We are running in ".concat(env).concat("<br/>"));
		writer.print("Hello PVT ".concat(name).concat("! <b>RequestCount is ")
				.concat(String.valueOf(((AtomicInteger) getServletContext().getAttribute("counter")).incrementAndGet()))
				.concat("</b>").concat("<br/>"));
		writer.print("<br/>");

		ServletContext servletContext = getServletContext();

		servletContext.getRequestDispatcher("/hello2").include(req, resp);

		writer.print("<br/>");
		Enumeration<String> headerNames = req.getHeaderNames();
		StringBuilder sb = new StringBuilder();
		while (headerNames.hasMoreElements()) {
			String string = (String) headerNames.nextElement();
			sb.append(string.concat(" ").concat(req.getHeader(string)).concat("<br/>"));
		}

		writer.print(sb.toString());
	}

	private String getTestCookie(HttpServletRequest req, HttpServletResponse resp) {
		Cookie[] cookies = req.getCookies();
		String testCookie = null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().contentEquals("test")) {
				testCookie = cookie.getValue();
			}
		}

		if (testCookie == null) {
			Cookie cookie2 = new Cookie("test", "COOKIE_VALUE");
			cookie2.setMaxAge(10);
			resp.addCookie(cookie2);
		}
		return testCookie;
	}

	private String getNameFromSession(HttpServletRequest req) {
		String name = WORLD;
		Object attribute = req.getSession().getAttribute(NAME);
		if (attribute != null) {
			name = attribute.toString();
		}
		return name;
	}

	private void storeNameInSession(HttpServletRequest req) {
		String parameter = req.getParameter(NAME);
		if (parameter != null) {
			req.getSession().setAttribute(NAME, parameter);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		env = config.getInitParameter("env");
		config.getServletContext().setAttribute("counter", new AtomicInteger(0));
		super.init(config);
	}

}
