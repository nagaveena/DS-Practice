import java.util.*;
public class CoinChange {
	
	static void makeChange(int C, int[] intDenominations) {
	     // recurseMakeChange(C,intDenominations);
	      dpMakeChange(C,intDenominations);

	    }
	  static int recurseMakeChange(int C, int[] val){
	      if(C == 0 ) return 0;
	      if(C < 0) return Integer.MAX_VALUE;
	      int res =Integer.MAX_VALUE;
	      List<Integer> list = new ArrayList<Integer>();
	      for(int j =0;j<val.length;j++)
	      {
	         int  result2 = recurseMakeChange(C-val[j],val);
	         if(result2 != Integer.MAX_VALUE){
	              res= Math.min(1+result2,res);
	         }
	    
	     }
	     System.out.println("res:"+ res);
	     return res;
	  }
	  
	  static int dpMakeChange(int C,int[] val){
	      int[] dp = new int[C+1];
	      for(int k=1;k<=C;k++){
	         dp[k] =Integer.MAX_VALUE;
	      }
	         
	      dp[0] = 0;
	      
	      for(int i = 0 ; i<val.length; i++){
	          for(int j = 1 ; j <=C ; j++){
	              if(val[i] <= j ){
	                  System.out.println("dp[i]:"+ dp[j]);
	                  if(dp[j-val[i]] < dp[j])
	                     dp[j] =dp[j-val[i]]+1;// Math.min(dp[j],dp[j-val[i]+1]);--> this is yielding MAX integers
	              }
	          }
	         // if(dp[i] !=Integer.MAX_VALUE )
	             //dp[i] = 1+dp[i];
	      }
	       System.out.println("res:"+ dp[C]);
	      return dp[C];
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 13;
        int coins[] = {7, 3, 2, 6};
        dpMakeChange(total,coins);
	}

}
