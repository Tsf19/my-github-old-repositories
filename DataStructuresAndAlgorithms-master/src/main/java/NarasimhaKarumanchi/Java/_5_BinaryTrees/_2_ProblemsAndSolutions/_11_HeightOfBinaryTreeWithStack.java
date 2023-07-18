package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import java.util.Stack;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _11_HeightOfBinaryTreeWithStack {

	public static int maxDepth(BinaryTreeNode root) {
		
		if((root == null) || (root.left == null && root.right == null))
			return 0;
		
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);
		
		int maxDepth = 0;
		
		BinaryTreeNode previous = null;
		
		while(!stack.isEmpty()) {
			BinaryTreeNode current = stack.peek();
			if(previous == null || previous.left == current || previous.right == current) {
				if(current.left != null)
					stack.push(current.left);
				else if(current.right != null)
					stack.push(current.right);
			}
			else 
				if(current.left == previous) {
					if(current.right != null)
						stack.push(current.right);
				}
				else
					stack.pop();
			
			previous = current;
			
			if(stack.size()-1 > maxDepth)
				maxDepth = stack.size()-1;
		}
		
		return maxDepth;
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
		
		binaryTree.right.left.right.left = new BinaryTreeNode(71);
	
		int maxDepth = maxDepth(binaryTree);
		System.out.println(maxDepth);
	}
}
