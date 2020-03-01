
public class KthRank {
	
	/*
	 * Given an array of integers find an element of Rank k(kth smallest element)
	 * */
	public KthRank() {
		
	}
    int findRank(int[] arr, int k ,int st,int en) {
    	
    	int pi = partition(arr,st,en);
    	//System.out.println("pik:"+ pi +"val:"+ arr[pi]); 
    	if(pi == k ) return pi ;// arr[k-1];
    	
    	if(pi > k )
    		findRank(arr,k,st,pi-1);
    	else
    		findRank(arr,k,pi+1,en);
    	
    	printArray(arr);
    	return arr[k-1];
    }
    int partition(int[]arr,int st,int en) {
    	int pivot = arr[en];
    	int j= st-1;
    	for(int i=st;i<en;i++) {
    		if(arr[i] <= pivot) {
    			j++;
    			int temp = arr[j];
    			arr[j] =arr[i];
    			arr[i] =temp;
    		}
    	}
    	int temp = arr[j+1];
    	arr[j+1] = arr[en];
    	arr[en] = temp;
    	
    	return j+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        KthRank ob = new KthRank(); 
       int rank =  ob.findRank(arr,3, 0, n-1);
       System.out.println("Rank:"+ rank); 
       
	}
	 static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 

}
