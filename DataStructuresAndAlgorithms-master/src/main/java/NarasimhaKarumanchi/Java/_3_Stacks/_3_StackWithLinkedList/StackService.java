package NarasimhaKarumanchi.Java._3_Stacks._3_StackWithLinkedList;

public interface StackService {

	int size();

	boolean isEmpty();

	int top() throws Exception;

	void push(int data) throws Exception;

	int pop() throws Exception;

}
