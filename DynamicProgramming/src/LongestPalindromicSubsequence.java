
public class LongestPalindromicSubsequence {
	
	public  static int LPSRecurse(char[] str,int start,int len) {
		if(len == 1) return 1;
		if(len == 0 ||start >= len) return 0;
		
		if(str[start] == str[len]) {
			return (2 + LPSRecurse(str,start+1,len-1));
		}
		else {
			return(Math.max(LPSRecurse(str,start+1,len),LPSRecurse(str,start,len-1)));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "agbdba";
		System.out.println(LPSRecurse(str.toCharArray(),0,str.length()-1));
	}

}
