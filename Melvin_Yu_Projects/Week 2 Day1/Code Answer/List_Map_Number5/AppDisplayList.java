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
 * @author yume
 * @version 1.0
 * Homework Week 2 Day 1 for Java ITA
 */


public class AppDisplayList {
	static List<Worker> workerList;
	static Iterator it;
	static int getWorkerIndex=0;
	static Set<String> workKeySet;

	
public AppDisplayList() {
	// TODO Auto-generated constructor stub
	workerList = new ArrayList<Worker>();
	
	
	workerList.add(new Worker("Simon",20,10000));
	workerList.add(new Worker("Jame",25,13000));
	workerList.add(new Worker("Alex",22,12000));
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/**Main Class For All Answers in #5 in HOMEWORK WEEK2 DAY1*/
		AppDisplayList app = new AppDisplayList();
		
		createWorkerTable();//#1
		addNewWorker();//#2
		removeWorker();//#3
		displayAllRecordUsingForLoop();//#4
		callWorkMethodUsingIterator();//#5
		
		/**Answer to #6 is in the Worker Class*/
		getAndSortWorkerBySalary();//#7
		goThroughMapUsingThreeWay();//#8

	}
	
	public static void createWorkerTable(){
		/**1.	To create a List and add three workers, and their information shown like this:
		 * Name		Age		Salary
		 * Simon	20		10000
		 * Jame		25		13000
		 * Alex		22		12000
		 */
		/**Start of #1*/
		System.out.println("Creating WorkerList:");
		System.out.println("Name \tAge \tSalary");
		it= workerList.iterator();
		while(it.hasNext()){
			Worker worker = (Worker) it.next();
			System.out.println(worker.getName()+" \t"+worker.getAge()+" \t"+worker.getSalary());
		}
		/**End of #1*/
	}
	
	public static void addNewWorker(){
		/**2.	Add one worker before Jame ( Steven, 24, 15000)*/
		/** Start of #2*/
		
		
			for(Worker work : workerList){
				if(work.getName().equals("Jame")){
			getWorkerIndex=workerList.indexOf(work);
				}
			}// this is for getting the index of jame inside the WorkerList "List"
			
		workerList.add(getWorkerIndex,new Worker("Steven",24,15000));//adding Steven before Jame using Jame's index
		System.out.println("");
		System.out.println("Steven Has been Added before Jame!");
		/** End of #2*/
	}
	
	public static void removeWorker(){
		
		/** Start of #3*/
		
			for(Worker work : workerList){
				if(work.getName().equals("Alex")){
			getWorkerIndex=workerList.indexOf(work);
				}
			}// this is for getting the index of Alex inside the WorkerList "List"
			
		workerList.remove(getWorkerIndex);//removing Alex using his index.
		System.out.println("");
		System.out.println("Alex Has been Removed!!");
		/** End of #3*/
	}
	
	public static void displayAllRecordUsingForLoop(){
		/**4.	Go through the list using for statement and print out all the worker’s information.*/
		/** Start of #4*/
		System.out.println("");
		System.out.println("Using For Each Loop: ");
		System.out.println("Name \tAge \tSalary");
		
		for(Worker work : workerList){//for each loop to display the workers
			System.out.println(work.getName()+" \t"+work.getAge()+" \t"+work.getSalary());
		}
		/** End of #4*/
	}
	
	public static void callWorkMethodUsingIterator(){
		/**5.	Go through the list using Iterator statement to call all the worker’s method work.*/
		/** Start of #5*/
		System.out.println("");
		System.out.println("Using Iterator get Working: ");
		it= workerList.iterator();
		
		while(it.hasNext()){//iterator while loop to display the workers
			Worker worker = (Worker) it.next();
			worker.work();
		}
		/** End of #5*/
		
	}
	
	public static void getAndSortWorkerBySalary(){

		/**7.	Sort the all the workers from high to low by salary and print out the all the 
		 * 		workers information with the format “Name: “ + name + “ Salary: “ + salary.
		 */
		/** Start of #7*/
		Collections.sort(workerList,new sortingSalary());
		System.out.println("");
		System.out.println("Sort by Salary: ");
		it= workerList.iterator();
		
		while(it.hasNext()){//iterator while loop to display the workers with sorted Salary from High to low
			Worker worker = (Worker) it.next();
			System.out.println("Name: "  + worker.getName() + " Salary: " + worker.getSalary());
		}
		/** End of #7*/
	}
	
	public static void goThroughMapUsingThreeWay(){
		/**8.	Add a id to Worker class, and save the above data to workMap. Map<String, Worker > 
		 * 		( Worker ID, Worker) . At least three ways to go through the workMap, to print out 
		 * 		all the workder’s information with Worker id and all other information like 
		 * 		“Worker Id: “ + “Name: “ + name + “Age: “ + age +  “ Salary: “ + salary.
		 */
		/** Start of #8*/
		System.out.println("");
		System.out.println("Display using Map: ");
		int ctr=1;
		it= workerList.iterator();
		Map<String, Worker> workMap = new HashMap<String, Worker>();
		while(it.hasNext()){//Using Iterator to put worker to workMap used ctr for WorkerID
			Worker worker = (Worker) it.next();
			workMap.put(""+ctr, worker);
			ctr++;
		}
		
		
		System.out.println("First Way to go through workMap using entrySet(): ");
		for(Entry<String, Worker> entry: workMap.entrySet()){//used for each to get Entryset to get key and Value
			String key = entry.getKey();
			Worker value = entry.getValue();
			
			System.out.println("Worker ID:\t"+key +"\tName:\t"+ value.getName()+"\tAge:\t"+value.getAge()+"\tSalary:\t"+value.getSalary());
		}	
		
		
		System.out.println("Second Way to go through workMap using keySet(): ");
		workKeySet=workMap.keySet();
		for(String key: workKeySet){//used "for each" to get keySet then used the keySet for workMap.get(key)
			Worker value = workMap.get(key);
			
			System.out.println("Worker ID:\t"+key +"\tName:\t"+ value.getName()+"\tAge:\t"+value.getAge()+"\tSalary:\t"+value.getSalary());
		}
		
		
		System.out.println("Third Way to go through workMap using Iterator.KeySet(): ");
		it= workKeySet.iterator();
		while(it.hasNext()){//iterator while loop to display the workers with sorted Salary from High to low
			String key=(String) it.next();
			Worker value = workMap.get(key);
			System.out.println("Worker ID:\t"+key +"\tName:\t"+ value.getName()+"\tAge:\t"+value.getAge()+"\tSalary:\t"+value.getSalary());
		}
		/** End of #8*/
	}

}

class sortingSalary implements Comparator<Worker>{
	
	@Override
	/**
	 * @param Worker, Worker
	 * @return int
	 */
	public int compare(Worker o1, Worker o2) {//Sorts the list for the Salary from High to Low
		if(o1.getSalary()<o2.getSalary()){
			return 1;
		}
		else if(o1.getSalary()>o2.getSalary()){
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
}
