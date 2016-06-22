package homeworkw2d3;
/**
 * 
 * @author YUME
 *	used to hold 500 hard coded tickets
 *	and to set and get if user buys tickets and retrieves remaining
 */
public class Ticket {
private int tickets;

/**
 * Ticket Constructor
 * @param tickets
 */
public Ticket(int tickets) {
	this.tickets = tickets;
}

/**
 * @return the tickets
 */
public int getTickets() {
	return tickets;
}

/**
 * @param tickets the tickets to set
 */
public void setTickets(int tickets) {
	this.tickets = tickets;
}
}
