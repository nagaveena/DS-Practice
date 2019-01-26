import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 */

/**
 * @author Veena
 *
 */
public class WordBreak {

	/**
	 * @param args
	 */
	static List<String>list  =new ArrayList<String>();
	static List<String> wordBreak(String strWord, String[] strDict) {
		Set<String> set = new HashSet<String>(Arrays.asList(strDict));
		recurseCheck(strWord,set,"");
		for(String s: list) {
			System.out.println("s:" +s);
			
		}
		return list;
	
	}
	static void recurseCheck(String strWord, Set strDict,String result) {
		//System.out.println("word:"+strWord);
		 System.out.println("1.result:"+result);
		// if(n == 0) {
		//	 return true;
		// }
		for(int i =0; i<=strWord.length(); i++) {
		  String prefix = strWord.substring(0,i);
		  System.out.println("prefix:"+prefix);
		 if(strDict.contains(prefix)) {
			 if( i == strWord.length()) {
				 
				 result  += prefix;
				 System.out.println("result:"+result);
			    list.add(result);
			 }
			 recurseCheck(strWord.substring(i),strDict,result+prefix+" ");
		}
	}
		
	}
	static void nonDuplicates() {
		
	    int []arr={6, 1, 3, 3, 3, 6, 6};
	    int result =arr[0];
	    for(int i:arr)
	    {
	        result ^=i;
	        System.out.println("1 Result is "+result);
	        
	    }

	    System.out.println("Result is "+result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dictionary[] =new String[] {"mobile","samsung","sam","sung",
                "man","mango", "icecream","and",
                "go","i","love","ice","cream"};
		String strWord ="samsung";
		WordBreak.wordBreak(strWord, dictionary);
		//WordBreak.nonDuplicates();

	}

}
