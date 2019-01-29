//import BuildBalancedTree.TreeNode;

/**
 * 
 */

/**
 *Find deepest node
 *example:   a
   / \
  b   c
 /
**d
 *return d here 
 *
 */
public class FindDeepestNode {
	static int value = 0;
	static int maxLevel = 0;
	 static class Node
	    {
	        int val;
	        Node left;
	       Node right;

	       Node(int _val)
	        {
	            val = _val;
	            left = null;
	            right = null;
	        }
	    };
	  static class Result {
	       Node node;
	       int dist;
	       Result(Node n, int d) {
	            node = n;
	            dist = d;
	       }
	    }
	//Node root;
	 
	static int find_deepest_node(Node node,int level ) {
		
		//int left =0;
		//int right  =0;
		if (node == null)
			return 0 ;
		if(level > maxLevel) {
			value = node.val;
			maxLevel =level;
		}
		//if(node.left == null && node.right == null)
			//return 1;
		int  left  = 1+ find_deepest_node(node.left ,level+1);
		int  right = 1+find_deepest_node(node.right,level+1);
		return Math.max(left, right);
		//if(left > right) value =  node.left.val;
		//if(left < right) value =  node.right.val;
		//else value = node.val;
		//System.out.println("1.Deepest node Value::"+left + right + value );
		//return Math.max(left, right);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindDeepestNode find = new FindDeepestNode(); 
		Node tree = new Node(1);
	       // tree.root = new Node(1); 
	        tree.left = new Node(2); 
	        tree.right = new Node(3); 
	        tree.left.left = new Node(4); 
	        tree.left.right = new Node(5); 
	        tree.left.right.right = new Node(6);
	       int out =   find.find_deepest_node(tree,0);//,new Result(null,0));
	        System.out.println("Deepest node::"+out );
	        System.out.println("Deepest node Value::"+value );

	}

}
