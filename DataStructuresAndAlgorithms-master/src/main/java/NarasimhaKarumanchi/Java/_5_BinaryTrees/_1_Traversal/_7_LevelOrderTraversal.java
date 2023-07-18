package NarasimhaKarumanchi.Java._5_BinaryTrees._1_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _7_LevelOrderTraversal {

	private static List<ArrayList<Integer>> levelOrder(BinaryTreeNode root) {
		
		List<ArrayList<Integer>> result = new ArrayList<>();
		
		if(root == null)
			return result;
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		List<Integer> current = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			BinaryTreeNode temp = queue.poll();
			if(temp != null) {
				current.add(temp.data);
				
				if(temp.left != null)
					queue.offer(temp.left);
					
				if(temp.right != null)
					queue.offer(temp.right);
			}
			else {
				ArrayList<Integer> list = new ArrayList<>(current);
				result.add(list);
				
				current.clear();
				//completion of a level;
				if(!queue.isEmpty())
					queue.offer(null);
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
		
		List<ArrayList<Integer>> result = levelOrder(binaryTree);
		System.out.println(result.toString());
	}

}
