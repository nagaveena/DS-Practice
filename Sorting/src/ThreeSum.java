/*
 * Sample Input 1:

    arr = [10, 3, -4, 1, -6, 9];
    
    Sample Output 1:
     10,-4,-6
     3,-4,1
 */
import java.util.*;
public class ThreeSum {
	
	static String[] findZeroSum(int[] nums) {
        // Write your code here.
        List<String> results = new ArrayList<String>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++){
            
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int L = i+1;
            int R = nums.length-1;
            
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                
                if(sum == 0){
                    String s = nums[i] + ","+nums[L] +","+nums[R];
                    results.add(s);
                    L++;
                    R--;
                    while(L< R && nums[L] == nums[L-1]){
                        L++;
                    }
                    
                    while(L < R && nums[R] == nums[R+1]){
                        R--;
                    }
                    
                }else if(sum < 0){
                    L++;
                }else{
                    R--;
                }
            }
        }

        String [] triplets = new String[results.size()];
        
        for(int i = 0 ; i< triplets.length ; i++){
        	triplets[i] = results.get(i);
        }
        return triplets;
    }
        

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
