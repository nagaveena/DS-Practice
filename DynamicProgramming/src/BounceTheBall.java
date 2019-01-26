
public class BounceTheBall {
	int count =0;
	public int recursionBounce(int n, int bounce) {
		if(n == 0) return 1;
		if(n <0) return 0;
		for(int i = bounce;i<=n ;i++)
			count += recursionBounce(n-i,bounce+1);
		return count;
	}
	public int DPBounce(int n) {
		int[][] dp = new int[n+1][n+1];
		for(int k = 1;k <= n ;k++ ) {
			dp[k][1] = 1;
			//System.out.println(dp[k][0]);
		}
		for(int i=1; i<=n;i++) {
			for(int j =i;j<=n;j++) {
				dp[i][j] += dp[i-1][j-1];
				System.out.println(dp[i][j]);
			}
		}
		return dp[n][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BounceTheBall bounce = new BounceTheBall();
		System.out.println(bounce.recursionBounce(4, 1));
		System.out.println(bounce.DPBounce(4));
	}

}
