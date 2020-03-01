
public class SortTheCharacters {
	
	public static void quickSort(char[] in, int start,int end) {
		if(start > end)
			return;
		int pivot = partition(in,start,end);
		quickSort(in,start,pivot-1);
		quickSort(in,pivot+1,end);
	}
	public static int partition(char[] a,int start,int end) {
		char pivot = a[end];
		int j = start-1;
		
		for(int i =0 ;i < a.length;i++) {
			if(a[i] <= pivot) {
				j++;
			 char temp = a[i];
			 a[i] = a[j];
			 a[j] = temp;
			}
		}
		char temp =a[j+1];
		a[j+1] = a[end];
		a[end] = temp;
		return j+1;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
