/**
 * 
 */

/**
 * @author rajukris
This is a very well known interview problem: Given a Binary Tree, check if it is a Binary Search Tree (BST). 
A valid BST doesn't have to be complete or balanced. Duplicate elements are not allowed in a BST.
 *
 */

	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class CheckForBST {
	    static class Node {
	        int val;
	        Node left;
	        Node right;
	        
	     public Node(int value) {
	        this.val = value;
	     }
	  }
   
	
	
	 static boolean isBST(Node root) {
	       // return checkForBST( root);
	   return  checkForBSTNew( root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    
	 }
	  static boolean checkForBSTNew(Node root,int min,int max) {
		  
		  if(root == null) return true;
		  
		  if(root.val <= min || root.val >= max)
		     return false;
		  boolean left = checkForBSTNew(root.left,min,root.val);
		  boolean right = checkForBSTNew(root.right,root.val,max);
		  return (left && right);
		  
	  }
	  static boolean checkForBST(Node root){
	      if(root == null) return true;
	        if(root.left == null && root.right == null) return true;
	        int max = findMax(root.left);
	        int min = findMin(root.right);
	          
	           if(root.right==null)
	               return root.left.val < root.val  && root.val > max && checkForBST(root.left);
	           if(root.left == null)
	               return root.right.val > root.val  && root.val < min && checkForBST(root.right);
	           
	            boolean left = ( root.left.val < root.val  && root.val > max && checkForBST(root.left));
	            boolean right  = root.right.val > root.val  && root.val < min && checkForBST(root.right);
	            
	            return (left && right);
	         
	    }
	    static int findMax(Node left){
	        if(left ==null ) return Integer.MAX_VALUE;
	        if(left.right == null) return left.val;
	        else
	          return findMax(left.right);
	            
	    }
	    static int findMin(Node right){
	        if(right == null) return Integer.MIN_VALUE;
	        if(right.left == null) return right.val;
	        else
	         return findMin(right.left);
	    }
  
	    public static void main(String[] args) throws IOException{
	        
	    	CheckForBST tree = new CheckForBST(); 
	    	Node root;
	        root = new Node(4); 
	        root.left = new Node(2); 
	        root.right = new Node(5); 
	        root.left.left = new Node(1); 
	        root.left.right = new Node(3); 
	      //  root.left.right = new Node(7); //---> To test NOT BST uncomment
	        if(tree.checkForBST(root))
	        	System.out.println("Tree is BST");
	        else
	        	System.out.println("Tree is NOT BST");
	    	
	    	
	    }

	}




