/*
 * Input Format:
*You will be given two integer arrays, NUTS[] and BOLTS[] of size N.
* Output Format:
* Return a string array res, of size N, with an entry for each pair of Nut and its corresponding Bolt separated by a single space.
* Format: “Nut Bolt”
* Order of the output does not matter.
 */
public class NutsAndBolts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static String[] solve(int[] nuts, int[] bolts) {
        /*
         * Write your code here.
         */
         int start =0;
         int end = nuts.length -1;
         String[] out = new String[end +1];
         matchArrays(nuts,bolts,start, end);
         for(int i =0; i < nuts.length ;i++){
             out[i] = nuts[i] + " " + bolts[i];
         }
     return out;
   }
    static void matchArrays(int[] nuts,int[] bolts, int start,int end){
        //if(start >= end) return;
    if(start < end){
        int pivot = partition(nuts,start,end,bolts[end]);
        partition(bolts,start,end,nuts[pivot]);
        
        matchArrays(nuts,bolts,start,pivot-1);
        matchArrays(nuts,bolts,pivot+1 ,end);
        }
        
    }
    static int partition(int[] nuts,int start,int end,int pivotElem){
        
        int i = start;
        int temp;
        for(int j = start ;j < end ;j++){
            if(nuts[j] < pivotElem){
                 temp = nuts[j];
                nuts[j] = nuts[i];
                nuts[i] = temp;
                i++;
            }else if(nuts[j] == pivotElem){
                 temp = nuts[j];
                nuts[j] = nuts[end];
                nuts[end] = temp;
                j--;
            }
           // System.out.prin
        }
        temp = nuts[i];
        nuts[i] = nuts[end];
        nuts[end] = temp;
        return i;
    }
}
    
