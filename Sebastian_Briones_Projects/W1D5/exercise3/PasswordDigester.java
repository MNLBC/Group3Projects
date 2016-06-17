package com.oocl.w1d5.exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * A stand-alone character mode program that reads from standard input and
 * encrypts
 * 
 * @author BRIONSE
 *
 */
public class PasswordDigester {

	// for reading
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {

		System.out.println("Please input your password!");
		StringBuffer passwordBuffer = new StringBuffer();
		try {

			passwordBuffer.append(reader.readLine());
			String encryptedPassword = encryptByMD5(passwordBuffer.toString());

			printPassword(encryptedPassword);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	/**
	 * Encrypts a password using MD5
	 * 
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptByMD5(String password) throws NoSuchAlgorithmException {

		MessageDigest msgDigester = MessageDigest.getInstance("MD5");
		byte[] messageByte = msgDigester.digest(password.getBytes());

		BigInteger number = new BigInteger(1, messageByte);

		String encryptedPassword = number.toString(16);
		while (encryptedPassword.length() < 32) {
			encryptedPassword = "0" + encryptedPassword;
		}
		return encryptedPassword;
	}

	/**
	 * 
	 * Writes the encrypted password to the textfile
	 * 
	 * @param encryptedPassword
	 * @throws IOException
	 */
	public static void printPassword(String encryptedPassword) throws IOException {

		File file = new File("D:\\passwords\\digested-password.txt");
		file.getParentFile().mkdirs();
		file.createNewFile();

		FileWriter writer = new FileWriter(file);
		writer.append(encryptedPassword);
		writer.flush();
		writer.close();

		System.out.println("Encrypted password successfully saved to file!");

	}

}
