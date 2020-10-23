package by.grodno.pvt.site.webappsample.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

	private List<User> users = new ArrayList<User>();

	private static UserService userService;

	private UserService() {
		users.add(getUser(1, "Max", "Naumovich", fromString("1985-05-05"), true));
		users.add(getUser(2, "Sasha", "Alexandrov", fromString("1976-05-05"), true));
		users.add(getUser(3, "Masha", "Popova", fromString("2001-05-05"), false));
		users.add(getUser(4, "Siarozha", "Sergienko", fromString("1995-05-05"), true));
	}

	public static UserService getService() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getUsers() {
		return users;
	};

	public void deleteUser(Integer number) {
		users.remove(number.intValue());
	};

	public void addUser(User user) {
		user.setId(users.size());
		users.add(user);
	}

	private User getUser(int i, String string, String string2, Date fromString, boolean male) {
		return new User(i, string, string2, fromString, male);
	}

	private Date fromString(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
