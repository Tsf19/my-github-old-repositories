package NarasimhaKarumanchi.Java._3_Stacks._1_FixedSizeArrayStack;

public class StackApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		int capacity = 7;
		StackService stack = new StackServiceImplementation(capacity);
		
		int pop;
		int top;
		String string;
		boolean isEmpty;
		
		stack.push(1);
		stack.push(2);
		
		top = stack.top();
		string = stack.toString();
		
		pop = stack.pop();
		pop = stack.pop();
		
		isEmpty = stack.isEmpty();

//		top = stack.top();
		string = stack.toString();
		
//		pop = stack.pop();
		
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		top = stack.top();
		string = stack.toString();
		
		
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
//		stack.push(10);
		
	}

}
