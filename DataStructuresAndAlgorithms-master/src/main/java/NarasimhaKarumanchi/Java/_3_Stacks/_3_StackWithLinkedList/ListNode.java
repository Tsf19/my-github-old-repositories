/**
 * 
 */
package NarasimhaKarumanchi.Java._3_Stacks._3_StackWithLinkedList;

/**
 * @author Tousif
 *
 */
public class ListNode{
	
	private int data;
	private ListNode next;
	
	public ListNode(int data){
		this.data = data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
	public ListNode getNext() {
		return this.next;
	}

	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}
}

