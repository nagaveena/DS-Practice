
public class LCA {
	public class Node{
		int val;
		Node left;
		Node right;
		public Node(int v) {
			val =v;
		}
	}
	
 public Node lca(Node root, Node n1, Node n2) {
	if (root == null) {
			return null;
	}
	if (root == n1 || root == n2) {
			return root;
	}

  Node left = lca(root.left, n1, n2);
  Node right = lca(root.right, n1, n2);
  
//if duplicates in BT then additional check s below needed
 // if(  left.val == n1 || left.val == n2
      // && (right.val == n1 || right.val == n2))
  if (left != null && right != null) {
	 return root;
  }
	return left != null ? left : right;
 }

 public static void main(String[] args) {
		// TODO Auto-generated method stub

}

}
