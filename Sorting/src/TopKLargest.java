import java.util.*;
public class TopKLargest {

	public TopKLargest() {
		// TODO Auto-generated constructor stub
	}
    void printTopKLargest(int[] input , int k, int code) {
    	
    	//heapify(input);
    	//
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
    	
    	for(int i : input) {
    		if(i == code) {
    			System.out.println("Top K Largest elements:");
    			while(!pq.isEmpty())
    				System.out.println(pq.stream());
    		}
    		if(pq.size() > k) {
    			if(pq.peek() < i)
    				pq.poll();
    		}
    		if(!pq.contains(i) && pq.size()< k)
    			pq.add(i);
    	}
    	
    }
    public void findKLargestElements(List<Integer> list,int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)-> x-y);
    	for(int i : list) {
    		pq.add(i);
    		if(pq.size()>k)
    			pq.remove();
    	}
    	System.out.println("ihere:"+ pq.peek());
    	while(!pq.isEmpty()) {
    		System.out.println("i:"+ pq.poll());
    	}
    }
    
    void heapify(int[] a) {
    	int min = 0;
    	
    	int left = 0 ,right =0;
    	for(int i =0 ;i <a.length;i++){
    		left = 2*i+1;
    		right = 2*i+2;
    		if(a[min] > a[left])
    			min  =left;
    		if(a[min]>a[right] )
    			min =right;
    	}
    }
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		List<Integer> l = Arrays.asList(561,314,401,28,156,359,271,11,3);
		TopKLargest top = new TopKLargest();
		top.findKLargestElements(l,4);
	}

}
