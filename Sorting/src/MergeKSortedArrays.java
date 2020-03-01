import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given K arrays sorted of length 'n' merge all K arrays to one array.
 */
public class MergeKSortedArrays {

	public MergeKSortedArrays() {
		// TODO Auto-generated constructor stub
	}
	
    public class Node{
    	int val;
    	int r;
    	int c;
    	public Node(int v,int row,int col) {
    		val =v;
    		r = row;
    		c = col;
    	}
    }
    public int[] mergeArrays(int[][] arr) {
    	boolean order = checkOrder(arr);
    	int[] result = new int[arr.length * arr[0].length];
    	PriorityQueue<Node> pq = null;
    	if(order) 
    		pq = new PriorityQueue<Node>((x, y) -> x.val - y.val);
    	else
    		pq = new PriorityQueue<Node>((x, y) -> y.val - x.val); //or new PriorityQueue<>(arr.length, Collections.reverseOrder());
    	for(int i =0;i<arr.length;i++) {
    		pq.add(new Node(arr[i][0],i,0));
    	}
    	int k = 0;
    	while(!pq.isEmpty()) {
    		Node node = pq.poll();
    		int x = node.r;
    		int y = node.c;
    		result[k++] = node.val;
    		if(y < arr[0].length-1)
    		 pq.add(new Node(arr[x][y+1],x,y+1));
    		
    	}
    	return result;
    }
    
    boolean checkOrder(int[][] arr) {
    	int i =0;
    	while(i < arr.length) {
    		if(arr[i][0] < arr[i][1])
    			return true;
    		i++;
    	}
    	return false;
    	
    	/*for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] < arr[i][arr[i].length - 1]) {
                isIncreasing = true;
            }
            if (arr[i][0] > arr[i][arr[i].length - 1]) {
                isDecreasing = true;
            }
        }*/
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKSortedArrays merge = new MergeKSortedArrays();
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		//int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		int[][] arr = new int[][]{ arr1, arr2, arr3 };
		int[] result = merge.mergeArrays(arr);
		System.out.println(Arrays.toString(result));
	}

}
