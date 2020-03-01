/*
 * You are given Directed Graph G. You need to find out whether at least one cycle exist in the graph or not.
 * 
 * Sample Input:
 * N = 5, M = 7, edges = [[0,1],[0,3],[1,3],[1,2],[2,3],[4,0],[2,4]]
 * Sample Output:
 * true
 */
import java.util.*;
public class DetectCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//N-> Number of vertices, M-> Numb of Edges
	public static boolean hasCycle(int N, int M, List<List<Integer>> edges) {
        // Write your code here
        Set<Integer> visiteds = new HashSet<>(N);
        Set<Integer> stack = new HashSet<>();
        Map<Integer, Set<Integer>> graph = buildGraph(N, edges);
        for (int nodeId = 0; nodeId < N; nodeId++) {
            if (hasCycle(graph, nodeId, visiteds, stack)) {
                return true;
            }
        }

        return false;
    }
	
	private static Map<Integer, Set<Integer>> buildGraph(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> ret = new HashMap<>(n);

        for (List<Integer> edge : edges) {
            Set<Integer> neighbors = ret.get(edge.get(0));
            if (neighbors == null) {
                neighbors = new HashSet<>();
                ret.put(edge.get(0), neighbors);
            }

            neighbors.add(edge.get(1));
        }

        return ret;
    }

    private static boolean hasCycle(Map<Integer, Set<Integer>> graph, int nodeId, Set<Integer> visiteds,
                                      Set<Integer> stack)
    {
        if (stack.contains(nodeId)) {
            return true;
        }

        if (visiteds.contains(nodeId)) {
            return false;
        }

        if (!graph.containsKey(nodeId)) {
            return false;
        }

        stack.add(nodeId);
        visiteds.add(nodeId);

        for (Integer neighborId : graph.get(nodeId)) {
            if (hasCycle(graph, neighborId, visiteds, stack)) {
                return true;
            }
        }
        stack.remove(nodeId);

        return false;
    }

    
}


