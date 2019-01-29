/*
 * Write a recursive function treeToList(Node root) that takes a BST and rearranges the internal pointers to make
 *  a circular doubly linked list out of the tree nodes.
 *  The "previous" pointers should be stored in the "Left" field and the "next" pointers should be stored in 
 *  the "Right" field. The list should be arranged so that the nodes are in increasing order. 
 *  Print the resulting linked list starting from its head node.
 *  (see test-case output to understand the formatting). The operation can be done in O(n) time.
 */

	import java.util.*;




	public class ConvertBSTToLinkedList {
	       static class Node {
	        int val;
	        Node left;
	        Node right;
	        public Node(int value) {
	            this.val = value;
	        }
	    }

	  
	    
	    static void BSTtoLL(Node root) {
	    	System.out.print("in method");
	        Node print =  convertToLL(root);
	      // print =  (root);
	        while(print != null){
	            System.out.print(print.val );
	            if(print.right != null)
	            System.out.print( " ");
	            print = print.right;
	        }
	        
	     }
	     static Node convertToLL(Node root){
	         if (root == null || (root.left == null && root.right == null))  return root;
	       
	         Node left  = convertToLL(root.left);
	         
	         if(left == null) 
	            left =root;
	         else{
	        	 System.out.println("left:"+left.val);
	          Node temp = left;
	          while(temp.right != null){
	              temp = temp.right;
	          }
	          temp.right =root;
	          root.left = temp;
	         }
	        
	         Node right =  convertToLL(root.right);
	         
	         if(right == null)
	            root.right =null;
	         else{
	        	 System.out.println("right:"+right.val);
	           root.right = right;
	           right.left = root;
	         }
	      return left; 
	    }
	    
	    public static void main(String[] args){
	        
	    	
	      //  Node n = createTree(_str);
	        Node n = new Node(1);
		       n.left = new Node(2);
		       n.right = new Node(3);
		       n.left.left =  new Node(4);
		       n.left.right = new Node(5);
		       System.out.println("hello");
	        BSTtoLL(n);
	        
	    }
	
}
