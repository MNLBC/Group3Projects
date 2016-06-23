package w2.d3.homework;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class BookingClient {

	/**
	 * Booking Client for ordering plane Tickets 
	 * requests for the numberOfTickets
	 * @param args
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {

		try {

			Socket clientSocket = new Socket("127.0.0.1", 2345);

			// Get an input stream from the socket (data is coming from the
			// server)
			InputStream is = clientSocket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			// Read the message from the Booking Server and print it to the
			// client's screen
			System.out.println(dis.readUTF());
			System.out.println(dis.readUTF());

			System.out.println("Please enter number of tickets to order!");
			System.out.println("");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int noOfTicketsOrdered = Integer.parseInt(reader.readLine());

			OutputStream s1out = clientSocket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(s1out);
			dos.writeUTF("" + noOfTicketsOrdered);

			dos.close();
			dis.close();
			clientSocket.close();

		} catch (ConnectException connExc) {
			System.err.println("Unable to connect to the server.");
		} catch (IOException e) {

		}

	}

}