
public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      char [] chars = new char[] {'a','a','b','b','c','c','c'};
      
      StringCompress sc = new StringCompress();
      sc.compress(chars);
      System.out.println(chars);
	}
	
	
	    public int compress(char[] chars) {
	        int cnt = 1;
	        int j =0;
	        int len = chars.length;
	        int i =0;
	        while(i< len){
	        	
	            	System.out.println(i);
	                if(i < (len-1) && chars[i] == chars[i+1]){
	                    cnt ++;
	                    
	                }
	                else {
	                    chars[j+1] = Character.forDigit(cnt, 10);
	                    cnt =1 ;
	                    j = i+1;
	                }
	         
	            i++;
	        }
	        while(len > j) {
	        	chars[len--]= ' ';
	        }
	        return j;
	        
	    }
	}


