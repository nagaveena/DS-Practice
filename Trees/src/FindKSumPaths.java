import java.util.*;

public class FindKSumPaths {
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int val) {
			data = val;
		}
	}
 public boolean findKSumPaths(Node root,int k, List<Node> list) {
	 if(root == null ) return false;
	 if(root.left == null && root.right == null) {
		 if(root.data == k) {
			 list.add(root);
			 return true;
		 }else return false;
	 }
	 if(findKSumPaths( root.left, k-root.data, list)) {
		 list.add(root);
		 return true;
	 }
	 if(findKSumPaths( root.right, k-root.data, list)) {
		 list.add(root);
		 return true;
	 }
	 return false;
	 
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindKSumPaths find = new FindKSumPaths();
		Node root = new Node(5);
		find.findKSumPaths( root,5, new ArrayList<Node>());
	}

}
