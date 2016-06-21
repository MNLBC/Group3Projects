import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AppTest {

	public static void main(String[] args) {
	
		List<Worker> worker = new ArrayList<Worker>();
		int workerIndex = 0;
		
		//number 1
		System.out.println("Name\t Age\t Salary" );
		worker.add(new Worker("Simon",20,10000.0));
		worker.add(new Worker("Jame",25,13000.0));
		worker.add(new Worker("Alex",22,12000.0));
		for (Worker w1:  worker){							
			System.out.println(w1.getName() + "\t" + w1.getAge() + "\t" + w1.getSalary());
			}
		
	
		//number 2
		System.out.println("--- Number 2 Adding Steven---");
		for(Worker w0 : worker){
			if(w0.getName() == "Jame"){
				workerIndex = worker.indexOf(w0);
			}
		}worker.add(workerIndex,new Worker("Steven",24,15000.0));
	
		for (Worker w1:  worker){						//number4
			System.out.println(w1.getName() + "\t" + w1.getAge() + "\t" + w1.getSalary());
			}
		
		//number 3
		for(Worker w2 : worker){
			if(w2.getName() == "Alex"){
				workerIndex = worker.indexOf(w2);
			}
		}
			worker.remove(workerIndex);
			System.out.println("--- Removing Alexis ---");
		for (Worker w1:  worker){							
			System.out.println(w1.getName() + "\t" + w1.getAge() + "\t" + w1.getSalary());
			}
		
		//number 4
		System.out.println("--- Number 4 using For Loop ---");
		for (Worker w1:  worker){
			System.out.println(w1.getName() + "\t" + w1.getAge() + "\t" + w1.getSalary());
			}
		
		//number 5 
		Iterator<Worker> list = worker.iterator();
		System.out.println("--- Number 5 using Iterator ---");
		while (list.hasNext()) {
			Worker w3 = (Worker) list.next();
			System.out.println(w3.getName() + "\t" + w3.getAge() + "\t" + w3.getSalary());
		}
		
		//number 7
		Collections.sort(worker, new Comparator<Worker>(){
			public int compare(Worker worker1, Worker worker2){
				double salary1 = worker1.getSalary();
				double salary2 = worker2.getSalary();
				
				if(salary1 > salary2){
					return -1;
				}
				if(salary2>salary1){
					return 1;
				}else{
					return 0;
				}
			}
		});
		System.out.println("--- Number 7 Sorting Salary ---");
		for (Worker w1:  worker){
			System.out.println("Name: " + w1.getName() + "\t" + "Salary: " + w1.getSalary());
			}		
		
		//number 8
		
		int id = 0;
		Map<String, Worker> workMap = new HashMap<String,Worker>();
		Iterator<Worker> workIterator = worker.iterator();

		while(workIterator.hasNext()){
			Worker work = workIterator.next();
			workMap.put(Integer.toString(id), work);
			id++;
		}
		
		//Entry Set
		System.out.println("\nFor Iteration using Entry Set");
		for (Entry<String, Worker> entry : workMap.entrySet()) {
			String workerId = entry.getKey();
			Worker work = workMap.get(workerId);

			System.out.println("Worker Id: " + workerId + " " + "\tName: " + work.getName() + "\tAge: " + work.getAge()
			+ "\tSalary: " + work.getSalary());
	}
		
		//For Iteration Key Set
		System.out.println("\nFor Iteration using Key Set");
			for(String key: workMap.keySet()){
				Worker work = workMap.get(key);
				System.out.println("Worker Id: " + key + " " + "\tName: " + work.getName() + "\tAge: " + work.getAge()
				+ "\tSalary: " + work.getSalary());
			}
			
		//While Iteration Key Set
			System.out.println("\nWhile Iteration using Key Set");
			Set workSet = workMap.keySet();
			Iterator<String> workIterator1 = workSet.iterator();
			while(workIterator1.hasNext()){
				String workerId = workIterator1.next();
				Worker work = workMap.get(workerId);
				System.out.println("Worker Id: " + workerId + " " + "\tName: " + work.getName() + "\tAge: " + work.getAge()
				+ "\tSalary: " + work.getSalary());
			}
	}
}
