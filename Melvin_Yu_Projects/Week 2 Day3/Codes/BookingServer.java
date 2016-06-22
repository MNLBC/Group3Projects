package homeworkw2d3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer {

	/**
	 * Used Chat Example as basis for this booking server
	 * Called Ticket to create and instance of Ticket
	 * that will be used for the booking so multiple users 
	 * can buy tickets
	 * @param args
	 */

	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		Ticket tick = new Ticket(500);
		List<Socket> socketList = new ArrayList<Socket>();
		Socket socket = null;
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println(count + " clinet connected to the server!");
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Booking(count, socket, socketList,tick).start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		
		BookingServer chatServer = new BookingServer();
		chatServer.startWork();
	}

}