package homeworkw2d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * @author YUME
 * Used chat example for basis of the read class
 */
class BookRead extends Thread {
	private Socket socket;
	int Tickets=500;
	public BookRead(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String message = null;
			while (true) {
				message = reader.readLine();
				if (message.equals("bye")) {
					socket.close();
					System.exit(0);
				}

				
				System.out.println(message);
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Good day, Welcome to Booking Ticket System.");
			System.out.println("Input number of tickets you'll buy or type in 'bye' to exit:");
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}