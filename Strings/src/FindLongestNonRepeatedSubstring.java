import java.util.*;
public class FindLongestNonRepeatedSubstring {

	
	public int findLongestNonrepeatedSubstring(String in) {
		
		Set<Character> set = new HashSet<Character>();
		int maxLen  = 0;
		int start = 0;
		for(int i=0;i < in.length();i++) {
			System.out.println("char:"+in.charAt(i));
			if(!set.contains(in.charAt(i))) {
				set.add(in.charAt(i));
				if(maxLen < set.size())
				   maxLen = set.size();
				
				
			}else {
				while(in.charAt(start) != in.charAt(i)) {
					set.remove(in.charAt(start));
					start++;
					//System.out.println("set:"+ set);
				}
				start++;
				//set.remove(in.charAt(start++));
				//System.out.println("2.set:"+ set);
			}
			System.out.println("2.set:"+ set);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ABCDECAMNCZB";
		String s1 = "ABCCBADEFGH";
		
		FindLongestNonRepeatedSubstring find = new FindLongestNonRepeatedSubstring();
		System.out.println(find.findLongestNonrepeatedSubstring(s));
		

	}

}
