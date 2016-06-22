package homeworkw2d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 
 * @author YUME
 * Used chat example for basis of the send class
 */
class BookSend extends Thread {
	private Socket socket;
/**
 * Constructor of BookSend
 * @param socket
 */
	public BookSend(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		BufferedReader input = null;
		PrintWriter writer = null;
		try {
			System.out.println("Good day, Welcome to Booking Ticket System.");
			System.out.println("Input number of tickets you'll buy or type in 'bye' to exit:");
			input = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(socket.getOutputStream());
			String message = null;
			while (true) {
				
				message = input.readLine();
				if (message.equals("bye")) {
					socket.close();
					System.exit(0);
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
