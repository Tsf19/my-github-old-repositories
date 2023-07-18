package Multithreading;

class Printing extends Thread {

	public void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();

		if(name.equals("numPrnt")) {
			System.out.println(name);
			numberPrinting();
		}
		else if(name.equals("charPrnt")) {
			System.out.println(name);
			charPrinting();
		}
	}

	public void numberPrinting() {
		try {

			System.out.println("Number Printing Activity Started : ");

			for (int i = 1; i <= 10; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void charPrinting() {
		try {

			System.out.println("Character Printing Activity Started : ");

			for (int i = 0; i <= 10; i++) {
				System.out.println((char) ('A' + i));
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


public class ExtendingThreadSingleRun {

	public static void main(String[] args) {

		Printing np = new Printing();
		Printing cp = new Printing();

		np.setName("numPrnt");
		cp.setName("charPrnt");

		np.start();
		cp.start();
		
//-----------------------------------------------//
		
		Thread cpt = new Thread(cp,"charPrnt"); // This Also Works Fine
		Thread npt = new Thread(np,"numPrnt");
		
		npt.start();
		cpt.start();
	}
}
