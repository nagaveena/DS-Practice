import java.util.*;
public class CourseOrderingDFS {
	
	public class Vertex{
		String name;
		List<Vertex> neighbors;
		public Vertex(String courseName) {
			name = courseName;
		}
	}
	public void topologicalSort(Vertex g) {
		Set<Vertex> visited = new HashSet<Vertex>();
		Stack<Vertex> stack =  new Stack<Vertex>();
		stack.push(g);
		//visited.add(g);
		topSortedUtil(g,visited,stack);
	}
    public void topSortedUtil(Vertex g,Set<Vertex>visited,Stack<Vertex>stack) {
    	visited.add(g);
    	for(Vertex v : g.neighbors) {
    		if(!visited.contains(v)) {
    			topSortedUtil(v,visited,stack);
    		}
    	}
    	stack.push(g);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
