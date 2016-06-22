package homework_booking;
/**
 * 
 * @author CUNTAAL
 * @version1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BookingSend extends Thread{
	private Socket socket;
	private int ticket;
	
	public BookingSend(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader input = null;
		PrintWriter writer = null;
		//Ask to input number of tickets
		try {
			System.out.println("Hi! Can I get how many tickets will you buy?");
			input = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			String message = null;
			while (true) {
				message = input.readLine();
				if (message.equals("bye")) {
					break;
				}
				writer.println(message);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}
}
