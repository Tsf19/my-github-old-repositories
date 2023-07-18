/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */

public class LinkedListApp {
	
	public static void main(String[] args) {

		LinkedListService list = new LinkedListServiceImplementatio();
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.insertAtEnd(50);
		list.insertAtEnd(60);

		list.displayLinkedList();

		list.insertAtPosition(40, 3);
		
		list.displayLinkedList();
		
		list.insertAtBegining(9);
		list.insertAtBegining(8);
		
		list.displayLinkedList();

		list.insertAtPosition(7, 0);
		list.insertAtBegining(6);
		
		list.displayLinkedList();
		
		list.removeFromBegining();

		list.displayLinkedList();
		
		list.removeFromEnd();
		
		list.displayLinkedList();
		
		list.removeFromEnd();
		
		list.removeFromPosition(1);
		
		list.displayLinkedList();
		
		System.out.println(list);
		
		System.out.println("LengthOfLinkedList : "+list.getLengthOfLinkedList());
	}

}
