
public class UpsideDown {
	 public Node upsideDownBinaryTree(Node root, Node parent, Node rightChild) {
	        if (root == null) {
	            return parent;
	        }
	        Node left = root.left;
	        Node right = root.right;

	        root.right = parent;
	        root.left = rightChild;

	        return upsideDownBinaryTree(left, root, right);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
