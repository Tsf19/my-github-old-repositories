/**
 * 
 */
package NarasimhaKarumanchi.Java._1_Recursion;

import java.util.Arrays;

/**
 * @author Tousif
 *
 */
//USING BACKTRACKING
public class _3_GenerateAllTheStringsOfNBits {

	int[] nBitArray;
	
	//Constructor Initializing Array of size n
	public _3_GenerateAllTheStringsOfNBits(int n) {
		nBitArray = new int[n];
	}
	
	public void generateBinary(int n) {

		if(n < 1)
			System.out.println(Arrays.toString(nBitArray));
		else {
			nBitArray[n-1] = 0;
			generateBinary(n-1);
			nBitArray[n-1] = 1;
			generateBinary(n-1);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		_3_GenerateAllTheStringsOfNBits classObj = new _3_GenerateAllTheStringsOfNBits(n);
		classObj.generateBinary(n);
	}

}
