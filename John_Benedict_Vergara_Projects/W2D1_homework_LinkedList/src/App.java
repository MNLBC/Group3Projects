import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */

/**
 * @author vergajo
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// List list = new ArrayList();
		// change ArrayList to LinkedList
		// Import the import java.util.LinkedList;
		List list = new LinkedList();
		list.add("Hello");
		list.add("World");
		list.add(1, "Learn");
		list.add(1, "Java");
		printList(list);
	}

	public static void printList(List list) {
		// 1
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (Object o : list) {
			System.out.println(o);
		}
		Iterator itor = list.iterator();
		while (itor.hasNext()) {
			System.out.println(itor.next());
		}
	}
}
