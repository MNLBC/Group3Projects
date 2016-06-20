import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * @author CUNTAAL
 * @version 1
 */
public class AppWorker {
	public static void main(String[] args) {

		int index = 0;
		// Add details of Worker
		List<Worker> worker = new ArrayList<Worker>();
		worker.add(new Worker("Simon", 20, 10000));
		worker.add(new Worker("Jame", 25, 13000));
		worker.add(new Worker("Alex", 22, 12000));
		System.out.println("Name \t Age \t Salary");

		// Display
		for (Worker value : worker) {
			System.out.println(value.getName() + "\t" + value.getAge() + "\t"
					+ value.getSalary());
		}
		// Add Steven from the List, Get index value
		for (Worker value : worker) {
			if (value.getName().equalsIgnoreCase("Jame"))
				index = worker.indexOf(value);

		}
		worker.add(new Worker("Steven", 24, 15000));

		// Remove Alex from the List
		for (Worker value : worker) {
			if (value.getName().equalsIgnoreCase("Alex"))
				index = worker.indexOf(value);
		}
		worker.remove(index);
		System.out.println("----------------------");
		System.out.println("Name \t Age \t Salary");
		for (Worker value : worker) {
			System.out.println(value.getName() + "\t" + value.getAge() + "\t"
					+ value.getSalary());

		}
		System.out.println("");
		Iterator<Worker> work = worker.iterator();
		while (work.hasNext()) {
			Worker work1 = (Worker) work.next();
			work1.work();
		}
		for (Worker value : worker) {
			System.out.println(value.getName() + "\t" + value.getAge() + "\t"
					+ value.getSalary());

		}

		// Sort All workers
		System.out.println("----------------------");
		Collections.sort(worker);
		for (Worker value : worker) {
			System.out.println(value.getName() + "\t" + value.getAge() + "\t"
					+ value.getSalary());
		}

		// Map< String, Worker> hashMap = new HashMap< String, Worker>();
		int ctr = 1;
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		for (Worker list : worker) {
			workMap.put(Integer.toString(ctr), list);
			ctr++;
		}
        // Workmap  entrySet
		System.out.println("------------------------------------------");
		for (Entry<String, Worker> entry : workMap.entrySet()) {
			String key = entry.getKey();
			Worker value = entry.getValue();

			System.out.println("Worker Id: " + key + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());
		}
		// Workmap KeySet
		System.out.println("------------------------------------------");
		for (String entry : workMap.keySet()) {
			Worker value = workMap.get(entry);
			System.out.println("Worker Id: " + entry + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());
		}
		//Workmap Iterator
		System.out.println("------------------------------------------");
		Iterator<String> work1 = workMap.keySet().iterator();
		while (work1.hasNext()) {
			String entry = work1.next();
			Worker value = workMap.get(entry);
			System.out.println("Worker Id: " + entry + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());

		}
	}
}
