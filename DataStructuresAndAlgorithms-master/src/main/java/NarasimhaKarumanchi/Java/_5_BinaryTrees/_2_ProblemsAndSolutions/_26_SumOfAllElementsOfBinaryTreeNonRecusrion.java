package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import java.util.LinkedList;
import java.util.Queue;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _26_SumOfAllElementsOfBinaryTreeNonRecusrion {


	private static int calculateSum(BinaryTreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			sum += temp.getData();

			if (temp.getLeft() != null)
				queue.offer(temp.getLeft());
			if (temp.getRight() != null)
				queue.offer(temp.getRight());
		}
		
		return sum;
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
		
		int sum = calculateSum(binaryTree);
		System.out.println(sum); //572
	
	}
}
