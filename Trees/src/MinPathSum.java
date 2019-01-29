
/*
 * Given a binary tree, find a minimum path sum from root to a leaf.

For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

 10
/  \
5    5
\     \
  2    1
      /
    -1
 */
import java.util.*;

public class MinPathSum {
	public static class Node {
		int val;
		Node left;
		Node right;

		public Node(int v) {
			this.val = v;
		}
	}

	List<Node> path = new ArrayList<Node>();
	public int min = Integer.MAX_VALUE;

	public void findMinPathSum(Node n, int sum) {
		if (n == null)
			return;
		if (n.left == null && n.right == null) {
			// System.out.println("1.min:"+ min + "sum:"+sum );
			min = Math.min(min, sum + n.val);
			// System.out.println("2.min:"+ min + "sum:"+ sum);
			sum = 0;
			return;
		}
		findMinPathSum(n.left, sum + n.val);

		findMinPathSum(n.right, sum + n.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPathSum find = new MinPathSum();
		/* create root */
		Node root = new Node(10);

		root.left = new Node(5);
		root.right = new Node(5);
		// root.left.left = new Node("3");
		root.left.right = new Node(2);

		root.right.right = new Node(1);
		root.right.right.left = new Node(-1);

		find.findMinPathSum(root, 0);
		System.out.println("Min Sum:" + find.min);
	}

}
