package homeworkw2d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * 
 * @author YUME
 * Used Chat Example as basis for this class. run method 
 * and added ticket to the constructor
 *
 */
class Booking extends Thread {
	private Socket socket;
	private List<Socket> socketList;
	private int count;
	Ticket tick;
/**
 * 
 * @param count
 * @param socket
 * @param socketList
 * @param tick
 */
	public Booking(int count, Socket socket, List<Socket> socketList, Ticket tick) {
		this.count = count;
		this.socket = socket;
		this.socketList = socketList;
		this.tick = tick;

	}

	/**
	 * Thread of Booking.
	 */
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String message = null;
			while (true) {
				message = reader.readLine();
				// Client will quit if client send "bye"
				if (message.equals("bye")) {
					socket.close();
					System.exit(0);
				}
				int bookedTickets=Integer.parseInt(message);
				String mesToClient="";
if(tick.getTickets()<bookedTickets){
	mesToClient="Sorry User"+count+", We don't have enough tickets.";
}
else if(tick.getTickets()==0){
	mesToClient="Sorry User"+count+", We are out of tickets.";
}
else{
tick.setTickets(tick.getTickets() - bookedTickets);

}
				
				//Send message to all client on how many tickets is still remaining.
				for (int i = 0; i < socketList.size(); i++) {
					writer = new PrintWriter(socketList.get(i).getOutputStream());
					writer.println(mesToClient+"\nRemaining unbooked tickets: " + tick.getTickets()
					+"\n\nInput number of tickets you'll buy or type in 'bye' to exit:");
					writer.flush();
				}

			}
		} catch (IOException e) {

		}
	}
}