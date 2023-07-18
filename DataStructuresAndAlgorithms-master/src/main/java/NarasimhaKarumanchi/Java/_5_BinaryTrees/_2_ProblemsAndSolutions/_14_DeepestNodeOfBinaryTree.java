package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import java.util.LinkedList;
import java.util.Queue;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _14_DeepestNodeOfBinaryTree {

	public static Integer deepest(BinaryTreeNode root) {

		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return root.data;
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		
		BinaryTreeNode currentNode = null;
		
		while(!queue.isEmpty()) {
			
			currentNode = queue.poll();
			
			if(currentNode != null) {

				if(currentNode.left != null)
					queue.offer(currentNode.left);
				
				if(currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		
		return currentNode.data ;
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
	
		int deepest = deepest(binaryTree);
		System.out.println(deepest);
	}
}
