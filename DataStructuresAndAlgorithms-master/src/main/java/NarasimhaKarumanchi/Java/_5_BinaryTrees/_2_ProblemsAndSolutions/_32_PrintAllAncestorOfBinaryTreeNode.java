package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _32_PrintAllAncestorOfBinaryTreeNode {

	private static boolean printAllAncestor(BinaryTreeNode root, BinaryTreeNode node) {
		
		if(root == null)
			return false;
		
		if(root.getLeft() == node || root.getRight() == node || printAllAncestor(root.getLeft(), node) || printAllAncestor(root.getRight(), node)) {
			System.out.println(root.getData());
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(50);
		root.left = new BinaryTreeNode(25);
		root.right = new BinaryTreeNode(75);
		
		root.left.left = new BinaryTreeNode(20);
		root.left.right = new BinaryTreeNode(35);
		
		root.right.left = new BinaryTreeNode(70);
		root.right.right = new BinaryTreeNode(80);
		
		root.left.left.left = new BinaryTreeNode(15);
		
		root.left.right.left = new BinaryTreeNode(30);
		root.left.right.right = new BinaryTreeNode(40);
		
		root.right.left.left = new BinaryTreeNode(60);
		root.right.left.right = new BinaryTreeNode(72);
		
		root.right.left.right.left = new BinaryTreeNode(71);
	
		BinaryTreeNode node = root.right.left.right.left; //71
		
		printAllAncestor(root, node); //72, 70, 75, 50
	}

}
