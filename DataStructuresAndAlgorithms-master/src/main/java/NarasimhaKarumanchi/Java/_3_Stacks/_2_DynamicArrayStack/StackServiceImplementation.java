package NarasimhaKarumanchi.Java._3_Stacks._2_DynamicArrayStack;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class StackServiceImplementation implements StackService {

	//Length of the array used to implement the stack.
	protected int capacity;
	
	//Default array capacity.
	public static final int CAPACITY = 16; //power of 2
	public static final int MINCAPACITY = 1<<2; //power of 2
	
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

	
	private void expand() {
		int length = size();
		int[] newStack = new int[length << 1]; //Doubling the size
		/**
		 * @PARAMETERS	: 
		 * 	@source_arr : array to be copied from
		 * 	@sourcePos	: starting position in source array from where to copy
		 * 	@dest_arr	: array to be copied in
		 * 	@destPos	: starting position in destination array, where to copy in
		 * 	@len		: total no. of components to be copied.
		 */
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
		this.capacity = this.capacity << 1;
	}
	
	//shrink to 1/2 if more than 3/4 empty
//	private void shrink() {
//		int length = top + 1;
//		if(length<=MINCAPACITY || top<<2 >= length)
//			return;
//		length = length + (top<<1); //shrink to at 1/2 or less of the heap
//		if(top < MINCAPACITY)
//			length = MINCAPACITY;
//		int[] newStack = new int[length];
//		System.arraycopy(stackRep, 0, newStack, 0, top+1);
//		stackRep = newStack;
//		this.capacity = length;
//	}

	
	private void shrink() {
		capacity = (capacity>>2)*3; //shrinking 3/4th
		int[] newStack = new int[capacity];
		System.arraycopy(stackRep, 0, newStack, 0, top+1);
		stackRep = newStack;
	}
	
	@Override
	public void push(int data) throws Exception {
		if(size() == capacity)
			expand();
		stackRep[++top] = data;
	}
	
	@Override
	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("STACK IS EMPTY");
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		if(size() >= MINCAPACITY && size() <= (capacity>>2)*3)
			shrink();
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
