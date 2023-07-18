package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DOMAIN\md.tousif
 * This is similar to pre-order, only change is, instead of processing the node before going to left sub-tree,
 * process it after popping.(which is indicated after completion of left subtree processing).
 */


public class _5_InOrderIterative {

	public static List<Integer> inOrder(BinaryTreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;

		StackService<BinaryTreeNode> stack = new StackServiceImplementation<>();
		BinaryTreeNode currentNode = root;
		Boolean done = false;
		
		while(!done) {
			
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			}
			else {
				if(stack.isEmpty())
					done = true;
				else {
					currentNode = stack.pop();
					result.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
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
		
		List<Integer> result = inOrder(binaryTree);
		System.out.println(result.toString());
	}
}
