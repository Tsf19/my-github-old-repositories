package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DOMAIN\md.tousif
 *
 * In the recursive version, a stack is required as we need to remember the current node so that after
 * completing the left subtree we can go to the right subtree. To simulate the same, first we process
 * the current node and before going to the left subtree, we store the current node on stack. After
 * completing the left subtree processing, pop the element and go to its right subtree. Continue this
 * process until stack is nonempty.
 */


public class _4_PreOrderIterative {

	public static List<Integer> preOrder(BinaryTreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;

		StackService<BinaryTreeNode> stack = new StackServiceImplementation<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			result.add(temp.data);
			//IMPORTANT NOTE : First Push Right, Then Push Left
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode binaryTree = new BinaryTreeNode(50);
		binaryTree.left = new BinaryTreeNode(25);
		binaryTree.right = new BinaryTreeNode(75);
		
		binaryTree.left.left = new BinaryTreeNode(20);
		binaryTree.left.right = new BinaryTreeNode(35);
		
		binaryTree.right.left = new BinaryTreeNode(70);
		binaryTree.right.right = new BinaryTreeNode(80);
		
		binaryTree.left.left.left = new BinaryTreeNode(15);
		
		binaryTree.left.right.left = new BinaryTreeNode(30);
		binaryTree.left.right.right = new BinaryTreeNode(40);
		
		binaryTree.right.left.left = new BinaryTreeNode(60);
		binaryTree.right.left.right = new BinaryTreeNode(72);
		
		List<Integer> result = preOrder(binaryTree);
		System.out.println(result.toString());
	}
}
