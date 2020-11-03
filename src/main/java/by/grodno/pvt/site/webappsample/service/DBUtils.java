package by.grodno.pvt.site.webappsample.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DBUtils {

	private static final String RESOURCE_BUNDLE_NAME = "db";

	public static final Logger LOGGER = Logger.getLogger(DBUtils.class);

	public static Connection getConnetion() throws ClassNotFoundException, SQLException {

		ResourceBundle dp = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);
		Class.forName(dp.getString("driver"));

		Connection connection = DriverManager.getConnection(dp.getString("url"), dp.getString("username"),
				dp.getString("password"));

		return connection;
	}

}
