package W2D1num5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {
	static int getIndex = 0;
	static List<Worker> worker = new LinkedList<Worker>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		createWorker(); // Requirement 1 : Create a List, add three workers and
						// display their information
		addWorker(); // Adding one worker before Jame (Steve,24,15000)
		deleteWorker(); // Remove the Worker Alex's information
		displayWorker();
		iterateWork(); // Go through the list using Iterator statement to call
						// all the worker¡¯s method work.
		Collections.sort(worker); // Sort the all the workers from high to low
									// by salary
		displaySalary();
		getMap();
	}

	public static void createWorker() {
		worker.add(new Worker("Simon", 20, 10000));
		worker.add(new Worker("Jame", 25, 13000));
		worker.add(new Worker("Alex", 22, 12000));
		System.out.println("Creating Worker");
		System.out.println("Name \t Age \t Salary");
		for (Worker list : worker) {
			System.out.println(list.getName() + "\t" + list.getAge() + "\t"
					+ list.getSalary());
		}
	}

	public static void addWorker() {
		System.out.println("Adding Steven");
		for (Worker list : worker) {
			if (list.getName().equalsIgnoreCase("Jame")) {
				getIndex = worker.indexOf(list);
			}
		}
		worker.add(getIndex, new Worker("Steven", 24, 15000));
	}

	public static void deleteWorker() {
		System.out.println("Deleting Alex!");
		for (Worker list : worker) {
			if (list.getName().equalsIgnoreCase("Alex")) {
				getIndex = worker.indexOf(list);
			}
		}
		worker.remove(getIndex);
	}

	public static void displayWorker() {
		System.out.println("------------------------------------------");
		System.out.println("Name \t Age \t Salary");
		for (Worker list : worker) {
			System.out.println(list.getName() + "\t" + list.getAge() + "\t"
					+ list.getSalary());
		}
	}

	public static void iterateWork() {
		Iterator wk = worker.iterator();
		System.out.println("------------------------------------------");
		System.out.println("Iterator!!!");
		while (wk.hasNext()) {
			Worker work = (Worker) wk.next();
			work.work();
		}
	}

	public static void displaySalary() {
		System.out.println("------------------------------------------");
		System.out.println("Sort by Salary");
		for (Worker list : worker) {
			System.out.println("Name: " + list.getName() + "\t Salary: "
					+ list.getSalary());
		}
	}

	public static void getMap() {
		int ctr = 1;
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		for (Worker list : worker) {
			workMap.put(Integer.toString(ctr), list);
			ctr++;
		}

		System.out.println("------------------------------------------");
		System.out.println("Using Entry Set");
		for (Entry<String, Worker> entry : workMap.entrySet()) {
			String key = entry.getKey();
			Worker value = entry.getValue();
			System.out.println("Worker Id: " + key + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());
		}

		System.out.println("------------------------------------------");
		System.out.println("Using Keyset");
		for (String key : workMap.keySet()) {
			Worker value = workMap.get(key);
			System.out.println("Worker Id: " + key + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());
		}

		System.out.println("------------------------------------------");
		System.out.println("Using Iterator");
		Iterator wk = workMap.keySet().iterator();
		while (wk.hasNext()) {
			String key = (String) wk.next();
			Worker value = workMap.get(key);
			System.out.println("Worker Id: " + key + "\t Name: "
					+ value.getName() + "\t Age: " + value.getAge()
					+ "\t Salary: " + value.getSalary());
		}

	}
}
