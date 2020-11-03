package by.grodno.pvt.site.webappsample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import by.grodno.pvt.site.webappsample.model.User;

public class UserService implements UserRepository {

	private static UserService userService;

	public static final Logger LOGGER = Logger.getLogger(UserService.class);

	private UserService() {
	}

	public static UserRepository getService() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	@Override
	public List<User> getUsers() {
		List<User> result = new ArrayList<User>();
		try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL);

			while (rs.next()) {

				User user = mapRawToUser(rs);

				result.add(user);
			}

			rs.close();
		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

		return result;
	}

	private User mapRawToUser(ResultSet rs) throws SQLException {
		Integer id = rs.getInt(1);
		String fName = rs.getString(2);
		String lName = rs.getString(6);
		Date date = rs.getTimestamp(5);
		Boolean male = rs.getBoolean(7);
		User user = new User(id, fName, lName, date, male);
		return user;
	};

	@Override
	public void deleteUser(Integer number) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_BY_ID)) {

			stmt.setInt(1, number);

			stmt.execute();

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}

	};

	@Override
	public void addUser(User user) {
		try (Connection conn = DBUtils.getConnetion();
				PreparedStatement stmt = conn.prepareStatement(SQL.INSERT, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setTimestamp(4,
					Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(user.getBirthdate())));
			stmt.setBoolean(5, user.isMale());

			stmt.executeUpdate();

			ResultSet generatedKeys = stmt.getGeneratedKeys();
			generatedKeys.next();
			LOGGER.info("User created with id: " + generatedKeys.getLong(1));

		} catch (Exception e) {
			LOGGER.error("Something went wrong...", e);
		}
	}

}
