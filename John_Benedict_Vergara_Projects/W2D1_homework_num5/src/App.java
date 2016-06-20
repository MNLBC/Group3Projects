import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

		// Number 1.
		List<Worker> workerList = new ArrayList<Worker>();
		workerList.add(new Worker("Simon", 20, 10000.0));
		workerList.add(new Worker("Jame", 25, 13000.0));
		workerList.add(new Worker("Alex", 22, 12000.0));
		System.out.println("Worker's List in number 1: ");
		System.out.print("Name\t");
		System.out.print("Age\t");
		System.out.println("Salary\t");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}
		System.out.println("");

		// Number 2.
		// Added Jame
		int workerIndex = 0;
		for (Worker worker : workerList) {
			if (worker.getName() == "Jame") {
				workerIndex = workerList.indexOf(worker);
			}
		}
		workerList.add(workerIndex, new Worker("Steven", 24, 15000.0));

		// Number 3.
		// Removed Alex
		for (Worker worker : workerList) {
			if (worker.getName() == "Alex") {
				workerIndex = workerList.indexOf(worker);
			}
		}
		workerList.remove(workerIndex);

		// Number 4.
		// Display using For Statement
		System.out.println("Display worker using For statement: ");
		System.out.print("Name\t");
		System.out.print("Age\t");
		System.out.println("Salary\t");
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}
		System.out.println("");

		// Number 5.
		// Display using Iterator
		System.out.println("Display worker using Iterator: ");
		System.out.print("Name\t");
		System.out.print("Age\t");
		System.out.println("Salary\t");
		Iterator<Worker> li = workerList.iterator();
		while (li.hasNext()) {
			Worker werk = (Worker) li.next();
			System.out.println(werk.getName() + "\t" + werk.getAge() + "\t" + werk.getSalary());
		}

		// Number 7.
		// Sort workers by Salary.
		Collections.sort(workerList, new Comparator<Worker>() {

			@Override
			public int compare(Worker work1, Worker work2) {
				// TODO Auto-generated method stub
				double sal1 = work1.getSalary();
				double sal2 = work2.getSalary();

				if (sal1 > sal2) {
					return -1;
				} else if (sal2 < sal1) {
					return 1;
				}
				return 0;
			}

		});

		System.out.println("\nSort Workers by Salary:");
		for (Worker worker : workerList) {
			System.out.println("Name: " + worker.getName() + "\tSalary: " + worker.getSalary());
		}
		System.out.println("");

		// Number 8.
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		Iterator<Worker> workItr = workerList.iterator();

		// Insert ID to Worker
		int id = 0;
		while (workItr.hasNext()) {
			Worker werk = workItr.next();
			workMap.put(Integer.toString(id), werk);
			id++;
		}
		
		// While Iteration using Keyset
		System.out.println("While Iteration using Keyset");
		Set workSet = workMap.keySet();
		Iterator<String> workerItr = workSet.iterator();
		while (workerItr.hasNext()) {
			String workerId = workerItr.next();
			Worker werk = workMap.get(workerId);
			System.out.println("Worker Id: " + workerId + " " + "\tName: " + werk.getName() + "\tAge: " + werk.getAge()
					+ "\tSalary: " + werk.getSalary());
		}
		System.out.println("");

		// For Iteration using Keyset
		System.out.println("For Iteration using Keyset");
		for (String workerId : workMap.keySet()) {
			Worker werk = workMap.get(workerId);
			System.out.println("Worker Id: " + workerId + " " + "\tName: " + werk.getName() + "\tAge: " + werk.getAge()
					+ "\tSalary: " + werk.getSalary());

		}
		System.out.println("");

		
		// For Iteration using Entry Set
		System.out.println("For Iteration using Entry Set");
		for (Entry<String, Worker> entry : workMap.entrySet()) {
			String workerId = entry.getKey();
			Worker werk = workMap.get(workerId);

			System.out.println("Worker Id: " + workerId + " " + "\tName: " + werk.getName() + "\tAge: " + werk.getAge()
					+ "\tSalary: " + werk.getSalary());
		}

		// workMap.put(ctr, value)

	}

}
