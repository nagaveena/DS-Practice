//Given a matrix that is filled with ‘O’, ‘G’, and ‘W’ 
//where ‘O’ represents open space, ‘G’ represents guards 
//and ‘W’ represents walls in a Bank. Replace all of the O’s in the matrix with 
//their shortest distance from a guard, without being able to go through any walls. 
//Also, replace the guards with 0 and walls with -1 in output matrix.
//
//Expected Time complexity is O(MN) for a M x N matrix.
//
//Examples:
//
//O ==> Open Space
//G ==> Guard
//W ==> Wall
//
//Input: 
//  O  O  O  O  G
//  O  W  W  O  O
//  O  O  O  W  O
//  G  W  W  W  O
//  O  O  O  O  G
//
//Output:  
//  3  3  2  1  0
//  2 -1 -1  2  1
//  1  2  3 -1  2
//  0 -1 -1 -1  1
//  1  2  2  1  0
import java.util.*;
public class ShortestDistFromTheGuard {
	
	public class Node {
		int r;
		int c;
		int dist;
		
		public Node(int r, int c) {
			this.r =r;
			this.c = c;
			dist =0;
		}
	}
	public int[][] findShortestDist(char[][] grid) 
	{
	  Queue<Node> q = new ArrayDeque<Node>();
	  int[][] output = new int[grid.length][grid[0].length];
	  //Adding all guard cells to queue
	  for(int i =0;i<grid.length;i++) {
		for(int j=0;j<grid[0].length;j++)
		{
			output[i][j] = -1;
		  if(grid[i][j] == 'G') {
			  q.add(new Node(i,j));
			  output[i][j] = 0;
			}
		 }
		}
		bfs(q,grid,output);
		return output;
	}
	public void bfs(Queue<Node> q,char[][] grid,int[][] output) {
		while(!q.isEmpty()) {
			Node curr = q.poll();
			for(Node next:findNeighbors(curr,grid,output)) {
				output[next.r][next.c] = curr.dist+1;
				next.dist = curr.dist+1;
				q.add(next);
				
			}
			
		}
	}
    public List<Node> findNeighbors(Node curr,char[][] grid,int[][] output)
    {
    	int[] rows = {-1,0,1, 0};
    	int[] cols=  { 0, 1,0,-1};
    	int r = curr.r;
    	int c = curr.c;
    //	System.out.println("r:"+ r + "c:" + c);
    	List<Node> list = new ArrayList<Node>();
    	for(int k =0 ;k <rows.length;k++) {
    		if(isValid(r+rows[k],c+cols[k],grid,output))
    			list.add(new Node(r+rows[k],c+cols[k]));
    			
    	}
    	return list;
	
    }
    public boolean isValid(int r, int c ,char[][] grid,int[][] output) {
    	if(r >= 0 && r<grid.length &&c >= 0 && c<grid[0].length
    	   && (grid[r][c] == 'O'	&& output[r][c] == -1))
    		return true;
     return false;	
    }
    public List<Node> findNeighbors1(Node curr,char[][] grid,int[][] output){
    	List<Node> list = new ArrayList<Node>();
    	for(Node next: Arrays.asList(new Node(curr.r+1,curr.c),new Node(curr.r-1,curr.c),
    			                     new Node(curr.r,curr.c+1),new Node(curr.r,curr.c-1)))
    	{
    		if(next.r >= 0 && next.r <grid.length  && next.c >= 0  && next.c < grid[0].length 
    				&& grid[next.r][next.c] == '0' && output[next.r][next.c] == -1)
    			list.add(new Node(next.r,next.c));
    			
    	}
    	return list;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char matrix[][] = 
		    { 
		        {'O', 'O', 'O', 'O', 'G'}, 
		        {'O', 'W', 'W', 'O', 'O'}, 
		        {'O', 'O', 'O', 'W', 'O'}, 
		        {'G', 'W', 'W', 'W', 'O'}, 
		        {'O', 'O', 'O', 'O', 'G'} 
		    }; 
		ShortestDistFromTheGuard shortest = new ShortestDistFromTheGuard();
		int[][] out=shortest.findShortestDist(matrix);
		for(int r =0; r < out.length;r++) {
			for(int c =0; c < out[0].length;c++)
				System.out.print(out[r][c]+" ");
			System.out.println();
		}
	}

}
