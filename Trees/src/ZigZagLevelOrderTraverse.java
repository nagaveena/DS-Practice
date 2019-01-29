import java.util.*;
public class ZigZagLevelOrderTraverse {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        
	       
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        
	       List<List<Integer>> output = new LinkedList<>();
	        if(root == null ) return output;
	        q.add(root);
	        boolean reverse =false;
	        while(!q.isEmpty()){
	           int size = q.size();
	            reverse = !reverse;
	            LinkedList list =  new LinkedList<>();
	            while(size>0){
	               size--;
	               TreeNode n = q.poll();
	                if(reverse)
	                    list.add(n.val);
	                else
	                    list.addFirst(n.val);
	                if(n.left!=null)
	                    q.add(n.left);
	                if(n.right != null)
	                    q.add(n.right);
	          
	            }
	         output.add(list);
	        }
	     return output;   
	    }

}
