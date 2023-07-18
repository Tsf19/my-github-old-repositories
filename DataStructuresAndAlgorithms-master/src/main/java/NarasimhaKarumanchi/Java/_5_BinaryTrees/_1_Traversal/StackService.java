package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

/**
 * @author DOMAIN\md.tousif
 *
 * @param <T>
 */
public interface StackService<T> {

	int size();

	boolean isEmpty();

	T top();

	void push(T data);

	T pop();

	T peek();

}
