/**
 * 
 */
package NarasimhaKarumanchi.Java._2_LinkedList;

/**
 * @author Tousif
 *
 */
public interface LinkedListService {

	ListNode getHead();
	
	int getLengthOfLinkedList();
	
	void insertAtEnd(int data);
	
	void insertAtBegining(int data);

	void insertAtPosition(int data, int position);
	
	void removeFromEnd();
	
	void removeFromBegining();

	void removeFromPosition(int position);
	
	void getNodeAtPosition(int data);
	
	void getFrquencyOfNode(int data);
	
	void displayLinkedList();

}
