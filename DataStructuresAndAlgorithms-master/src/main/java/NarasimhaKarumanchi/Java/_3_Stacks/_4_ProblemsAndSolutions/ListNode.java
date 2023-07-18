/**
 * 
 */
package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author Tousif
 *
 */
public class ListNode<T>{
	
	private T data;
	private ListNode<T> next;
	
	public ListNode(T data){
		this.data = data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}
	
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
	public ListNode<T> getNext() {
		return this.next;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}
}

