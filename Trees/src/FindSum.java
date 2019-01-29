import java.util.ArrayList;

/*
 * 
* Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer
*  and each internal node is one ofadd sub,multiply divide signs

*Given the root to such a tree, write a function to evaluate it.

*For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5
*You should return 45, as it is (3 + 2) * (4 + 5).
 * 
 */



public  class FindSum{

	public static class Node{
		String val;
		Node left;
		Node right;
		
		public Node(String v) {
			this.val = v;
		}
	}
	public FindSum() {
		
	}
	public static String evaluateTree(Node root){
		
		if (root == null )
			return null;
		if(root.left == null || root.right == null)
			return (root.val);
		String result = "";
		// String left =  evaluateTree(root.left);
		// char left = root.val;
		 //System.out.println("left:" + left);
		// String right = evaluateTree(root.right);
		
		//char right = root.val;
		//System.out.println("right:" + right);
		result +=  evaluateTree(root.left)+(root.val)+evaluateTree(root.right);
		
		System.out.println("result:" + result);
		
		
return result;

	}
	
	public static void convertExpr(String result) {
		//List<Character> eval = new ArrayList<Character>('+','-','*','/');
		System.out.println("result:" + result);
		int out =0;
		for(int i =0; i< result.length();i++) {
			int num =0;//(int)result.charAt(i);
			if(result.charAt(i) != '+' | result.charAt(i) != '-'|result.charAt(i) != '*'|result.charAt(i) != '/')
			{
				num = (int)result.charAt(i);
			}
			System.out.println("num:" + num);
			out += num;
			System.out.println("out:" + out);
		}
		System.out.println("out:" + out);
	}
	
	
	public static void main(String[] args)
    {
		//Node root = new Node();
		FindSum find = new FindSum();
        /*create root*/
        Node root = new Node("*");
 
     
 
        root.left = new Node("+");
        root.right = new Node("+");
 
        
 
 
        root.left.left = new Node("3");
        root.left.right = new Node("2");
        root.right.left = new Node("4");
        root.right.right = new Node("5");
      
       String result= find.evaluateTree(root);
       find.convertExpr(result);
    }
}
