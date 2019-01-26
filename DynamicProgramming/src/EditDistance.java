
/*
 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

*You have the following 3 operations permitted on a word:

* Insert a character

* Delete a character

* Replace a character

*example: Minimum edit distance between the words 'kitten' and 'sitting', is 3


Sample Input-1:
cat
bat

Sample Output-1:

1

Explanation-1:

1: Replace c with b.

 
 */
public class EditDistance {
	
	static int levenshteinDistance(String strWord1, String strWord2) {
        /*
         * Write your code here.
         */
         int m = strWord1.length();
         int n = strWord2.length();
         int[][] dp = new int[m+1][n+1];
         
         for(int i =0; i <= m ;i++)
           dp[i][n] = m-i;
         
         for(int j =0; j <=n ;j++)
           dp[m][j] = n-j;
         
         for(int i = m-1;i >= 0; i--)  {
             for(int j = n-1; j>=0;j--){
                 dp[i][j] = Integer.MAX_VALUE;
                 if(strWord1.charAt(i) != strWord2.charAt(j)){
                     dp[i][j] = Math.min(dp[i][j],dp[i][j+1]);
                     dp[i][j] = Math.min(dp[i][j],dp[i+1][j]);
                     dp[i][j] = Math.min(dp[i][j],dp[i+1][j+1]);
                     dp[i][j] = 1+dp[i][j];
                 }else{
                     dp[i][j] = dp[i+1][j+1];
                 }
             }
         }
        return dp[0][0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
