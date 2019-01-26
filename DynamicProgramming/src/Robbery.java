
public class Robbery {
	
	static int maxStolenValue(int[] values) {
	      if(values.length == 0) return 0;
	    //  return recurseMaxStolenValue(values,0);
	      return dpMaxStolenValue(values,0);
	    }

	    static int recurseMaxStolenValue(int[] values,int i){
	        /*
	        *Approach #1 for Recursion
	        */
	        if(i >= values.length) return  0;
	        if(i == values.length -1) return values[values.length-1];
	        
	        return Math.max( values[i] + recurseMaxStolenValue(values,i+2)
	                        ,values[i+1] + recurseMaxStolenValue(values,i+3)
	                        );
	       /*
	       *Approach #2 for Recursion  --> This approach won't work to convert to DP,but recursion yields right result
	       */
	       
	       /*
	       if(i >= values.length) return  0;    
	       int  result1 = values[i]+recurseMaxStolenValue(values,i+2);
	       int result2 = recurseMaxStolenValue(values,i+1);
	       return (Math.max(result1,result2));
	       */
	    
	    }
	    
	 static  public int rob_easyVersion(int[] nums) {
	        if(nums.length == 0) {
	            return 0;
	        }

	        if(nums.length == 1) {
	            return nums[0];
	        }
	        
	        int[] dp = new int[nums.length];
	        
	        dp[0] = nums[0];
	        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
            System.out.println(dp.length);
	        for(int i = 2; i < nums.length; i++) {
	            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
	            System.out.println("i:"+i);
	            System.out.println("dp:"+dp[i]);
	        }
	        
	        return dp[dp.length - 1];
	    }
	    static int dpMaxStolenValue(int[] values,int j){
	        int len = values.length;
	        int [] dp = new int[len+1];
	        dp[len] =values[len-1];
	        
	       dp[len-1] = Math.max(values[len-1],values[len-2]);
	       dp[len-2] = Math.max(dp[len-1],values[len-3]);
	        //int result = dp[len-1];
	        //System.out.println("dp:"+dp[len-2]);
	        for(int i = len-3 ;i >= 0;i--){
	            dp[i] = Math.max(values[i]+dp[i+2],values[i+1]+dp[i+3]);
	            //System.out.println("dp:"+dp[i]);
	        }
	        
	        return dp[0];
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int v [] = {6,1,2,7};
     System.out.println( rob_easyVersion(v));
	}

}
