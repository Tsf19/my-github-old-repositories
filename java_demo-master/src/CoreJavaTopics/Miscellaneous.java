package CoreJavaTopics;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Miscellaneous {

	public static void main(String[] args) {
		
		int i = 0;
		System.out.println(i == BigInteger.ZERO.intValue()); //true
		
		Integer j = 0;
		System.out.println(j.equals(BigInteger.ZERO)); //false
		System.out.println(j == BigInteger.ZERO.intValue()); //true
	
		j = 10;
		System.out.println(j == null); //true
		System.out.println(j.equals(null)); //true
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		
		List<Integer> subList1 = list.subList(0, 5);
		List<Integer> subList2 = list.subList(5, 10);
		List<Integer> subList3 = list.subList(10, 15);
		List<Integer> subList4 = list.subList(15, 20);
		System.out.println(list.size());
		
		double i1 = 24/5;
		int i2 = (int)Math.ceil(i1);
		
		System.out.println();
	}
	
}
