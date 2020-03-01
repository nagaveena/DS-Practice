import java.util.*;

public class CourseOrderingBFS {

	public static class Vertex {
		char name;
		ArrayList<Vertex> neighbors;

		public Vertex(char n) {
			name = n;
		}
	}
	
	//compute in degrees
	public static void bfsApproach(List<Edges> edges) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, List<Character>> neighborMap = new HashMap<Character, List<Character>>();
		List<Character> result = new ArrayList<Character>();
		computeInDegrees(map, edges);
		findNeighbors(edges, neighborMap);
		Queue<Vertex> que = new LinkedList<Vertex>();

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 0)
				que.add(new Vertex(entry.getKey()));
		}

		while (!que.isEmpty()) {
			Vertex v = que.poll();
			result.add(v.name);
			// for(Vertex adj:v.neighbors) {
			if (neighborMap.containsKey(v.name)) {
				for (Character c : neighborMap.get(v.name)) {

					int degree = map.get(c);// adj.name);
					degree = degree - 1;
					map.put(c, degree);
					if (degree == 0) {
						que.add(new Vertex(c));
						map.remove(c);
					}
				}
			}
		}
		//for (Character c : result) {
			System.out.println("Result:" + result);
		//}

	}

	public static void computeInDegrees(Map<Character, Integer> map, List<Edges> edges) {
		// Map<Character,Integer> map = new HashMap<Character,Integer>();
		for (Edges e : edges) {
			if (!map.containsKey(e.start))
				map.put(e.start, 0);
			if (map.containsKey(e.end)) {
				int cnt = map.get(e.end);
				map.put(e.end, cnt + 1);
			} else {
				map.put(e.end, 1);
			}
			
		}
		System.out.println("map:" + map);
	}

	public static void findNeighbors(List<Edges> edges, Map<Character, List<Character>> neighborMap) {
		for (Edges e : edges) {
			if (neighborMap.containsKey(e.start)) {
				List<Character> list = neighborMap.get(e.start);
				list.add(e.end);
			} else {
				List<Character> list = new ArrayList<>();
				list.add(e.end);
				neighborMap.put(e.start, list);
			}
		}
		System.out.println(neighborMap);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edges e1 = new Edges('A', 'B');
		Edges e2 = new Edges('A', 'C');
		Edges e3 = new Edges('B', 'C');
		Edges e4 = new Edges('B', 'D');
		Edges e5 = new Edges('C', 'D');

		List<Edges> l = new ArrayList<Edges>();
		l.add(e1);
		l.add(e2);
		l.add(e3);
		l.add(e4);
		l.add(e5);
		CourseOrderingBFS.bfsApproach(l);
	}

	public static class Edges {
		char start;
		char end;

		public Edges(char s, char e) {
			start = s;
			end = e;
		}
	}
}
