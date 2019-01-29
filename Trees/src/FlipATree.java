

/*
 * Reverse a general binary tree, i.e. flip it from right to left.

*So for example if we had the binary tree

 *    6
*   /   \
*  3     4
* / \   / \
*7   3 8   1
*Reversing it would create

 *    6
 *  /   \
 * 4     3
* / \   / \
**1   8 3   7
 */

public class FlipATree {
	static class Node {
        int val;
        Node left;
        Node right;
        
        public Node(int value) {
            this.val = value;
        }
    }
	
	
static Node flipTree(Node node) {
        
        if(node == null ) return node;
        
        Node left  = flipTree(node.left);
        Node right = flipTree(node.right);
        
        node.left = right;
        node.right = left;
        return node;

    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
