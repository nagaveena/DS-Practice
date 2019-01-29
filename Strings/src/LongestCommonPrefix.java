import java.util.Arrays;

public class LongestCommonPrefix {
	
	public int findLongestCommonPrefix(String[] input) {
		if(input == null || input.length == 0) return 0;     
		//Arrays.sort(input);
		String prefix = input[0];
	//	System.out.println(prefix);
		//int i =0;
		int n = input.length;
		for(int i = 1; i <n;i++) {
			System.out.println(input[i].indexOf(prefix));
			while(input[i].indexOf(prefix) != 0)
				prefix = prefix.substring(0,prefix.length()-1);
			
		}
	return prefix.length();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] in =  {"flower","flow","floght"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.findLongestCommonPrefix(in));

	}

}
