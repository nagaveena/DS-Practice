/*
 * Return island that has maximum land count.
 * for  below example return 5 as one island has 5 lands
 * 
 */
public class CountMaxIslands {
	static  int count =0;
	static int  max =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [][] grid = { {1,1,1,0,0}, 
		                   {1,1,0,0,0}, 
		                   {0,0,0,1,0},
		                   {1,0,0,1,0},
		                   {1,1,0,0,0}
		           };
		 
		 numIslands(grid);
    
	}
	
	static void   dfs(int[][] grid, int r, int c) {
	    int nr = grid.length;
	    int nc = grid[0].length;

	    if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
	      return;
	    }

	    grid[r][c] = 0;
	    count++;
	    dfs(grid, r - 1, c);
	    dfs(grid, r + 1, c);
	    dfs(grid, r, c - 1);
	    dfs(grid, r, c + 1);
	    System.out.println("here"+count);
	  }

	  public static  int numIslands(int[][] grid) {
	    if (grid == null || grid.length == 0) {
	      return 0;
	    }

	    int nr = grid.length;
	    int nc = grid[0].length;
	    int num_islands = 0;
	   
	    for (int r = 0; r < nr; ++r) {
	      for (int c = 0; c < nc; ++c) {
	        if (grid[r][c] == 1) {
	          ++num_islands;
	          count =0;
	          dfs(grid, r, c);
	          System.out.println(count);
	          max = Math.max(max, count);
	        }
	      }
	    }
	    System.out.println("max:" +max);
	    return num_islands;
	  }

}
