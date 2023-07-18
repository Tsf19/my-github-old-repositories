/**
 * 
 */
package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author Tousif
 *
 */
public class _7_TwoStacksUsingOneArray {

	private Integer[] dataArray;
	private Integer size, topOne, topTwo;

	public _7_TwoStacksUsingOneArray(int size) {
		if(size<2)
			throw new IllegalStateException("size < 2 in not permissible");
		dataArray = new Integer[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}

	public void push(int stackId, int data) {
		if(topOne == topTwo-1)
			throw new StackOverflowError("Array is full");
		if(stackId == 1)
			dataArray[++topOne] = data;
		else if(stackId == 2)
			dataArray[--topTwo] = data;
		else return;
	}

	public Integer pop(int stackId) {
		if(stackId == 1) {
			if(topOne == -1)
				throw new EmptyStackException();
			int toPop = dataArray[topOne];
			dataArray[topOne--] = null;
			return toPop;
		}
		else if(stackId == 2) {
			if(topTwo == size)
				throw new EmptyStackException();
			int toPop = dataArray[topTwo];
			dataArray[topTwo++] = null;
			return toPop;
		}
		else return null;
	}

	public Integer top(int stackId) {

		if(stackId == 1) {
			if(topOne == -1)
				throw new EmptyStackException();
			return dataArray[topOne];
		}

		else if(stackId == 2) {
			if(topOne == size)
				throw new EmptyStackException();
			return dataArray[topTwo];
		}
		else
			return null;
	}

	public Boolean isEmpty(int stackId) {
		if(stackId == 1)
			return topOne == -1;
		else if(stackId == 2)
			return topTwo == this.size;
		else return null;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(dataArray);
	}

	public static void main(String[] args) {
		_7_TwoStacksUsingOneArray dualStack = new _7_TwoStacksUsingOneArray(10);
		
		Boolean isEmpty11 = dualStack.isEmpty(1);
		Boolean isEmpty22 = dualStack.isEmpty(2);
		dualStack.push(1, 1);
		dualStack.push(1, 2);
		dualStack.push(1, 3);
		Integer top11 = dualStack.top(1);
		dualStack.push(1, 4);
		dualStack.push(1, 5);
		Integer top12 = dualStack.top(1);
		Boolean isEmpty13 = dualStack.isEmpty(1);
		Boolean isEmpty24 = dualStack.isEmpty(2);
		dualStack.push(2, 11);
		dualStack.push(2, 12);
		dualStack.push(2, 13);
		Integer top21 = dualStack.top(2);
		dualStack.push(2, 14);
		dualStack.push(2, 15);
		Integer top22 = dualStack.top(2);
		Boolean isEmpty15 = dualStack.isEmpty(1);
		Boolean isEmpty26 = dualStack.isEmpty(2);
		
		Integer pop11 = dualStack.pop(1);
		Integer pop21 = dualStack.pop(2);
		Integer pop22 = dualStack.pop(2);
		Integer pop12 = dualStack.pop(1);
		Integer pop13 = dualStack.pop(1);
		Integer pop14 = dualStack.pop(1);
		Integer pop23 = dualStack.pop(2);
		Integer pop24 = dualStack.pop(2);
		Integer pop25 = dualStack.pop(2);
		Integer pop15 = dualStack.pop(1);
		
		System.out.println();
	}

}
