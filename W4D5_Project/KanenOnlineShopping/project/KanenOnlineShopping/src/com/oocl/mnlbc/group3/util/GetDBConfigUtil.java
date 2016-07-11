package com.oocl.mnlbc.group3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author GROUP3
 *
 *         Utility class for reading the database configuration
 */
public class GetDBConfigUtil {

	private String driver;
	private String user;
	private String password;
	private String hostname;
	private String port;
	private String sid;

	public GetDBConfigUtil() {
		initConfig();
	}

	/**
	 * retrieves the dbconfig.properties for the database connection
	 */
	public void initConfig() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			//input = new FileInputStream("dbconfig.properties");
			input = this.getClass().getClassLoader()
	                .getResourceAsStream("dbconfig.properties");
			
			// load the properties file
			prop.load(input);
			
			// get the property values
			this.driver = prop.getProperty("driver");
			this.user = prop.getProperty("user");
			this.password = prop.getProperty("password");
			this.hostname = prop.getProperty("hostname");
			this.port = prop.getProperty("port");
			this.sid = prop.getProperty("sid");

		} catch (IOException ex) {
			System.out.println("Unable to read database configuration file.");
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getDriver() {
		return driver;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getHostname() {
		return hostname;
	}

	public String getPort() {
		return port;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
