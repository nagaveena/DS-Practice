

/*Given point x , point y and K neighbors , array of x,y points find K many neighbors close to y-x
 * Reference https://www.geeksforgeeks.org/k-nearest-neighbours/
 */
import java.util.*;
public class FindNearestNeighbor {
	
	public class Node{
		int r;
		int c;
		int dist;
		
		public Node(int r,int c) {
			this.r =r;
			this.c =c;
			dist = c ;//Math.sqrt((double)(c-r)*(c-r));
		}
	}
	public  List<Integer> find_nearest_neighbours(int px, int py, int[][] n_points, int k) {
		PriorityQueue<Node> pq 
		     = new PriorityQueue<Node>(k,((x, y) -> y.dist - x.dist)); //If Y-X -->MaxHeap;X-Y->MinHeap
		int given = px-py;
		for(int i =0;i<k;i++) 
		{
			System.out.println("dist:"+ n_points[i][1]);
			pq.add((new Node(i,n_points[i][1])));
			
		}
		
		int j  = k;
		while(!pq.isEmpty() && j < n_points.length) {
			Node n =  pq.peek();
			System.out.println(n.dist +"," + given);
			if(Math.abs(given-n.dist) > Math.abs(given-n_points[j][1])) {
				pq.poll();
				pq.add(new Node(j,n_points[j][1]));
			}
				j++;
			
		}
		List<Integer> list = new ArrayList<Integer>();
		while(!pq.isEmpty()) {
			list.add(pq.poll().dist);
		}
	return list;
	}
	
     public static Comparator<Node> idComparator = new Comparator<Node>(){
		
		@Override
		public int compare(Node c1, Node c2) {
            return (int) (c1.dist - c2.dist);
        }
	};
	
	/*public int compareTo(Employee employee) {
        if(this.getSalary() > employee.getSalary()) {
            return 1;
        } else if (this.getSalary() < employee.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] n_pnts = {{0,4},{1,13}, {2,2},{3,17}, {4,5},{5,3}, {6,6}};
				          
		FindNearestNeighbor find = new FindNearestNeighbor();
		List l = find.find_nearest_neighbours(6, 3, n_pnts, 4);
		System.out.println(l);
	                 
		}

}


