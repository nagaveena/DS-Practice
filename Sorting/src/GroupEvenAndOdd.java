/*
 * Sample Input:

    [1, 2, 3, 4]
Sample Output:
    [4, 2, 1, 3]
 */
public class GroupEvenAndOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		solve(arr);
		for(int i =0; i <arr.length;i++)
			System.out.println(arr[i]);

	}
	
	static int[] solve(int[] arr) {
        if(arr == null || arr.length<1) return arr;
        int oddStartIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2==0){
                swap(arr,i,oddStartIndex);
                oddStartIndex++;
            }
        }
        return arr;
    }
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
