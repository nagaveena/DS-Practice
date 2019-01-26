/*
 * Given a phone keypad as shown below:

1 2 3
4 5 6
7 8 9
  0
 * Sample Input-1:

startdigit = 1
phonenumberlength = 2

Sample Output-1:
2
Explanation-1:
Two possible numbers of length 2: 16, 18
 */
import java.util.*;
public class PhoneKeyPad {
	static Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
	static long result =0;
	
	static long numPhoneNumbers(int startdigit, int phonenumberlength) {
		if(phonenumberlength ==1) result++;
		else {
			List<Integer> list = map.get(startdigit);
			System.out.println("list"+list);
			if(list != null)
			{
				for(int i=0;i<list.size();i++) {
					System.out.println(startdigit +","+ phonenumberlength );
				 numPhoneNumbers((int)list.get(i),phonenumberlength-1);
			}
		  }
		}
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map.put(1,Arrays.asList(new Integer[] { 6,8 }));
		map.put(2,Arrays.asList(new Integer[] { 7,9 }));
		map.put(3,Arrays.asList(new Integer[] { 4,8 }));
		map.put(4,Arrays.asList(new Integer[] {3,9,0 }));
		map.put(6,Arrays.asList(new Integer[] { 1,7,0 }));
		map.put(8,Arrays.asList(new Integer[] { 1,3 }));
		System.out.println(numPhoneNumbers(1,3));
	}

}
