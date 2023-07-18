package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _30_BinaryTreeFromInOrderAndPostOrder {

	private static BinaryTreeNode buildBinaryTree(int[] postOrder, int[] inOrder) {
		
		if(postOrder.length == 0 || postOrder.length != inOrder.length)
			return null;

		return buildBinaryTree(postOrder, 0, postOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	

	private static BinaryTreeNode buildBinaryTree(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd) {

		if(postStart > postEnd || inStart > inEnd)
			return null;	
		
		int data = postOrder[postEnd];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		
		int offset = inStart;
		for(; offset < inEnd; offset++) {
			if(inOrder[offset] == data)
				break;
		}
		
		/**
		 *******START AND END INDEX OF POSTORDER :
		 * 
		 *	For left-subtree
		 * 		postStart	to	postStart+(offset-inStart)-1
		 *
		 *	For right-subtree
		 * 		postStart+(offset-inStart)	to	postEnd-1
		 * 
		 *******START AND END INDEX OF INORDER :
		 * 
		 *	For left-subtree
		 * 		inStart	to	offset-1
		 *
		 *	For right-subtree
		 * 		offset+1	to	inEnd
		 ************************************************/
		
		curr.left = buildBinaryTree(postOrder, postStart, postStart+(offset-inStart)-1, inOrder, inStart, offset-1); 
		curr.right = buildBinaryTree(postOrder, postStart+(offset-inStart), postEnd-1, inOrder, offset+1, inEnd);
		
		return curr;
	}


	public static void main(String[] args) {
		
		int[] postOrder = new int[] {10, 20, 15, 35, 25, 70, 80, 85, 75, 50};
		int[] inOrder = new int[] {10, 15, 20, 25, 35, 50, 70, 75, 80, 85};
	
		BinaryTreeNode binaryTree = buildBinaryTree(postOrder, inOrder);
		System.out.println(binaryTree);
	}

}
