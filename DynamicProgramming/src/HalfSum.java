import java.util.*;
public class HalfSum {
	
	static void balanced_partition(int[] arr) {
	    int sum =   computeSum(arr);
	 //  System.out.println("sum:"+sum);
	  //  System.out.println("Halfsum:"+sum/2);
	    List<Integer> list1 = new ArrayList<Integer>();
	    List<Integer> list2 = new ArrayList<Integer>();
	    boolean result = findHalfSum(arr,sum/2,0,list1,list2,0);
	  System.out.println("result:"+result);
	    //System.out.println("list1:"+ list1);
	  //  System.out.println("list2:"+ list2);
	}
	static boolean findHalfSum(int [] arr,int halfSum,int soFar,List<Integer> list1,List<Integer> list2,int indx) {
		//System.out.println("1.halfsum:"+halfSum);
		
		if (halfSum == soFar){
			//System.out.println("2.halfsum:"+halfSum +","+ soFar);
			return true;
	}
		if(indx == arr.length) 
			return false;
		boolean result2 = findHalfSum(arr,halfSum,soFar,list1,list2,indx+1);
		list2.add((int)arr[indx]);
		boolean result1 =false;
		
		    result1 = findHalfSum(arr,halfSum,soFar+arr[indx],list1,list2,indx+1);
		
		//System.out.println(result1 +","+ result2);
		return result1 || result2;	
		
		}
    static int computeSum(int []arr) {
    	int sum =0;
    	for(int i = 0 ; i<arr.length;i++) {
       		sum += arr[i];
    	}
    	return sum;
    }
    public static boolean dpApproach(int [] arr, int sum) {
    	boolean [][] dp = new boolean[arr.length+1][sum+1];
    	if (sum % 2 != 0) {
            return false;
        }
    	for(int i = 0 ;i <=arr.length ; i++)
    		dp[i][0] = true;
    	
    	for(int i =1 ; i <= arr.length;i++) {
    		for(int  j =1 ; j <= sum;j++ ) {
    			if(j-arr[i-1] >= 0) 
    				dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
    			//dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + price[i-1]);
    			else 
    				dp[i][j] = dp[i-1][j];
    		
    		}
    	}
    	return dp[arr.length][sum];
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  // int[] arr = new int[] {4, 1, -5, 6, -11,5};
   int arr[] = {1, 3, 5, 5, 2, 1, 1};
   balanced_partition(arr);
  System.out.println( dpApproach(arr,(computeSum(arr))/2));
//  System.out.println(findHalfSum)
	}

}
