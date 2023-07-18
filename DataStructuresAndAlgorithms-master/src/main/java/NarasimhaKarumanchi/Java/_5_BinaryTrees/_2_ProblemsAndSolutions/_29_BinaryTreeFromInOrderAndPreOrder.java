package NarasimhaKarumanchi.Java._5_BinaryTrees._2_ProblemsAndSolutions;

import NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal.BinaryTreeNode;

public class _29_BinaryTreeFromInOrderAndPreOrder {

	private static BinaryTreeNode buildBinaryTree(int[] preOrder, int[] inOrder) {
		
		if(preOrder.length == 0 || preOrder.length != inOrder.length)
			return null;

		return buildBinaryTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	

	private static BinaryTreeNode buildBinaryTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {

		if(preStart > preEnd || inStart > inEnd)
			return null;	
		
		int data = preOrder[preStart];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		
		int offset = inStart;
		for(; offset < inEnd; offset++) {
			if(inOrder[offset] == data)
				break;
		}
		
		/**
		 *******START AND END INDEX OF PREORDER :
		 * 
		 *	For left-subtree
		 * 		preStart + 1	to	preStart+(offset-inStart)
		 *
		 *	For right-subtree
		 * 		preStart+(offset-inStart) + 1	to	preEnd
		 * 
		 *******START AND END INDEX OF INORDER :
		 * 
		 *	For left-subtree
		 * 		inStart	to	offset-1
		 *
		 *	For right-subtree
		 * 		offset+1	to	inEnd
		 ************************************************/
		
		curr.left = buildBinaryTree(preOrder, preStart + 1, preStart+(offset-inStart), inOrder, inStart, offset-1); 
		curr.right = buildBinaryTree(preOrder, preStart+(offset-inStart) + 1, preEnd, inOrder, offset+1, inEnd);
		
		return curr;
	}


	public static void main(String[] args) {
		
		int[] preOrder = new int[] {50, 25, 15, 10, 20, 35, 75, 70, 85, 80};
		int[] inOrder = new int[] {10, 15, 20, 25, 35, 50, 70, 75, 80, 85};
	
		BinaryTreeNode binaryTree = buildBinaryTree(preOrder, inOrder);
		System.out.println(binaryTree);
	}

}
