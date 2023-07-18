package OOPsInJava;

class Calculator {
	int add(int x, int y) {
		System.out.println("int add(int "+x+" , int "+y+") is called");
		return x+y;
	}

	float add(int x, float y) {
		System.out.println("float add(int "+x+" , float "+y+") is called");
		return x+y;
	}

	float add(float x, float y) {
		System.out.println("float add(float "+x+" , float "+y+") is called");
		return x+y;
	}

	int add(int x) {
		System.out.println("int add(int "+x+") is called");
		return x;
	}

	float add(float x) {
		System.out.println("float add(float "+x+") is called");
		return x;
	}

}

public class VirtualPolymorphism {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		int a=10;
		int b=20;
		float c=10.0f;
		float d=20.0f;
		System.out.println(calc.add(a,b));
		System.out.println(calc.add(a,c));
		System.out.println(calc.add(c,a));
		System.out.println(calc.add(c,d));
		System.out.println(calc.add(a));
		System.out.println(calc.add(d));
	}

}
