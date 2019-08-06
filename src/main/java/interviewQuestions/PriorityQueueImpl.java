package interviewQuestions;

import java.util.PriorityQueue;

public class PriorityQueueImpl {

	public static void main(String[] args) {
		
		PriorityQueue<Employee> priorityQ = new PriorityQueue<>();
		priorityQ.add(new Employee("Renu",34L));
		priorityQ.add(new Employee("Renukeswar",29L));
		priorityQ.add(new Employee("Manu",25L));
		priorityQ.add(new Employee("Abhi",7L));
		priorityQ.add(new Employee("Lekhya",1L));
		
		while(true) {
			Employee e = priorityQ.poll();
			System.out.println(e);
			if(e ==null) break;
		}
	}
}

class Employee implements Comparable<Employee>{

	private String name;
	private Long id;
	
	Employee(String name,Long id){
		this.name = name;
		this.id = id;
	}
	@Override
	public int compareTo(Employee emp) {
		return this.getName().compareTo(emp.getName());
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
