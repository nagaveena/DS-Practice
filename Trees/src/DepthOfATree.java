
public class DepthOfATree {
	
	public class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		  }
	
		int max =0;
		public int diameterOfBinaryTree(TreeNode root) {
		        
		   if(root == null ) return 0;
		   
  	       int left =  diameterOfBinaryTree( root.left);
		   int right =  diameterOfBinaryTree( root.right);
		        
		   max = Math.max (max,left+right+1);
		 return(Math.max(left,right)+1);   
	 }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

}
