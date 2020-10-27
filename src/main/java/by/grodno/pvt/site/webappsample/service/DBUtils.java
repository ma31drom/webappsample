package by.grodno.pvt.site.webappsample.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBUtils {

	private static final String RESOURCE_BUNDLE_NAME = "db";

	public static Connection getConnetion() throws Exception {

		ResourceBundle dp = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME);

		Class.forName(dp.getString("driver"));

		Connection connection = DriverManager.getConnection(dp.getString("url"), dp.getString("username"),
				dp.getString("password"));

		return connection;
	}

}
