import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5Encrypt {
	/**
	 * This is the main
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String toEncrypt;
		toEncrypt= input.nextLine();
		inputToStringBuffer(toEncrypt);
		
	}
	/**
	 * this method uses the MD5 Algorithm to encrypt the StringBuffer
	 * @param sb
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static void encryptInput(StringBuffer sb) throws NoSuchAlgorithmException, IOException{
		 System.out.println("Encrypting"); 
		MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(String.valueOf(sb).getBytes());
	    byte[] hash = md.digest();
	    System.out.println(md.digest()); 
	    putInFile(hash);
	}
	/**
	 * this method captures the input to StringBuffer
	 * @param input
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static void inputToStringBuffer(String input) throws NoSuchAlgorithmException, IOException{

		      StringBuffer sb = new StringBuffer("");
		      sb.append(input);
		      System.out.println(sb); 
		      
		      encryptInput(sb);
		     
	}
	/**
	 * this method puts the encrypted data into the file.
	 * @param hash
	 * @throws IOException
	 */
	public static void putInFile(byte[] hash) throws IOException{
		 System.out.println("Adding to file"); 
		File file = new File("D:\\buffer\\digested-password.txt");
		file.getParentFile().mkdirs();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		writer.append("Digested-Password: ");
		writer.append(""+hash);

		writer.flush();
		writer.close();
		
	}
	
	

}
