
public class SubSetCheck {
/*
 * Given 2 sorted arrays , find if subset array exists in bigger array
 */
	public SubSetCheck() {
		// TODO Auto-generated constructor stub
	}
	
	boolean isSubset(int[] a1,int [] a2) {
		int m = a1.length;
		int n = a2.length;
		
		int i =0, j=0, matches=0;
		while(i < m && j < n) {
			if(a1[i] == a2[j]) {
				i++;
				j++;
				matches++;
			}
			else if(a1[i] < a2[j])
				i++;
			else j++;
		}
		
		return (matches == Math.min(m,n));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = {1,5,7,8,9,10};
		int arr2[] = { 7, 8};
		//int arr2[] = {1,5,7,8,9,10};
		SubSetCheck sub = new SubSetCheck();
		boolean check = sub.isSubset(arr1, arr2);
		System.out.println("SUbset exists:"+ check);
	}

}
