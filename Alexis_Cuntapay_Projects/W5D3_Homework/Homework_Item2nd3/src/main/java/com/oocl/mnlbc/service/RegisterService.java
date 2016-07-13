package com.oocl.mnlbc.service;

public class RegisterService {
	public boolean testingRegistration(String username, String password, String email, String address,
			String mobile) {
		return (username != "" || password != "" || email != "" || address != "" || mobile != ""
				);
	}

}
