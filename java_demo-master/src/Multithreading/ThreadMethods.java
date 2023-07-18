package Multithreading;

class PrintingActivities implements Runnable {

	public void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
				
		if(name.equals("numPrnt")) {
			numberPrinting();
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());

		}
		else if(name.equals("largeNumPrnt")) {
			largeNumberPrinting();
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());

		}
		else if(name.equals("capCharPrnt")) {
			charPrinting();
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());

		}
		else if(name.equals("smCharPrnt")) {
			smCharPrinting();
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t"+"Current Thread is : "+name+" , and isAlive is : "+t.isAlive());

		}
	}

	public void numberPrinting() {
		try {

			System.out.println("Number Printing Activities Started : ");

			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void largeNumberPrinting() {
		try {

			System.out.println("Number Printing Activities Started : ");

			for (int i = 1; i <= 10; i++) {
				System.out.println(i+100);
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void smCharPrinting() {
		try {

			System.out.println("Character Printing Activities Started : ");

			for (int i = 0; i <= 10; i++) {
				System.out.println((char) ('a' + i));
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void charPrinting() {
		try {

			System.out.println("Character Printing Activities Started : ");

			for (int i = 0; i <= 10; i++) {
				System.out.println((char) ('A' + i));
				Thread.sleep(500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


public class ThreadMethods {

	public static void main(String[] args) throws InterruptedException {


		PrintingActivities np = new PrintingActivities();
		PrintingActivities lp = new PrintingActivities();
		PrintingActivities cp = new PrintingActivities();
		PrintingActivities sp = new PrintingActivities();
		Thread npt = new Thread(np,"numPrnt");
		Thread lpt = new Thread(lp,"largeNumPrnt"); 
		Thread cpt = new Thread(cp,"capCharPrnt"); 
		Thread spt = new Thread(sp,"smCharPrnt"); 

		npt.start();
		lpt.start();
		cpt.start();
		spt.start();
		
//		npt.join();
//		lpt.join();
//		cpt.join();
//		spt.join();

	}

}
