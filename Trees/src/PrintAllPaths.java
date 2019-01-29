/*
 * (Facebook question)

Given a binary tree, print out all of its root-to-leaf paths one per line.

e.g. for a tree that's 

   1
 2  3
4 5 6 7

Print:

1 2 4
1 2 5
1 3 6
1 3 7
 */


	
	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class PrintAllPaths {
	    static class Node {
	        int val;
	        Node left;
	        Node right;
	        public Node(int value) {
	            this.val = value;
	        }
	    }

	  
	    
	    static void printAllPaths(Node root) {
            
	         printPaths(root,"") ;    

	    }
	    
	    static void printPaths(Node root,String soFar) {
	        if(root == null) return;
	       if(root.left == null && root.right ==null){
	            //soFar += soFar +" " + root.val;
	            System.out.println(soFar+root.val );//+ String.valueOf(root.val) +" ");
	            //return;
	        }
	     //   printPaths(root.left,soFar +  String.valueOf(root.val) + " ");
	        printPaths(root.left,soFar +  root.val + " ");
	        
	        printPaths(root.right,soFar + (root.val) + " " );
	           
	    }    
	    static Node createTree(String data) {
	        if (data == null || data.length() == 0) return null;
	        StringTokenizer st = new StringTokenizer(data, " ");
	        return deserialize(st);
	    }

	    static Node deserialize(StringTokenizer st) {
	        if (!st.hasMoreTokens())
	            return null;
	        String s = st.nextToken();
	        if (s.equals("#"))
	            return null;
	        Node root = new Node(Integer.valueOf(s));
	        root.left = deserialize(st);
	        root.right = deserialize(st);

	        return root;
	    }
	    public static void main(String[] args){
	       Node n = new Node(1);
	       n.left = new Node(2);
	       n.right = new Node(3);
	       n.left.left =  new Node(4);
	       n.left.right = new Node(5);
	        printAllPaths(n);
	        
	    }

}


