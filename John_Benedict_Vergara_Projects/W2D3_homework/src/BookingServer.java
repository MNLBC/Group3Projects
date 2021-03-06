

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BookingServer {

	/**
	 * Description
	 * 
	 * @param args
	 */
	public void startWork() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2345);
		List<Socket> socketList = new ArrayList<Socket>();
		Tickets tick = new Tickets(500);
		Socket socket = null;
		int count = 0;
		while (true) {
			socket = serverSocket.accept();
			count++;
			System.out.println("Number of available tickets: " + tick.getNumTickets());
			// Add any connected client to the server
			socketList.add(socket);
			// Will open a new thread to process, once a new client connected.
			new Booking(count, socket, socketList, tick).start();
		}
	}

	/**
	 * Description
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BookingServer bookingServer = new BookingServer();
		bookingServer.startWork();
	}

}