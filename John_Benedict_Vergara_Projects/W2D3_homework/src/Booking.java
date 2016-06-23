
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 	
 */
class Booking extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	Tickets tick;

	public Booking(int count, Socket socket, List<Socket> socketList, Tickets tick) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
		this.tick = tick;
	}

	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = null;
			while (true) {
//				System.out.println("Number of Tickets to Order: ");
				message = reader.readLine();
				// Client will quit if client send "bye", and print "bye" to in
				// the client
				if (message.equals("bye")) {
					writer = new PrintWriter(socket.getOutputStream());
					writer.println("bye");
					writer.flush();
					continue;
				}

				if (Integer.parseInt(message) <= tick.getNumTickets()) {
					tick.setNumTickets(tick.getNumTickets() - Integer.parseInt(message));

					for (int i = 0; i < socketList.size(); i++) {
						writer = new PrintWriter(socketList.get(i).getOutputStream());
						writer.println("Number of available tickets: " + tick.getNumTickets());
						writer.flush();
					}
				} else {
					for (int i = 0; i < socketList.size(); i++) {
						writer = new PrintWriter(socketList.get(i).getOutputStream());
						writer.println("Insufficient available Tickets");
						System.out.println("Order Again.");
						writer.flush();
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}