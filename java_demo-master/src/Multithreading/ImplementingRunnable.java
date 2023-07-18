package Multithreading;

class PrintingActivity implements Runnable {

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


public class ImplementingRunnable {

	public static void main(String[] args) {
		PrintingActivity np = new PrintingActivity();
		PrintingActivity cp = new PrintingActivity();

//		np.setName("numPrnt"); // setName(String) is undefined for the Runnable Interface
//		cp.setName("charPrnt"); // setName(String) is undefined for the Runnable Interface

//		np.start(); // This Won't Work, It Works while Extending Thread class
//		cp.start(); // This Won't Work, It Works while Extending Thread class 

/*		//Creating Thread
		Thread cpt = new Thread(cp); // Create Thread This Way Only if Using Runnable Interface
		Thread npt = new Thread(np);// Create Thread This Way Only if Using Runnable Interface
*/	
		//Creating Thread + Assigning Name to It
		Thread cpt = new Thread(cp,"charPrnt"); // Create Thread This Way Only if Using Runnable Interface
		Thread npt = new Thread(np,"numPrnt"); // Create Thread This Way Only if Using Runnable Interface

		npt.start();
		cpt.start();

	}

}
