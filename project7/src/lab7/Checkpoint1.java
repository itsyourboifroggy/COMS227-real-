/*package lab7;
import java.util.Arrays;

public class Checkpoint1 {
	int[] arrayLeft = new int[3];
	int[] arrayRight = new int[3];
	int leftMin = 0;
	public static void main(String[] args)
	  {
	    int[] test = {3, 4, 5, 1, 2, 3, 2}; // sum should be 20
	    //int result = arraySum(test);
	    //System.out.println(result);
	  
	    Checkpoint1 checkpoint = new Checkpoint1();
	    Checkpoint1 checkpoint2 = new Checkpoint1();
	    Checkpoint1 checkpoint3 = new Checkpoint1();
		for (int i = 0; i < 3; i++) {
			checkpoint.arrayLeft[i] = test[i];
		}
		for (int i = 4; i < 7; i++) {
			checkpoint2.arrayRight[i-4] = test[i];
		}
		for (int x = 1; x < checkpoint.arrayLeft.length; x++) {
			if (checkpoint.arrayLeft[x] > checkpoint.arrayLeft[x-1]) {
				checkpoint3.leftMin = x;
			}
		}
	  System.out.println(checkpoint3.leftMin);
	  }
}
*/
package lab7;

import java.util.Arrays;

public class Checkpoint1 {
	int[] levels;

	int n = 1;

	public int getPyramidCount(int levels) {
		if (levels == 1) {
			return 1;
		} else {

			return (levels * levels) + getPyramidCount(levels - 1);
		}

	}

	public static void main(String[] args) {

		int[] test = { 3, 4, 5, 1, 2, 3, 2 };

		Checkpoint1 checkpoint = new Checkpoint1();
		System.out.println(checkpoint.getPyramidCount(3));
		int max = checkpoint.findMax(test, 0, test.length - 1);

		System.out.println("The maximum value is: " + max);
	}

	public int findMax(int[] arr, int left, int right) {

		if (left == right) {
			return arr[left];
		}

		int mid = (left + right) / 2;

		int leftMax = findMax(arr, left, mid);

		int rightMax = findMax(arr, mid + 1, right);

		return Math.max(leftMax, rightMax);
	}
}
