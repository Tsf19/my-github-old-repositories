package NarasimhaKarumanchi.Java._1_Recursion;

import java.util.Scanner;

/**
 * @author Tousif
 *
 */
public class _1_FactorianFunction {

	public static int factorial(int n) {
		System.out.println("n is: "+n);
		if(n == 0)
			return 1;
		else	
			return n*factorial(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter: ");
		int n = sc.nextInt();
		System.out.println(factorial(n));
	}

}
