package w2d1.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author BRIONSE
 *
 */
public class WorkerTest {

	public static void main(String[] args) {

		// 1 Create a List and add three workers, and their information shown.
		List<Worker> workerList = new ArrayList<Worker>();

		Worker worker1 = new Worker("Simon", 20, 10000);
		Worker worker2 = new Worker("Jame", 25, 13000);
		Worker worker3 = new Worker("Alex", 22, 12000);

		workerList.add(worker1);
		workerList.add(worker2);
		workerList.add(worker3);

		System.out.println("Name: " + "\t" + "Age" + "\t" + "Salary");

		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}

		// 2 Add one worker before Jame ( Steven, 24, 15000)
		workerList.add(1, new Worker("Steven", 24, 15000));

		// 3 Remove the worker Alex’s information & 5 Go through the list using
		// iterator
		Iterator workerIter = workerList.iterator();

		while (workerIter.hasNext()) {
			Worker worker = (Worker) workerIter.next();
			if (worker.getName().equals("Alex")) {
				workerIter.remove();
			}
		}

		// 4 Go through the list using for statement and print out all the
		// worker’s information
		System.out.println();
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}

		// 6. Overwrite the equals method for the class Worker
		showOverriddenEquals();

		// 7. Sort the all the workers from high to low by salary
		sortWorkersBySalary(workerList);

		// 8. Add a id to Worker class, and save the above data to workMap\
		doHashMap(workerList);

	}

	/**
	 * Demonstrates the overridden equals method of the Worker class
	 */
	public static void showOverriddenEquals() {
		System.out.println();

		Worker workerA = new Worker("Baste", 24, 99999);
		Worker workerB = new Worker("Baste", 24, 99999);
		Worker workerC = new Worker("Baste", 24, 77777);

		System.out.println(workerA.equals(workerB));
		System.out.println(workerA.equals(workerC));
	}

	/**
	 * Puts the worker list into a HashMap and prints using different methods
	 * 
	 * @param workerList
	 */
	public static void sortWorkersBySalary(List<Worker> workerList) {

		System.out.println();
		Collections.sort(workerList);
		for (Worker worker : workerList) {
			System.out.println(worker.getName() + "\t" + worker.getAge() + "\t" + worker.getSalary());
		}

	}

	/**
	 * Puts the worker list into a HashMap and prints using different methods
	 * 
	 * @param workerList
	 */
	public static void doHashMap(List<Worker> workerList) {
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		int ctr = 0;

		for (Worker worker : workerList) {
			ctr++;
			workMap.put(String.valueOf(ctr), worker);
		}

		System.out.println();

		//method 1
		for (Map.Entry<String, Worker> entry : workMap.entrySet()) {
			Worker worker = entry.getValue();
			System.out.println("Worker Id: " + entry.getKey() + " Name: " + worker.getName() + " Age: "
					+ worker.getAge() + " Salary " + worker.getSalary());
		}

		System.out.println();

		//method 2
		for (String workerId : workMap.keySet()) {
			Worker worker = workMap.get(workerId);
			System.out.println("Worker Id: " + workerId + " Name: " + worker.getName() + " Age: " + worker.getAge()
					+ " Salary " + worker.getSalary());
		}

		System.out.println();

		//method 3
		Iterator workerIter = workMap.keySet().iterator();
		while (workerIter.hasNext()) {
			String workerId = (String) workerIter.next();
			Worker worker = workMap.get(workerId);
			System.out.println("Worker Id: " + workerId + " Name: " + worker.getName() + " Age: " + worker.getAge()
					+ " Salary " + worker.getSalary());
		}

	}

}
