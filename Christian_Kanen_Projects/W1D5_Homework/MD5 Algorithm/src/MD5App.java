import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * MD5 Algorithm
 * @author KANENCH
 *
 */
public class MD5App {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuffer strbuff;
		String toEncrypt;
		
		//Input of Password from user
		System.out.println("Enter a Password");
		toEncrypt = scan.nextLine();
		
		//Password is stored in String Buffer
		strbuff = new StringBuffer(toEncrypt);
		
		//Start of encryption
		System.out.println("Encrypting...");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(strbuff.toString().getBytes());

		//Putting it in a text file
		FileWriter write = null;
		File file = new File("digested-password.txt");
		file.createNewFile();
		write = new FileWriter(file);
		write.append(hash.toString());
		
		write.flush();
		write.close();
		System.out.println("Encrypting Success!!");
		
	}
}
