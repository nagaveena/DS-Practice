//implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

//1. Calling next() will return the next smallest number in the BST.

///2. Calling hasNext() should return whether the next element exists.

//Both functions should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
import java.util.*;


public class TreeIterator {
	
	public static class Node{
		int val;
		Node left,right;
		public Node(int data) {
			val = data;
		}
	}
	
	public Stack<Node> iter = new Stack<Node>();
	public TreeIterator(Node root) {
		populate(root);
	}
	public void populate(Node root) {
		if(root == null) return;
		iter.push(root);
		populate(root.left);
	}
	
	public boolean hasNext() {
		if(!iter.isEmpty())
			return true;
		return false;
	}
	public Node next() {
		Node next = iter.pop();
		if(next.right != null)
			populate(next.right);
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root =new Node(5);
		 //root = new Node(4); 
	        root.left = new Node(2); 
	        root.right = new Node(8); 
	        root.left.left = new Node(1); 
	        root.left.right = new Node(3); 
		
		TreeIterator iterator = new TreeIterator(root);
		while(iterator .hasNext()) {
			Node n = iterator.next();
			System.out.println("node val:"+ n.val);
		}

	}

}
