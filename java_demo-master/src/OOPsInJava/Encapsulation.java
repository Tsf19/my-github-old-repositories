package OOPsInJava;


class Dog {
	private String name;
	private String breed;
	private int cost;

	public Dog(String name, String breed, int cost) {
		super();
		this.name = name;
		this.breed = breed;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}
	public String getBreed() {
		return breed;
	}
	public int getCost() {
		return cost;
	}

}

public class Encapsulation {
	public static void main(String[] args) {
		Dog d = new Dog("Lobo","BullDog",9999);
		
		System.out.println(d.getName());
		System.out.println(d.getBreed());
		System.out.println(d.getCost());
	}
}
