package Generics.Wildcards5;

/**
 * @author Tousif
 */

/**
 * Pair<? extends Employee>
 * denotes any generic Pair type whose type parameter is a subclass of Employee , such as
 * Pair<Manager> , but not Pair<String> .
 * 
 * 
 */
public class PairTest1 {

	public static void main(String[] args) {
		
		Manager mgr1 = new Manager();
		mgr1.setName("Mgr1");
		
		Manager mgr2 = new Manager();
		mgr2.setName("Mgr2");
		
		Pair<Manager> p1 = new Pair<>();
		p1.setFirst(mgr1);
		p1.setSecond(mgr2);
		
		PairTest1.printBuddies(p1);
		//Mgr1 and Mgr2 are buddies

		
		Employee emp1 = new Employee();
		emp1.setName("Emp1");
		
		Employee emp2 = new Employee();
		emp2.setName("Emp2");
		
		Pair<Employee> p2 = new Pair<>();
		p2.setFirst(emp1);
		p2.setSecond(emp2);

		PairTest1.printBuddies(p2);
		//Emp1 and Emp2 are buddies.
		
		
		Employee em1 = new Manager();
		em1.setName("Emp1");
		
		Employee em2 = new Manager();
		em2.setName("Emp2");
		
		Pair<Manager> p3 = new Pair<>(); //This isn't allowed without <? extends Employee> 
		p3.setFirst((Manager)em1);
		p3.setSecond((Manager)em2);

		PairTest1.printBuddies(p3);
		//Emp1 and Emp2 are buddies.

	}
	
	/**
	 * public static void printBuddies(Pair<Employee> p){.......}
	 * you cannot pass a Pair<Manager> to that method.
	 * But the solution is simple—use a wildcard type
	 */
	
	public static void printBuddies(Pair<? extends Employee> p){
//		The type Pair<Manager> is a subtype of Pair<? extends Employee>
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + " are buddies.");

	}

}



