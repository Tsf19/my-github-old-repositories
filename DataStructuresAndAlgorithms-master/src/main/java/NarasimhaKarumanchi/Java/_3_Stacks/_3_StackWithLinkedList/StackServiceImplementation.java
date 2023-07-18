package NarasimhaKarumanchi.Java._3_Stacks._3_StackWithLinkedList;

import java.util.EmptyStackException;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class StackServiceImplementation implements StackService {

	protected int length;
	protected ListNode top;
	
	public StackServiceImplementation() {
		length = 0;
		top = null;
	}
	
	@Override
	public boolean isEmpty() {
		return (length == 0);
	}
	
	@Override
	public int size() {
		return length;
	}
	
	
	@Override
	public int top() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException();
		return top.getData();
	}

	
	
	@Override
	public void push(int data)  {
		ListNode temp = new ListNode(data);
		temp.setNext(top);
		top = temp;
		length++;
	}
	
	@Override
	public int pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		int result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		ListNode current = top;
		while(current != null) {
			result = result + current.toString() + "\n";
			current = current.getNext();
		}
		return result;
	}
}
