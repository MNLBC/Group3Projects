
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class W2D1hw_no2LinkedList {
	public static void main(String args[]) {
		
		List<String> list = new LinkedList<String>();
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