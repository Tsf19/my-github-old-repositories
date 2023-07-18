package NarasimhaKarumanchi.Java._3_Stacks._1_FixedSizeArrayStack;

public class StackServiceImplementation implements StackService {

	//Length of the array used to implement the stack.
	protected int capacity;
	
	//Default array capacity.
	public static final int CAPACITY = 10;
	
	//Array used to implement the stack.
	protected int[] stackRep;
	
	//Index of the top  element of the stack in the array.
	protected int top = -1;
	
	public StackServiceImplementation() {
		this(CAPACITY); //default capacity
	}
	
	//Initialize the stack to use an array of given length.
	public StackServiceImplementation(int capacity) {
		this.capacity = capacity;
		stackRep = new int[capacity];
	}
	
	//Returns the number of elements in the stack. O(1)
	@Override
	public int size() {
		return (top + 1);
	}
	
	//Test whether the stack is empty. O(1)
	@Override
	public boolean isEmpty() {
		return (top < 0);
	}
	
	@Override
	public int top() throws Exception{
		if(isEmpty())
			throw new Exception("STACK IS EMPTY");
		return stackRep[top];
	}

	@Override
	public void push(int data) throws Exception {
		if(size() == capacity)
			throw new Exception("STACK IS FULL");
		stackRep[++top] = data;
	}
	
	@Override
	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("STACK IS EMPTY");
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	@Override
	public String toString() {
		String s;
		s = "[";
		if(size() > 0)
			s += stackRep[0];
		if(size() > 1)
			for(int i=1; i <= size()-1; i++) {
				s += "," + stackRep[i];
			}
		return s + "]";
	}
}
