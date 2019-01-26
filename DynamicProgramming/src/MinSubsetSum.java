
public class MinSubsetSum {
	public int min = Integer.MAX_VALUE;
	public int findMinSubSetRecurse(int [] arr,int indx,int sum,int total) {
		if(indx==arr.length) {
			System.out.println("sum:"+ sum);
			return Math.abs((total-sum)-sum);
		}
		int with = findMinSubSetRecurse(arr,indx+1,sum+arr[indx],total);
		System.out.println("with:"+ with);
		int without = findMinSubSetRecurse(arr,indx+1,sum,total);
		System.out.println("without:"+ without + "diff:" + Math.abs(with-without));
		// min =  Math.min(min, Math.abs(with-without));
		 return Math.min(with, without); //min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      MinSubsetSum minSum = new MinSubsetSum();
      int arr[] = {3, 1, 4, 2, 2, 1};//{1, 6, 11, 5};
      int total =0;
      for(int i =0;i <arr.length;i++)
    	  total += arr[i];
    	  
      System.out.println(minSum.findMinSubSetRecurse(arr, 0, 0,total));
	}

}
