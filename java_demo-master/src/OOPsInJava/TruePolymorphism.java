package OOPsInJava;


class Animal {
	public void eat() {
		System.out.println("Animal is Eating");
	}
	public void sleep() {
		System.out.println("Animal is sleeping");
	}
}

class Tiger extends Animal {
	public void eat() {
		System.out.println("Tiger Hunts and Eat");
	}
	public void sleep() {
		System.out.println("Tiger is sleeping");
	}
}

class Deer extends Animal {
	public void eat() {
		System.out.println("Deer Grazes and Eat");
	}
	public void sleep() {
		System.out.println("Deer is sleeping");
	}
}

class Monkey extends Animal {
	public void eat() {
		System.out.println("Monkey Steals and Eat");
	}
	public void sleep() {
		System.out.println("Monkey is sleeping");
	}
}

class Forest {
	public void permit(Animal ref) {
		ref.eat();
		ref.sleep();
	}
}
/* PLYMORPHIC VERSION With Code Reduction */
public class TruePolymorphism {
	public static void main(String[] args) {
		
		Tiger tiger = new Tiger();
		Deer deer = new Deer();
		Monkey monkey = new Monkey();
		Forest forest = new Forest();
		
		forest.permit(tiger);
		forest.permit(deer);
		forest.permit(monkey);
	}
}
