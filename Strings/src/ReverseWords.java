
public class ReverseWords {
	
	public  void reverseString(char[] c) {
		reverseWords(c,0,c.length-1);
		int start =0;
		int end ;
		for( end = 0; end <=c.length;end++) {
			if(c[end] == ' ') {
				reverseWords(c,start,end-1);
				start = end+1;
			}
		}
		reverseWords(c,start,end-1);//This is for last word as we reach to end of 
		//the given string and don't reverse as we don't see 'space in the word
	}
	
	public void reverseWords(char[] c, int start,int end) {
		while(start < end) {
			char temp = c[start];
			c[start++] = c[end];
			c[end--] = temp;
		}
		System.out.println(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char [] c = {'c','a','k','e',' ',
    		        'p','o','u','n','d',' ',
    		        's','t','e','a','l'};
       ReverseWords rw = new ReverseWords();
       rw.reverseString(c);
       }

}


