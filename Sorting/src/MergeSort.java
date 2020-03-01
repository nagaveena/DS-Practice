
public class MergeSort {
	
	static int[] MergeSortArray(int[] intArr) {
        sort(intArr,0,intArr.length-1);
        return intArr;

    }
    public static void sort(int[] intArr,int l, int r){
        if(l < r)
        {
         int m = (l+r)/2;
        
         sort(intArr,l,m);
         sort(intArr,m+1,r);
         merge(intArr,l,r);
        }
        
    }
    public static void merge(int[] a, int l, int r){
       int m = (r+l)/2;
       int [] temp = new int[r-l+1];
       int i =l;
       int j =m+1;
       int k =0;
       while(i <= m && j <= r ){
           if(a[i] > a[j])
            temp[k++] = a[j++];
           else //if (a[i] <= a[j])
             temp[k++] = a[i++];
       }
       while( i <= m)
         temp[k++] = a[i++];
       while(j <= r)
         temp[k++] = a[j++];
       i = l;
       
       for(k=0;k<temp.length;k++)// this is needed if need to copy to orig array
          a[i++] = temp[k];
      
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int a[] ={6,2,7,1,8,5};
       MergeSortArray(a);
       for(int i:a)
    	   System.out.println(i);
	}

}
