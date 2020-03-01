import java.util.*;
public class StringTransformation {
	public class Vertex{
		String word;
		//List<String> neighbors;
		int dist;
		public Vertex(String w) {
			word = w;
			dist = 0;
		}
	}
	
	public void transformTheWord(String start, String target, String[] words) {
		Set<String> set = new HashSet<String>();
		for (String word : words)
			set.add(word);
		System.out.println("Set:" + set);
		Queue<Vertex> q = new ArrayDeque<Vertex>();
		//Vertex object needed only if Distance is asked to be returned OR else we can just keep words
		q.add(new Vertex(start)); 
		set.remove(start);//So we don't go back to this word
		List<String> path = null;
	
		path = bfs(q, start, target, set);
	
		System.out.println("Path:" + path);

		// return null;
	}

	public List<String> bfs(Queue<Vertex> q, String start, String target, Set<String> words)
	{

		List<String> path = new ArrayList<String>();
		// path.add(start);
		while (!q.isEmpty()) {
			Vertex curr = q.poll();
			if(!path.contains(curr.word))
			    path.add(curr.word);
		//	System.out.println("curr:" + curr.word);
			Iterator it = words.iterator();
			
			while (it.hasNext()) {
				String w = (String) it.next();
				 System.out.println("1.w:"+ w);
				if (isAdjacent(curr.word, w)) 
				{
					 System.out.println("w:"+ w);
					curr.word = w;
					curr.dist = curr.dist + 1;
					q.add(curr);
					path.add(curr.word);
				//	it.remove();// (curr.word);//.remove(curr.word);
					if (w == target) return path;
					
				}
			}
		}
		//System.out.println()
		return path;
	}

	public boolean isAdjacent(String curr, String neighbor) {
		int cnt = 0;
		for (int i = 0; i < curr.length(); i++) {
			if (curr.charAt(i) != neighbor.charAt(i)) {
				cnt++;
			if (cnt == 2)
			   return false;
			}

		}
		return (cnt == 1 ? true:false);
		
	}
	public List<String> findNeighbors(String curr,String[]words){
		List<String> adjacent =  new ArrayList<String>();
		for(String w: words) {
			
				int cnt = 0;
				for(int i = 0 ;  i < w.length();i++) {
					if(w.charAt(i) != curr.charAt(i)) {
						cnt++;
						if(cnt == 2) break;//return null;
					}
					
				}
				if(cnt == 1)
				  adjacent.add(w);
			
		}
		System.out.println("adjacent:" + adjacent);
		return adjacent;
	}
	
	public int length2(String begin, String end, Set<String> wordsDict) {
	    Queue<String> curLevel = new LinkedList<>();
	    Queue<String> nextLevel = new LinkedList<>();
	    curLevel.add(begin);
	 
	    wordsDict.add(end);
	 
	    String curWord;
	    int level = 1;
	 
	    while(!curLevel.isEmpty()){
	        level++;
	        while(!curLevel.isEmpty()) {
	            curWord = curLevel.poll();
	 
	            char[] arr = curWord.toCharArray();
	            for(int i=0; i< arr.length; i++){
	                for(char c='a'; c<='z'; c++){
	                    char temp = arr[i];
	                    if(arr[i]!=c){
	                        arr[i]=c;
	                    }
	 
	                    String newWord = new String(arr);
	 
	                    if(newWord.equals(end)){
	                        return level;
	                    }
	                    if(wordsDict.contains(newWord)){
	                        nextLevel.add(newWord);
	                        wordsDict.remove(newWord);
	                    }
	 
	                    arr[i]=temp;
	                }
	            }
	        }
	        curLevel = nextLevel;
	        nextLevel = new LinkedList<>();
	 
	    }
	 
	    return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] input = {"cat","bad", "had", "hat", "cat"};
		String[] input = { "bin","hat", "bad","cat", "had"};
		String[] input2 = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
		String[] i3= { "hot","dot","dog","lot","log","cog"};
      //  start = TOON
      //  target = PLEA
		StringTransformation st = new StringTransformation();
		 //st.transformTheWord("bat","had",input);
		// st.transformTheWord("TOON","PLEA",input2);
		 st.transformTheWord("hit","cog",i3);
		

		//System.out.println("output" + out);

		
	}

}
