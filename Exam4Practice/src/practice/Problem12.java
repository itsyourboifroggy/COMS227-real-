package practice;

public class Problem12 {
// all you make is the sort method
	
	public static void mergeSort(int[] arr)
	  {
	    mergeSortRec(arr, 0, arr.length - 1);
	  } 
	
	private static void mergeSortRec(int[] arr, int start, int end) {
		 if (start >= end) {
			 return;
		 }
		 int mid = (start + end) /2;
		
		 mergeSortRec(arr, start, mid);
		 
		 mergeSortRec(arr, mid +1, end);
		 
		 merge(arr, start, end, mid);
			
		 }
	private static void merge(int[] arr, int start, int end, int mid) {
		
		 
	 }
	public static void main(String[] args) {
	    int[] arr = {12, 11, 13, 5, 6, 7};
	    System.out.println("Given Array:");
	    for (int num : arr) {
	        System.out.print(num + " ");
	    }
	    System.out.println();

	    mergeSort(arr);

	    System.out.println("\nSorted array:");
	    for (int num : arr) {
	        System.out.print(num + " ");
	    }
	}

	
}
