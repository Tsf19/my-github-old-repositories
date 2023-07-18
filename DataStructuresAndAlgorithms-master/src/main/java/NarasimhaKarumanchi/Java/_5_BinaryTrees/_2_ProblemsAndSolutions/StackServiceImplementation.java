package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import java.util.EmptyStackException;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class StackServiceImplementation<T> implements StackService<T> {

	protected Integer length;
	protected ListNode<T> top;
	
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
	public T top() throws EmptyStackException{
		if(isEmpty())
			throw new EmptyStackException();
		return top.getData();
	}

	
	
	@Override
	public void push(T data)  {
		ListNode<T> temp = new ListNode<T>(data);
		temp.setNext(top);
		top = temp;
		length++;
	}
	
	@Override
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		T result = top.getData();
		top = top.getNext();
		length--;
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		ListNode<T> current = top;
		while(current != null) {
			result = result + current.toString() + "\n";
			current = current.getNext();
		}
		return result;
	}

	@Override
	public T peek() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		T result = top.getData();
		return result;
	}
}
