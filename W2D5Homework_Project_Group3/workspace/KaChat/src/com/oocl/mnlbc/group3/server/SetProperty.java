package com.oocl.mnlbc.group3.server;
 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
/**
 * Creates config.properties for the server
 * @author vergajo
 *
 */
public class SetProperty {
  public static void main(String[] args) {
	
	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream("config\\config.properties");

		// set the properties value
		prop.setProperty("port", "5555");
		prop.setProperty("maxbacklog", "5");
		prop.setProperty("maxconnections", "20");

		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}