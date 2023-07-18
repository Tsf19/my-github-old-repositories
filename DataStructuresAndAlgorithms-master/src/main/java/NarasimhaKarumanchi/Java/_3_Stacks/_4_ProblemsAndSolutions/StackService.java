package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author DOMAIN\md.tousif
 *
 * @param <T>
 */
public interface StackService <T> {

	int size();

	boolean isEmpty();

	T top() throws Exception;

	void push(T data);

	T pop() throws Exception;

}
