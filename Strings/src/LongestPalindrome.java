
public class LongestPalindrome {
	
	public void findLongestSubstring(String input) {
		Result res  = new Result();
		for(int k= 0 ; k < input.length();k++) {
			int  i = k ,  j = k;
			while(i >= 0 && j < input.length()  
			      && input.charAt(i) == input.charAt(j)) {
				i--;
				j++;
			}
			if(j-i > res.right-res.left) {
				System.out.println("1."+res.left +"," +res.right);
			  res.left = i;
			  res.right =j;
			}
			//if even palindrome
			  i = k ;  j = k+1;
			while(i >= 0 && j < input.length()  
			      && input.charAt(i) == input.charAt(j)) {
				i--;
				j++;
			}
			if(j-i > res.right-res.left) {
				System.out.println("1."+res.left +"," +res.right);
			  res.left = i;
			  res.right =j;
			}
		}
		System.out.println(res.left +"," +res.right);
	}
    public  class Result{
    	int left = 0;
    	int right = 0;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcbccbaaaaa";
		LongestPalindrome palindrome = new LongestPalindrome();
		palindrome.findLongestSubstring(input);
		//Result r = new Result();
		//System.out.println(r.left +"," +r.right);
	}

}
