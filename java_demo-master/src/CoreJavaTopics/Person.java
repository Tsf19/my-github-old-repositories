/**
 * 
 */
package CoreJavaTopics;

/**
 * @author Tousif
 *
 */
public class Person implements Comparable<Person> {

	private String firstName;
	private String lastName;
	private Integer age;
	
	
	public Person(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", Age=" + age + "]\n";
	}

	@Override
	public int compareTo(Person p) {
		if(this.age == p.getAge())
			return 0;
		else if(this.age > p.getAge())
			return 1;
		else
			return -1;
	}
	
}
