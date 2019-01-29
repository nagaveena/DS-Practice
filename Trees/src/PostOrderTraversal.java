
/*
 * Write a function to traverse a Binary tree PostOrder, without using recursion.
 *  As you traverse, please print contents of the nodes.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PostOrderTraversal {
	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int value) {
			this.val = value;
		}
	}

	static Node createTree(String data) {
		if (data == null || data.length() == 0)
			return null;
		StringTokenizer st = new StringTokenizer(data, " ");
		return deserialize(st);
	}

	static Node deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens())
			return null;
		String s = st.nextToken();
		if (s.equals("#"))
			return null;
		Node root = new Node(Integer.valueOf(s));
		root.left = deserialize(st);
		root.right = deserialize(st);

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}

	static void postorderTraversal(Node root) {

		Stack<Node> s = new Stack<Node>();
		// HashSet set = new HashSet<Integer>();
		Set set = new HashSet<Node>();
		s.push(root);

		while (!s.isEmpty()) {

			Node cur = s.peek();
			if (set.contains(cur) || (cur.left == null && cur.right == null)) {
				Node n = s.pop();
				System.out.print(n.val + " ");
				// if(set.size()>0)
			} else {
				if (cur.right != null) {// && !set.contains(((s.peek()).right).val)){
					s.push(cur.right);
				}
				if (cur.left != null) {// && !set.contains(((s.peek()).left).val)){
					s.push(cur.left);
				}
				set.add(cur);
				System.out.print(" ");
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _size;
		_size = Integer.parseInt(in.nextLine().trim());

		String _str;
		try {
			_str = in.nextLine();
		} catch (Exception e) {
			_str = null;
		}
		Node n = createTree(_str);
		postorderTraversal(n);

	}

}
