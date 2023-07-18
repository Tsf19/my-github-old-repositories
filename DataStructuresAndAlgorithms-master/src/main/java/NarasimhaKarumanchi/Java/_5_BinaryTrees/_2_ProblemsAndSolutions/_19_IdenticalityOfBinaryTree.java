package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _19_IdenticalityOfBinaryTree {

	public static Boolean identicality(BinaryTreeNode root1, BinaryTreeNode root2) {

		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		return identicality(root1.left, root2.left) && identicality(root1.right, root2.right);
		
	}
	
	public static void main(String[] args) {
		
		BinaryTreeNode binaryTree1 = new BinaryTreeNode(50);
		binaryTree1.left = new BinaryTreeNode(25);
		binaryTree1.right = new BinaryTreeNode(75);
		
		binaryTree1.left.left = new BinaryTreeNode(20);
		binaryTree1.left.right = new BinaryTreeNode(35);
		
		binaryTree1.right.left = new BinaryTreeNode(70);
		binaryTree1.right.right = new BinaryTreeNode(80);
		
		binaryTree1.left.left.left = new BinaryTreeNode(15);
		
		binaryTree1.left.right.left = new BinaryTreeNode(30);
		binaryTree1.left.right.right = new BinaryTreeNode(40);
		
		binaryTree1.right.left.left = new BinaryTreeNode(60);
		binaryTree1.right.left.right = new BinaryTreeNode(72);
		
		binaryTree1.right.left.right.left = new BinaryTreeNode(71);
	
		BinaryTreeNode binaryTree2 = new BinaryTreeNode(50);
		binaryTree2.left = new BinaryTreeNode(25);
		binaryTree2.right = new BinaryTreeNode(75);
		
		binaryTree2.left.left = new BinaryTreeNode(20);
		binaryTree2.left.right = new BinaryTreeNode(35);
		
		binaryTree2.right.left = new BinaryTreeNode(70);
		binaryTree2.right.right = new BinaryTreeNode(80);
		
		binaryTree2.left.left.left = new BinaryTreeNode(15);
		
		binaryTree2.left.right.left = new BinaryTreeNode(30);
		binaryTree2.left.right.right = new BinaryTreeNode(40);
		
		binaryTree2.right.left.left = new BinaryTreeNode(60);
		binaryTree2.right.left.right = new BinaryTreeNode(72);
		
		binaryTree2.right.left.right.left = new BinaryTreeNode(71);
		
		Boolean identicality = identicality(binaryTree1, binaryTree2);
		System.out.println(identicality);
	}
}
