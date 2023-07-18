/**
 * 
 */
package Generics.SupertypeBoundsForWildcards6;

/**
 * @author Tousif
 *
 */
public class Employee {
	
	private String name;
	
	public void printWhoIam(){
		System.out.println("I am Employee");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	
	
}
