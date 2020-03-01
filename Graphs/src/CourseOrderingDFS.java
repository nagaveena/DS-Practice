import java.util.*;
public class CourseOrderingDFS {
	
	public static class Vertex{
		String name;
		List<Vertex> neighbors;
		public Vertex(String courseName) {
			name = courseName;
			neighbors = new ArrayList<Vertex>();
		}
	}
	public void topologicalSort(List<Vertex> g) {
		Set<Vertex> visited = new HashSet<Vertex>();
		Stack<Vertex> stack =  new Stack<Vertex>();
		for(Vertex vertex: g) {
		   if(!visited.contains(vertex))
		      topSortedUtil(vertex,visited,stack);
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop().name + " ");
	}
    public void topSortedUtil(Vertex g,Set<Vertex>visited,Stack<Vertex>stack) {
    	
    	visited.add(g);
    	for(Vertex v : g.neighbors) {
    		if(!visited.contains(v)) {
    			topSortedUtil(v,visited,stack);
    		}
    	}
    	System.out.println("g:"+ g.name);
    	stack.push(g);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseOrderingDFS course = new CourseOrderingDFS();
		 Vertex v = new Vertex("A");
         Vertex v1 = new Vertex("B");
         Vertex v2 = new Vertex("C");
         Vertex v3 = new Vertex("D");
          v.neighbors.add(v1);
          v.neighbors.add(v2);
          v1.neighbors.add(v2);
          v1.neighbors.add(v3);
          v2.neighbors.add(v3);
          List<Vertex> g =  new ArrayList<Vertex>();
         
          g.add(v1);
          g.add(v2);
          g.add(v);
          g.add(v3);
          course. topologicalSort( g) ;
   
	}

}
