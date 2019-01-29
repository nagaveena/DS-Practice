//import SingleValueTree.Node;
import java.util.*;


public class PostOrderNonRecursive {
 public static class Node {
	        int val;
	        Node left;
	        Node right;
	        
	   public Node(int value) {
	     this.val = value;
	     }
  }
	
	void postOrderTraversal(Node root) {
		
    Stack<Node> stack = new Stack<Node>();
    Set<Node> seen = new HashSet<Node>();
    stack.push(root);
    
    while(!stack.isEmpty()) {
    	Node n  =  stack.peek();
    	if(seen.contains(n) || (n.left == null && n.right == null)) {
    		n = stack.pop();
    		System.out.println(n.val);
    	}else {
    		if(n.right != null)
    			stack.push(n.right);
    		if(n.left != null)
    			stack.push(n.left);
    		seen.add(n);
    	}
      }

	}
	
	public void printAllPaths(Node root , String s){
	  if(root == null)
		  return ;
	  if(root.left == null && root.right == null)
		// String.valueOf(root.val);
		  System.out.println("path:" + s + root.val);
	  
	  printAllPaths(root.left,s+String.valueOf(root.val)+" ");
	 // String l= s+left;
	  System.out.println("before right" + s);
	  printAllPaths(root.right,s+String.valueOf(root.val)+" ");
	  
	 // String r = s+right;
	 // System.out.println("Left:" + left);
	 // System.out.println("right:" + right);
	 // return "";
	  
	  
	}
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PostOrderNonRecursive tree = new PostOrderNonRecursive(); 
    	Node root;
        root = new Node(5); 
        root.left = new Node(3); 
        root.right = new Node(7); 
        root.left.left = new Node(2); 
        root.left.right = new Node(4); 
        root.right.left = new Node(6); 
        root.right.right = new Node(8); 
      
        tree.postOrderTraversal(root);
        tree.printAllPaths(root, "");

	}

}
