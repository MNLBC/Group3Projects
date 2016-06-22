package w2.d3.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * Kanen Bookings' Server
 * 
 * @author BRIONSE
 * @version 1.0
 */
public class BookingServer {

	int planeTickets = 500;

	/**
	 * Listens for incoming ticket orders.
	 * 
	 * @throws IOException
	 */
	public void startWork() throws IOException {
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new ServerSocket(2345);
		Socket socket = null;

		int count = 0;

		while (true) {

			socket = serverSocket.accept();
			count++;
			System.out.println("Client" + count + " connected to the server!");

			// Get output stream associated with the socket

			OutputStream s1out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(s1out);

			dos.writeUTF("Welcome to Kanen Bookings!");
			dos.writeUTF("We have " + planeTickets + " ticketss available");

			// Get the numberOfTickets ordered by client
			InputStream serverIs = socket.getInputStream();
			DataInputStream dis = new DataInputStream(serverIs);

			int ticketsOrdered = Integer.parseInt(dis.readUTF());
			System.out.println("Client" + count + " ordered " + ticketsOrdered + " tickets.");

			getTickets(ticketsOrdered);

		}
	}

	/**
	 * Main method instantiates the BookingServer
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException {
		BookingServer chatServer = new BookingServer();
		chatServer.startWork();
	}

	/**
	 * Takes the number of tickets as an argument and deducts from the server's
	 * current plane ticket
	 * 
	 * @param number
	 * @return
	 */
	public synchronized int getTickets(int number) {

		if (number < 0) {
			System.out.println("Please enter a positive number.");
			return -1;
		} else if (number > planeTickets) {
			return -2;
		} else {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			planeTickets -= number;

			System.out.println("Number of plane tickets left: " + planeTickets);
			return number;
		}

	}

}
