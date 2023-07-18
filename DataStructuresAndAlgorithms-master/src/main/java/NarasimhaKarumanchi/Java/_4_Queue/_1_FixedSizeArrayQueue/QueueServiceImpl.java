package NarasimhaKarumanchi.Java._4_Queue._1_FixedSizeArrayQueue;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class QueueServiceImpl {

	private int[] queue;
	private int capacity;
	private int size, front, rear;
	
	private static final int CAPACITY = 16;

	public QueueServiceImpl() {
		this(CAPACITY);
	}
	
	public QueueServiceImpl(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		size = front = rear = 0;
	}
	
	//enQueue: Insert an element at the rear of the queue. O(1)
	public void enQueue(int data) {
		if(size == capacity) {
			System.out.println("Queue is full : OVERFLOW");
			System.exit(0);
		}
		size++;
		queue[rear] = data;
		rear = (rear+1) % capacity;
	}
	
	//deQueue: Remove the front element from the queue. O(1)
	public int deQueue() {
		if(size == 0) {
			System.out.println("Queue is empty : UNDERFLOW");
			System.exit(0);
		}
		size--;
		int data = queue[(front % capacity)];
		queue[front] = Integer.MIN_VALUE;
		front = (front+1) % capacity;
		return data;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == capacity);
	}
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String result = "[";
		for(int i = 0; i < size; i++) {
			result += Integer.toString(queue[(front+i)%capacity]);
			if(i < size-1) {
				result += ",";
			}
		}
		result += "]";
		return result;
	}
	
}
