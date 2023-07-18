package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DOMAIN\md.tousif
 * 
 * In preorder and inorder traversals, after popping the stack element we do not need to visit the
 * same vertex again. But in postorder traversal, each node is visited twice. That means, after
 * processing the left subtree we will visit the current node and after processing the right subtree we
 * will visit the same current node. But we should be processing the node during the second visit.
 * Here the problem is how to differentiate whether we are returning from the left subtree or the
 * right subtree.
 * We use a previous variable to keep track of the earlier traversed node. Let’s assume current is the
 * current node that is on top of the stack. When previous is current’s parent, we are traversing
 * down the tree. In this case, we try to traverse to current’s left child if available (i.e., push left
 * child to the stack). If it is not available, we look at current’s right child. If both left and right child
 * do not exist (ie, current is a leaf node), we print current’s value and pop it off the stack.
 * If prev is current’s left child, we are traversing up the tree from the left. We look at current’s right
 * child. If it is available, then traverse down the right child (i.e., push right child to the stack);
 * otherwise print current’s value and pop it off the stack. If previous is current’s right child, we are
 * traversing up the tree from the right. In this case, we print current’s value and pop it off the stack.
 */


public class _6_PostOrderIterative {

	public static List<Integer> postOrder(BinaryTreeNode root) {
		
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;

		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		
		BinaryTreeNode previousNode = null;
		
		while(!stack.isEmpty()) {
			BinaryTreeNode currentNode = stack.peek();

			if(previousNode == null || previousNode.left == currentNode || previousNode.right == currentNode) {
				//traverse from top to bottom, and if currentNode has left or right child,
				//push into the stack; otherwise, pop out

				if(currentNode.left != null)
					stack.push(currentNode.left);
				else
					if(currentNode.right != null)
						stack.push(currentNode.right);

			}
			else {
				if(currentNode.left == previousNode) { //means already been in left side
					if(currentNode.right != null)
						stack.push(currentNode.right);
				}
				else {
					result.add(currentNode.data);
					stack.pop();
				}
			}
			previousNode = currentNode;
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
		
		List<Integer> result = postOrder(binaryTree);
		System.out.println(result.toString());
	}
}
