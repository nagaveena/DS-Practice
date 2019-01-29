import java.util.*;
public class ShortestSubString {
	
	public int findShortestSubString(String in, String sub) {
		Map<Character,Integer> map  = new HashMap<Character,Integer>();
		
		for(char c : sub.toCharArray())
			map.put(c, 0);
		int missing  = map.size();
		int left = 0,right = in.length() ,start =0 ,end = 0;
		
		while((start != end && missing == 0 ) || end < in.length()) {
			if(missing != 0 ) { //expanding
				if(map.containsKey(in.charAt(end))){
					int count = map.get(in.charAt(end));
					map.put(in.charAt(end),count+1);
					if(count == 0)
						missing--;
				}
				end++;
			}
			else if(missing == 0) { //shrinking
				if((right-left) > (end-start)) {
					right = end;
					left = start;
				}
					if(map.containsKey(in.charAt(start))) {
						int count = map.get(in.charAt(start));
						if(count == 1 ) 
							missing++;
					    map.put(in.charAt(start), count-1);
						
					}
					start++;
				}
			}
		System.out.println("left:"+ in.charAt(left)+" right:"+in.charAt(right-1) );
		
		  return (right-left);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "helloworld";
		String s2 = "lrw";
		
		String s = "ABAACBAB"; 
		String  T = "ABC";
		ShortestSubString sub =  new ShortestSubString();
		System.out.println(sub.findShortestSubString(s1,s2));
	}

}
