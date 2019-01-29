import java.util.*;
public class Trie {
	
	public class TrieNode{
		
		Map<Character,TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}
   public TrieNode root;
   
   public Trie() {
	   root = new TrieNode();
   }
   
   public void insertWord(String word) {
	   TrieNode current = root;
	   for(int i =0 ; i <word.length();i++) {
		   char ch = word.charAt(i);
		   TrieNode node = root.children.get(ch);
		   if(node ==  null)
		   {
			   node =  new TrieNode();
			   node.children.put(ch,node);
		   }
		   current = node;
	   }
	   current.endOfWord = true;
   }
   
   public void searchRecursive(String word) {
	   searchWordRecursive(word,root,0);
   }
   
   public void insertWordRecursive(String word,TrieNode root, int indx) {
	   if(indx == word.length())
		   return;
	   TrieNode node = root.children.get(word.charAt(indx));
	   if(node == null) {
		   node = new TrieNode();
		   node.children.put(word.charAt(indx), node);
	   }
	   insertWordRecursive(word,node,indx+1);
   }
   
   public boolean searchWordRecursive(String word,TrieNode current, int indx) {
	   if(indx == word.length())
		   return current.endOfWord;
	   
	   TrieNode node =current.children.get(word.charAt(indx));
	   
	   if(node == null)
		   return false;
	   
	  return  searchWordRecursive(word,node,indx+1);
	   
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
