
public class CountWaysForNthStair {
	
	 static long countWaysToClimb(int[] steps, int n) {
	        
	       // return recurseNStairs(steps,n); -->Recursion way
	        return dpNStairs( steps, n);

	    }
	    static int recurseNStairs(int[] steps, int n){
	        if(n == 0 )return 1;
	        if(n < 0 ) return 0;
	        int result = 0;
	        for(int i =0 ;i < steps.length;i++){
	            result += recurseNStairs(steps,n-steps[i]);
	        }
	        return result;
	    }
	    
	   static long dpNStairs(int[] steps, int n){
	       long[] dp = new long[n+1];
	       dp[0] = 1;
	       //dp[1] =1;
	       for(int i = 1;i <=n ;i++){
	          dp[i] =0;
	         for(int j = 0;j<steps.length;j++){
	          if( i >= steps[j])
	            dp[i]+= dp[i-steps[j]];
	          }
	          //System.out.println("i:"+i + ":" +dp[i]);
	       }
	      return dp[n];  
	   }
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] steps = {2,3,5};
System.out.println(dpNStairs(steps,7));
System.out.println(recurseNStairs(steps,7));
	}

}
