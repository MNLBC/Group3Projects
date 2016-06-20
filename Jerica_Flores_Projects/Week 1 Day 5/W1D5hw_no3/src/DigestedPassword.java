import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Scanner;
/**
 * 
 * @author FLOREJE
 *
 */

public class DigestedPassword {
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		String password;
		System.out.println("Enter your password: ");
		Scanner input = new Scanner(System.in);
		password = input.nextLine();
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        System.out.println("Digested Password: " + sb.toString());
        System.out.println("Adding to file...\nSuccess...");
        
        File file = new File("D:\\ITAMNL\\W1D5hw_no3\\src\\digested-password.txt");
        
		  // creates the file
	      file.createNewFile();
	      
	      // creates a FileWriter Object
	      FileWriter writer = new FileWriter(file); 
	      
	      // Writes the content to the file
	      writer.write("Digested Password: "+sb.toString()); 
	      writer.flush();
	      writer.close();
        
    	}

	}
