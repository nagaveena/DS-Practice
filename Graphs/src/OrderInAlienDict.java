import java.util.*;

public class OrderInAlienDict {

	public static class Vertex {
		char letter;
		List<Vertex> neighbors;

		public Vertex(char c) {
			this.letter = c;
			neighbors = new ArrayList<Vertex>();
		}
	}

	// Map<Character,Vertex> vertices1 = new HashMap<Character,Vertex>();
	Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();

	public void find_order1(String[] words) {

		addEdges1(words);
		Stack<Character> stack = new Stack<Character>();
		Set<Character> visited = new HashSet<Character>();
		System.out.println("map:" + map);
		for (char c : map.keySet()) {
			if (!visited.contains(c))
				explore(c, stack, visited);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public void explore(char v, Stack<Character> s, Set<Character> visited) {
		visited.add(v);
		// System.out.println("v"+v);
		if (map.containsKey(v)) {
			for (char neighbor : map.get(v)) {
				if (!visited.contains(neighbor)) {
					explore(neighbor, s, visited);
				}
			}
		}
		s.push(v);
	}

	public void addEdges1(String[] words) {

		for (int i = 0; i < words.length; i++) {
			if (i != words.length - 1) {
				String curr = words[i];
				String next = words[i + 1];
				for (int j = 0; j < words[i].length(); j++) {
					if (curr.charAt(j) != next.charAt(j)) {
						createNode(curr.charAt(j), next.charAt(j));
						// Vertex curr = createNode(words[i].charAt(j));
						// Vertex adj = createNode(words[i+1].charAt(j));
						// curr.neighbors.add(adj);
						break;
					}
				}
			}
		}
	}

	public void createNode(char curr, char next) {

		List<Character> list = map.get(curr);
		if (list == null)
			list = new ArrayList<Character>();
		list.add(next);
		map.put(curr, list);

	}

	/*
	 * This is IK submission which worked
	 */
	/*
	 * static List<Vertex> vertices = new ArrayList<Vertex>(); static String
	 * find_order(String[] words) {
	 * 
	 * Set<Character> dict = new HashSet<Character>(); for(String word : words){
	 * for(int i = 0 ;i<word.length();i++){ dict.add(word.charAt(i)); } } //creating
	 * graph nodes createNodes(dict);
	 * 
	 * //create edges addEdges(words);
	 * 
	 * //topological order int num = vertices.size(); Set<Character> visited = new
	 * HashSet<Character>(); // Stack<Integer> stack = newStack<Integer>();
	 * Stack<Vertex> stack = new Stack<Vertex>(); for(Vertex v : vertices){
	 * 
	 * if(! visited.contains(v.letter)){ explore(v,visited,stack); } } String out=""
	 * ; while(!stack.isEmpty()){ out += (stack.pop()).letter; }
	 * System.out.println("out:" + out); return out; }
	 * 
	 * 
	 * static void createNodes(Set<Character> dict){
	 * 
	 * for(char c :dict){ Vertex v = new Vertex(c); vertices.add(v); } //for(Vertex
	 * v: vertices) // printGraph( v); } static Vertex getVertexFromList(char l){
	 * for(Vertex vertex: vertices) { if(vertex.letter == l) return vertex; } return
	 * null; }
	 * 
	 * static void addEdges(String[] words){ for(int j = 0 ;j<words.length;j++){
	 * if(j != words.length-1){ for(int i = 0 ; i< words[j].length() ;i++){ char
	 * word1 = (words[j]).charAt(i); char word2 = (words[j+1]).charAt(i); if(word1
	 * != word2) {
	 * 
	 * Vertex current =null; Vertex adjacent =null; current
	 * =getVertexFromList(word1); adjacent = getVertexFromList(word2); if(current
	 * !=null && adjacent != null){ //System.out.println("current"); //
	 * printGraph(current); current.neighbors.add(adjacent);
	 * 
	 * //System.out.println("adjacent"); // printGraph(adjacent); }
	 * 
	 * break; } } } }
	 * 
	 * } static void explore(Vertex v,Set<Character> visited,Stack<Vertex> stack){
	 * visited.add(v.letter); System.out.println("2.v,letter:"+v.letter); for(Vertex
	 * curr:v.neighbors){ if(! visited.contains(curr.letter)){
	 * explore(curr,visited,stack); }
	 * 
	 * } stack.push(v);
	 * 
	 * }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "baa", "abcd", "abca", "cab", "cad" };
		OrderInAlienDict order = new OrderInAlienDict();
		order.find_order1(words);
		// find_order(words);
	}

}
