package NarasimhaKarumanchi.Java._3_Stacks._3_StackWithLinkedList;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class StackApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		StackService stack = new StackServiceImplementation();
		
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
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);
		
		
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		pop = stack.pop();
		
	}

}
