
public class KnapSack {
	
	public int knapSackRecursion(int[] wt,int[] price, int capacity, int indx) {
		if(indx == wt.length|| capacity ==0)
		return 0;
		
		if(capacity < wt[indx])
			return knapSackRecursion(wt,price,capacity,indx+1);//Integer.MIN_VALUE;
		
		int include = price[indx]+knapSackRecursion(wt,price,capacity-wt[indx],indx+1);
		int exclude = knapSackRecursion(wt,price,capacity,indx+1);
		return Math.max(include, exclude);
	}

	public int knapSackDP(int [] wt, int[] price,int W) {
		int[][] dp = new int[wt.length+1][W+1];
		/*for(int i = 0 ;i <wt.length;i++ ) {
			dp[i][0] =0;
		}
		for(int k=1;k<= wt.length;k++) {
			for(int j =1;j<capacity;j++) {
				if(k< wt[j])
				dp[j][k] = Math.max(dp[k-1][j],price[k]+dp[k-1][k-wt[j]]);
			}
		}*/
		
		
		for(int i=0; i <= wt.length; i++){
            for(int j=0; j <= W; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(j > wt[i-1] ){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + price[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
		
		return dp[wt.length][W];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int [] wt = {2,3,5,4};
      int [] price = {10,50,6,8};
      KnapSack ks = new KnapSack();
      System.out.println(ks.knapSackRecursion(wt, price, 6, 0));
      System.out.println(ks.knapSackDP(wt, price, 6));
      
	}

}
