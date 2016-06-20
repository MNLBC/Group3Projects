package homework5b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * 
 * @author cuntaal
 * @version 1
 */
public class App {

	public static void main(String[] args) throws NoSuchAlgorithmException,
			IOException {
		// Enter Password
		System.out.println("Welcome please enter Password: ");
		Scanner input = new Scanner(System.in);
		StringBuffer buff = new StringBuffer(input.next());
		String message = buff.toString();

		MessageDigest m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(message.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		// Saving Password in file
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"digested-password.txt"));
		out.write(hashtext);
		out.close();
		System.out.println("Password saved in digested-password.txt");
	}

}