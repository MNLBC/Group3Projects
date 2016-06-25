package com.oocl.mnlbc.group3.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetServerProperty {
	

	private String maxBackLog;
	private String maxConnections;
	private String port;
	
	public GetServerProperty(){
		readConfig();
	}


	public String getMaxBackLog() {
		return maxBackLog;
	}


	public String getMaxConnections() {
		return maxConnections;
	}

	public String getPort() {
		return port;
	}



 
  public void readConfig(){
	  Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config\\config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			this.port=prop.getProperty("port");
			this.maxBackLog=prop.getProperty("maxbacklog");
			this.maxConnections=prop.getProperty("maxconnections");

		} catch (IOException ex) {
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
}
