package NarasimhaKarumanchi.Java._3_Stacks._2_DynamicArrayStack;

public interface StackService {

	int size();

	boolean isEmpty();

	int top() throws Exception;

	void push(int data) throws Exception;

	int pop() throws Exception;

}
