/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public class LinkedListServiceImplementatio implements LinkedListService {

	private ListNode head;

	public LinkedListServiceImplementatio() {
	}

	@Override
	public ListNode getHead() {
		return head;
	}

	/**
	 * Time Complexity: O(n), for scanning the list of size n.
	 * Space Complexity: O(1), for creating a temporary variable.
	 */
	@Override
	public int getLengthOfLinkedList() {
		int length = 0;
		if(head == null)
			return length;

		for(ListNode p = head; p != null; p = p.getNext(), ++length);
		return length;
	}

	@Override
	public synchronized void insertAtEnd(int data) {

		ListNode node = new ListNode(data);

		if(head == null) {
			head = node;
			return;
		}
		
		ListNode p;
		for(p = head; p.getNext() != null; p = p.getNext());
		p.setNext(node);
	}

	@Override
	public void insertAtBegining(int data) {

		ListNode node = new ListNode(data);
		node.setNext(head);
		head = node;

	}

	@Override
	public void insertAtPosition(int data, int position) {

		if(position < 0 ) {
			position = 0;
		}
		if(position > getLengthOfLinkedList()) {
			position = getLengthOfLinkedList()-1;
		}
		
		ListNode node = new ListNode(data);
		
		if(head == null) {
			head = node;
			return;
		}
		if(position == 0) {
			node.setNext(head);
			head = node;
			return;
		}
		
		ListNode temp = head;
		
		for(int i=1; i<position; i++)
			temp = temp.getNext();
		
		node.setNext(temp.getNext());
		temp.setNext(node);
	}

	@Override
	public void removeFromEnd() {

		if(head == null)
			return;
		
		if(head.getNext() == null) {
			head.setNext(null);
			return;
		}
		
		ListNode p,q=null;
		for(p = head; p.getNext() != null; q = p, p = p.getNext());
			q.setNext(null);
	}

	@Override
	public void removeFromBegining() {

		if(head == null)
			return;
		
		ListNode temp = head;
		head = head.getNext();
		temp.setNext(null);
		
	}

	@Override
	public void removeFromPosition(int position) {
		
		if(head == null)
			return;
		
		if(head.getNext() == null) {
			head.setNext(null);
			return;
		}
		
		if(position <= 0 ) {
			ListNode temp = head;
			head = head.getNext();
			temp.setNext(null);
			return;
		}
		if(position > getLengthOfLinkedList()) {
			position = getLengthOfLinkedList()-1;
		}
		
		ListNode p = head, q = null;
		
		for(int i=0; i<position; i++) {
			q = p;
			p = p.getNext();
		}
		
		q.setNext(p.getNext());
		p.setNext(null);
		
	}

	@Override
	public void getNodeAtPosition(int data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void getFrquencyOfNode(int data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void displayLinkedList() {
		if(head == null)
			System.out.println("[ ]");
		else {
			System.out.print(head.getData()+"-->");
			ListNode temp = head.getNext();
			while(temp != null) {
				if(temp.getNext() != null)
					System.out.print(temp.getData()+"-->");
				else
					System.out.print(temp.getData());
				temp = temp.getNext();
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		String result = "[";

		if(head == null)
			return result + "]";
		else {
			result = result + head.getData();
			ListNode temp = head.getNext();
			while(temp != null) {
				result = result + "," + temp.getData();
				temp = temp.getNext();
			}
			return result + "]";
		}
	}
}
