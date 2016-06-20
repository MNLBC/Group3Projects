
import java.util.*;
public class TestListSet {
	public static void main(String args[]) {
		List list = new ArrayList();
		list.add("Hello");
		list.add("Learn");
		list.add("Hello");
		list.add("Welcome");
		Set set = new HashSet();
		set.addAll(list);
		System.out.println(set.size());
	}
}
