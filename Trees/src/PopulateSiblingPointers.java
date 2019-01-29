import java.util.*;

//Given a binary tree, populate nextRight pointers in each node and return the root of the tree.

//* Constraint: Use only constant extra space.
public class PopulateSiblingPointers {
	
	public static class Node{
		int val;
		Node left,right,nextRight;
		public Node(int data) {
			val = data;
		}
	}

	
	static Node populateSiblingPointers(Node root) {
		//DFS way with extra space
	     connectDFSHelper(root,null);
	    //BFS way with queue holding h nodes
	      BFSHelper(root);
	     return root;

	 }
	    public static void connectDFSHelper(Node cur, Node next) {
	        if (cur==null) return;
	        if (cur.left == null || cur.right == null) return;
	        cur.left.nextRight = cur.right;
	        if (next !=null) {
	            if(next.left !=null)
	              cur.right.nextRight = next.left;
	            else 
	              cur.right.nextRight = next.right;
	        }
	        connectDFSHelper(cur.left, cur.right);
	        connectDFSHelper(cur.right, cur.right.nextRight);
	    }
	    public static void BFSHelper(Node root){
	        Queue<Node> q = new LinkedList<Node>();
	        q.add(root);
	        int size  = 0;
	        while(!q.isEmpty())
	        {
	          size = q.size();
	          for(int i = 0; i < size ;i++){
	            Node n = q.poll();
	            if( i+1 == size)
	              n.nextRight = null;
	              else{
	                n.nextRight = q.peek();  
	              }
	             if(n.left != null ) 
	              q.add(n.left) ;
	             if(n.right != null )  
	              q.add(n.right);
	          }
	        }
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
