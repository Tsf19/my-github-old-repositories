package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _23_PrintAllPathOfBinaryTree {

	public static void findPaths(BinaryTreeNode root) {

		
		int[] path = new int[256];
		findPaths(root, path, 0);
	}
	
	private static void findPaths(BinaryTreeNode root, int[] path, int pathLength) {
		
		if(root == null)
			return;
		
		//add this node to the path array
		path[pathLength] = root.data;
		pathLength++;
		
		//if it's a leaf node, so print the path that led to here
		if(root.left == null && root.right == null)
			printPath(path, pathLength);
		else {
			findPaths(root.left, path, pathLength);
			findPaths(root.right, path, pathLength);
		}
	}

	private static void printPath(int[] path, int pathLength) {
		
		for(int i = 0; i < pathLength; i++) {
			System.out.print(path[i]+" ");
		}
		System.out.println();
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
	
		findPaths(binaryTree);
	}
}
