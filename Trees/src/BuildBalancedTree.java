
public class BuildBalancedTree {
	 static class TreeNode
	    {
	        int val;
	        TreeNode left_ptr;
	        TreeNode right_ptr;

	        TreeNode(int _val)
	        {
	            val = _val;
	            left_ptr = null;
	            right_ptr = null;
	        }
	    };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuildBalancedTree tree = new BuildBalancedTree(); 
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7}; 
        int n = arr.length; 
        head = tree.build_balanced_bst(arr); 
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(head);

	}
	void preOrder(TreeNode node) { 
        if (node == null) { 
            return; 
        } 
        System.out.print(node.val + " "); 
        preOrder(node.left_ptr); 
        preOrder(node.right_ptr); 
    } 
	static TreeNode head = null;
    static TreeNode build_balanced_bst(int[] a) 
    {
        
        return buildTree( a ,0,a.length-1);
        
    }
    static TreeNode buildTree(int[] a ,int start,int end){
        // System.out.println("mid:" + a[0] );
    	   if(start>end)
    		return null;
          // if(start < end) {
           
          /// int mid1 = start + (end - start) / 2;
          // int mid2 = start + (end - start + 1) / 2;
            int mid = (start+end)/2;
       
            TreeNode root = new TreeNode(a[mid]);
           // if(head == null ) head =root;
            root.left_ptr = buildTree(a,start,mid-1);
            root.right_ptr = buildTree(a,mid+1,end);
          // }
            return root;
       
    }

    
    
}
