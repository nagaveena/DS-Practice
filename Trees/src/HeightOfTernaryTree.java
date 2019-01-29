
import java.util.*;
public class HeightOfTernaryTree {

	
	public static class Node{
		   int val;
		   //Node left;
		   //Node right;
		   //Node middle;
		   List<Node> children;
	   
     public Node(int val) {
		   this.val = val;
		   children = new ArrayList<Node>();
	    
	   }
  }
	
	public static int findMaximumHeight(Node root) {
		if(root == null ) return 0;
		int max = 1;
		//if(root.children == null) return 1;
		for(Node c: root.children) {
			System.out.println(c.val + "," +max);
			int ht = 1+ findMaximumHeight(c) ;
			System.out.println(ht);
			if(max < ht) {
				max =ht;
			}
		}
		return max ;
		
		/* other solution that works as well si
		 * 
		 * if(root == null ) return 0;
		    int max = 0;
		//if(root.children == null) return 1;
		for(Node c: root.children) {
			System.out.println(c.val + "," +max);
			int ht =  findMaximumHeight(c) ;
			System.out.println(ht);
			if(max < ht) {
				max =ht;
			}
		}
		return max+1 ;
		 * */
		 
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1);
		root.children.add(new Node(2));
		root.children.add(new Node(3));
		root.children.add(new Node(4));
		root.children.get(0).children.add(new Node(5));
		root.children.get(1).children.add(new Node(6));
		root.children.get(0).children.get(0).children.add(new Node(9));
		root.children.get(1).children.add(new Node(7));
		System.out.println(findMaximumHeight(root));

	}
   
}
