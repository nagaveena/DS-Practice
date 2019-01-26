/*
 * Exampl: S1 ->abcdaf
 * S2->acbcf
 *   a b c d a f
 * a 1 1 1 1 1 1
 * c 1 
 * b
 * c
 * f 
 */
public class LongestCommonSubSeq {
	public void  lcs(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		//populate the dp if char matches 1+ max of diagonal value
		//if no match of chars then max i-1,j-1 value
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
