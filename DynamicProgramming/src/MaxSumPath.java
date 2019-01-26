
public class MaxSumPath {
	
	public static int findMaxSum(int[][] grid,int r,int c) {
		int n = grid.length;
		int m = grid[0].length;
		
		if(r == n || c == m) 
			return 0;
		if(r == n-1 && c == m-1)
			return grid[r][c];
		
		int right = grid[r][c]+findMaxSum(grid,r,c+1);
		int down = grid[r][c] + findMaxSum(grid,r+1,c);
		
		return Math.max(right, down);
		/*
		 * OR this code also will work
		 * int right = findMaxSum(grid,r,c+1);
		   int down =  findMaxSum(grid,r+1,c);
		
		  return  grid[r][c]+Math.max(right, down);
		 */
	}
	public static int findMaxSumDP(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int [][]dp = new int[m+1][n+1];
		dp[0][0] =grid[0][0];
		for(int i =1 ; i <= m;i++) {
			for(int j =1 ; j<= n;j++) {
				dp[i][j] = grid[i-1][j-1] + Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,3} , {4,5,6} , {7,8,9},{2,4,6}};
		int n = grid.length;
		int m = grid[0].length;
		System.out.println("m"+ m);
     int result =  findMaxSum(grid,0,0);
     
      System.out.println("Result:"+ result);
      System.out.println("DP Result:"+findMaxSumDP(grid));
    }
}
