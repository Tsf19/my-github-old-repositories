package Multithreading;

class NumberPrinting extends Thread {
	public void run() {
		try {

			System.out.println("Number Printing Activity Started : ");

			for(int i = 1; i<=10; i++) {
				System.out.println(i);
				Thread.sleep(1500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class CharPrinting extends Thread {
	public void run() {
		try {

			System.out.println("Character Printing Activity Started : ");

			for(int i =0; i<=10; i++) {
				System.out.println((char)('A'+i));
				Thread.sleep(1500);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



public class ExtendingThread {

	public static void main(String[] args) {

		NumberPrinting np = new NumberPrinting();
//		Thread npt = new Thread(np);

		CharPrinting cp = new CharPrinting();
//		Thread cpt = new Thread(cp);

//		npt.start();  //<-- This Also Works Fine
//		cpt.start();

		np.start();
		cp.start();
	}
}
