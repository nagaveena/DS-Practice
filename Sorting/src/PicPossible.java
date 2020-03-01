import java.util.Arrays;

public class PicPossible {

	/*
	 * Given 2 unsorted arrays check if pic can it be possible
	 * if all elements from 1 array is lesser than another array elements then pic can be taken 
	 * as smaller elements if stands in the front..
	 * Time complexity - sorting O(nlogn) + O(n) for checking if possible
	 */
	public PicPossible() {
		// TODO Auto-generated constructor stub
	}
	
	boolean isPicPossible(float[] a ,float[] b ,int n) {
		Arrays.sort(a);
		Arrays.sort(b);
		//System.out.println("a[0]"+ a[0]);
		if(a[0] < b[0])
			return checkIfPossible(a,b,n);
		else
			return checkIfPossible(b,a,n);
		
	}
	boolean checkIfPossible(float[]a,float[]b,int n) {
		int i =0 ,j =0;
		while (i < n && j<n) {
			if(a[i] < b[j]) {
				i++;
				j++;
			}
			else return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] a = new float[] { 1,2,3,4};
		//float[] a = new float[] { 1,2,8,4};
		float[] b = new float[] { 5,5,6,7};
		PicPossible  pic = new PicPossible();
		boolean possible = pic.isPicPossible(a, b, a.length);
		System.out.println("Pic is possible:"+ possible);
		
	}

}
