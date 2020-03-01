import java.util.*;
public class ChangeValuesInGrid {
	
	public static class  Node{
	      int row;
	      int col;
	      
	    public Node(int r, int c){
	      row= r;
	      col =c;
	    }
	    
	  }
	  public void changeValues(int[][] grid, int tot_row,int tot_col,int target,int target_row,int target_col){
	    
	    Queue<Node> q = new ArrayDeque<Node>();
	    
	    boolean[][] visited = new boolean[tot_row] [tot_col];
	    
	    q.add(new Node(target_row,target_col));
	    visited[target_row][target_col] = true;
	    
	    bfs(q,visited,grid,tot_row,tot_col,target);
	  }
	  
	  public void bfs(Queue<Node> q,boolean[][] visited,int[][] grid,int rows,int cols,int target){
	    while(!q.isEmpty()){
	      
	      Node n = q.poll();
	      int val = grid[n.row][n.col];
	      
	     grid[n.row][n.col] = target;
	      
	      for(Node neighbor: findNeighbors(grid,val,rows,cols,n.row,n.col)){
	        if(!visited[neighbor.row][neighbor.col] == true){
	          visited[neighbor.row][neighbor.col] =true;
	          q.add(neighbor);
	        }
	      }
	    }
	  }//end of method
	  
	  public List<Node> findNeighbors(int[][] grid,int val,int rows, int cols, int curr_r, int curr_c){
	    List<Node> neighbors =  new ArrayList<Node>();
	    
	    int[] n_rows = {1,-1,0,0, 1, 1, -1,-1};
	    int[] n_cols = {0, 0,1,-1,1,-1,-1, 1};
	    for(int k =0;k<8;k++){
	      if(isValid(grid,curr_r+n_rows[k],curr_c+n_cols[k],val)){
	        neighbors.add(new Node(curr_r+n_rows[k],curr_c+n_cols[k]));
	      }
	    }
	     return neighbors;
	  }
	                      
	   public boolean isValid( int[][] grid,int curr_r,int curr_c,int val){
	     return((curr_r > 0 && curr_r < grid.length) && (curr_c >0 && curr_c <grid[0].length) &&
	            (grid[curr_r][curr_c] == val));
	   }
	   
	   
	   public static void main(String[] args) {
		    ArrayList<String> strings = new ArrayList<String>();
		    strings.add("Hello, World!");
		    strings.add("Welcome to CoderPad.");
		    strings.add("This pad is running Java 8.");

		   /* for (String string : strings) {
		      System.out.println(string);
		    }*/
		    ChangeValuesInGrid soln = new ChangeValuesInGrid();
		    int[][] grid = {
		      {8, 8, 8, 7, 9, 9},
		      { 2, 1, 1, 1, 5, 3},
		      { 1, 8, 1, 6, 2, 1},
		      {1, 5, 1, 1, 2, 10},
		      { 5, 1, 1, 1, 1, 1}
		    };
		    //grid ,tot row,tot col, target value to be changed,target row, target col
		    //change the value of the given target cell with target value and 8 cells as its neigbors
		    //if value is match with what target cell has it then replace that cell as well with target value.
		    soln.changeValues(grid,5,6,8,1,2);
		    for(int i =0;i <grid.length;i++){
		      for(int j=0;j<grid[0].length;j++){
		        System.out.print(grid[i][j] + " ");
		      }
		      System.out.println();
		    }
		  }
}



