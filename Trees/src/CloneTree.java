
public class CloneTree {
	
	static class Node {
        int val;
        Node left;
        Node right;
        
        public Node(int value) {
            this.val = value;
        }
    }
	
	
	static Node cloneTree(Node root) {
	     if(root == null) return root;
	   
	     
	     Node cloneRoot = new Node(root.val);
	     cloneRoot.left  = cloneTree(root.left);
	     cloneRoot.right = cloneTree(root.right);
	     
	         
	     return cloneRoot;     
	  
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
