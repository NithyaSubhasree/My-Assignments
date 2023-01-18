package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSecondLargest {

	public static void main(String[] args) {
				int[] data = {3,2,11,4,6,7};
				/*
				 Pseudo Code:
				 1) Arrange the array in ascending order
				 2) Pick the 2nd element from the last and print it
				 */
 List<Integer> largest=new ArrayList<Integer> ();
 for (int i = 0; i < data.length; i++) {
	largest.add(data[i]);
}
  Collections.sort(largest);
  System.out.println(largest);
  System.out.println("The second largest number is : " + largest.get(4));
	}

}
