import java.util.*;
public class TopKFrequentElements {
	
	 public List<Integer> topKFrequent(int[] nums, int k) {
	        
		   /*  Arrays.sort(nums);
		     int l =0,r=0;
		        List<Integer> list = new ArrayList<Integer>();
		      while(r<nums.length)  {
		          int cnt =0;
		        while(r <nums.length &&nums[l]==nums[r])  {
		            cnt++;
		            r++;
		        }
		          if(cnt >= k)
		              list.add(nums[l]);
		          l=r;
		          
		      }
		      return list; 
		      */
		        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		        List<Integer> list = new ArrayList<Integer>();
		        for(int i:nums)
		            map.put(i,map.getOrDefault(i,0)+1);
		        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2) ->map.get(n1)-map.get(n2));
		        
		        for(int key:map.keySet()){
		            pq.add(key);
		            if(pq.size()>k)
		                pq.poll();
		        }
		        while(!pq.isEmpty()){
		        	
		            list.add(pq.poll());
		        }
		        return list;
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int [] arr = {1,1,1,2,2,3};
     TopKFrequentElements topK= new TopKFrequentElements();
     List<Integer> l = topK.topKFrequent(arr,2);
     for(int i: l) {
    	 System.out.println(i);
     }
	}

}
