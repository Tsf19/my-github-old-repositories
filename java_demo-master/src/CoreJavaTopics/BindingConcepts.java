package CoreJavaTopics;

/* private, final and static members (methods and variables) and Any Variables use static binding
 * while for virtual methods (In Java methods are virtual by default) 
 * binding is done during run time based upon run time object.
 * Therefore private, final, static and any variables : Compile Time Binding
 * else Run Time Binding
 */

class A {
	
	int i = 10;  //CTB
	static int j = 20;  //CTB
	
	void m1() {  //RTB
		System.out.println("A.A");
	}
	
	static void m2() {  //CTB
		System.out.println("A.B");
	}
	
	void m3() {  //RTB
		System.out.println("A.C");
	}
	
}

class B extends A {
	
	int i = 30;  //CTB
	static int j = 40;  //CTB
	
	void m1() {  //RTB
		System.out.println("B.D");
	}
	
	static void m2() {  //CTB
		System.out.println("B.E");
	}
	
	
}

class C extends B {
	
	int i = 50;  //CTB
	static int j = 60;  //CTB
	
	static void m2() {  //CTB
		System.out.println("C.G");
	}

	void m3() {  //RTB
		System.out.println("C.F");
	}
	
	static void m4() {  //CTB
		System.out.println("C.H");
	}
	
	
}

public class BindingConcepts {

	public static void main(String[] args) {

		A ab = new B();
		System.out.println("ab.i :"+ab.i); //10
		System.out.println("ab.j :"+ab.j); //20
		System.out.println("A.j :"+A.j); //20
		System.out.println("B.j :"+B.j); //40
		ab.m1(); //B.D
		ab.m2(); //A.B
		A.m2(); //A.B
		B.m2(); //B.E
		ab.m3(); //A.C
//		ab.m4(); // The method m4() is undefined for the type A // SPECIALIZED METHOD

		System.out.println();
		
		B bc = new C();
		System.out.println("bc.i :"+bc.i); //30
		System.out.println("bc.j :"+bc.j); //40
		bc.m1(); //B.D //From Child C
		bc.m2(); //B.E
		bc.m3(); //C.F
//		bc.m4(); // The method m4() is undefined for the type A // SPECIALIZED METHOD

		System.out.println();
		
		A ac = new C();
		System.out.println("ac.i :"+ac.i); //10
		System.out.println("ac.j :"+ac.j); //20
		ac.m1(); //B.D //From Child C, A-->B-->C
		ac.m2(); //A.B
		ac.m3(); //C.F
//		ac.m4(); // The method m4() is undefined for the type A // SPECIALIZED METHOD

		
	}

}
