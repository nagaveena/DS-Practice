
/*
 * Given a binary tree, we need to count the number of unival subtrees (all nodes that have the same value). 



e.g. Given the following tree, it has 6 unival subtrees.

5
/ \
5  5
/\ /\
5 5 5 5
 * 
 */
	
	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class SingleValueTree {
		
	    public static class Node {
	        int val;
	        Node left;
	        Node right;
	        public Node(int value) {
	            this.val = value;
	        }
	    }

	    
 static int count  = 0;
 static int findSingleValueTrees(Node n) {
	        
	       // return countUniValues(n);
	       countUniValues(n);
	      // System.out.println("count:" +count);
	       return count;
}
	   
	    
 static boolean countUniValues(Node n )
 {
		if (n == null)
			return false;
		if (n.left == null && n.right == null) {
			count += 1;
			return true;
		}
		boolean left = countUniValues(n.left);
		boolean right = countUniValues(n.right);

		if (n.right == null && n.left != null) {
			if (n.left.val == n.val) {
				count += 1;
				return true;
			}
		}
		if (n.left == null && n.right != null) {
			if (n.right.val == n.val) {
				count += 1;
				return true;
			}

		}
		if ((left && right) && n.left.val == n.val && n.right.val == n.val) {
			count += 1;
			return true;
		}

		return false;
}

 static int countUniValues(Node n,int data )
 {
    if(n == null) return data;
      
    int left =  countUniValues(n.left,n.val);
    int right = countUniValues(n.right,n.val);
    
    if(left == right && left== n.val) {
    	count++;
    	return n.val;
    }else 
      return Integer.MAX_VALUE;	
 }
	
  public static void main(String[] args) {
	  SingleValueTree bt = new SingleValueTree();
	   Node root = new Node(5);
	   root.left = new Node(5);
	   root.right = new Node(5);
	   root.left.left = new Node(5);
       root.left.right = new Node(5);
       root.right.right = new Node(6);
	   
       Node r = new Node(1);
    //   System.out.println(bt.findSingleValueTrees(r));
       
       System.out.println(countUniValues(root,0));
       System.out.println(count);
	}

}
