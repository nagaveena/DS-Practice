
public class BTMaxSumPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	
	    int max = 0;
	    public int maxPathSum(TreeNode root) {
	        if(root == null) return 0;
	        findSum(root);
	        return max;
	        
	    }
	    public int findSum(TreeNode root){
	        if(root == null )return 0;
	        int left = findSum(root.left);
	        int right = findSum(root.right);
	        max= Math.max(max,left+right+root.val);
	        return Math.max(left,right)+root.val;
	    }
	

}
