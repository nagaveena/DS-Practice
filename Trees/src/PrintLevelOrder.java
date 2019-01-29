
import java.util.*;


public class PrintLevelOrder {
	public class BinaryTree{
		int data;
		BinaryTree left;
		BinaryTree right;
		public BinaryTree(int val) {
			data = val;
		}
	}
	void printLevelOrder1(BinaryTree root) {
		  if (root == null) return;
		  Queue<BinaryTree> currentLevel =  new LinkedList<BinaryTree>(); 
		  Queue<BinaryTree> nextLevel =new LinkedList<BinaryTree>();  ;
		  currentLevel.add(root);
		  while (!currentLevel.isEmpty()) {
		     //currentLevel.front();
		     BinaryTree currNode =  currentLevel.remove();
		    if (currNode != null) {
		      System.out.println( currNode.data );
		      nextLevel.add(currNode.left);
		      nextLevel.add(currNode.right);
		    }
		    if (currentLevel.isEmpty()) {
		      //cout << endl;
		      //swap(currentLevel, nextLevel);
		    }
		  }
		}
public void swap(BinaryTree curr,BinaryTree next) {
	BinaryTree temp = curr;
	curr = next;
	next = temp;
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
