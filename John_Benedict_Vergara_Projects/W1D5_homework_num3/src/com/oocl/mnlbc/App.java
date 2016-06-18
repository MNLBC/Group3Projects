/**
 * 
 */
package com.oocl.mnlbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * @author vergajo
 *
 */
public class App {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String password;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter password to encrypt: ");
		password = scan.nextLine();

		StringBuffer sb = new StringBuffer();
		sb.append(password);

		System.out.println("MD5 in hex: " + md5(sb.toString()));

		File file = new File("D:\\digested-password.txt");
		// creates the file
		
		file.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file);
		// Writes the content to the file
		writer.write("Digested-password: \t" + md5(sb.toString()));
		writer.flush();
		writer.close();
	}

	public static String md5(String input) {

		String md5 = null;

		if (null == input)
			return null;
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}

}
