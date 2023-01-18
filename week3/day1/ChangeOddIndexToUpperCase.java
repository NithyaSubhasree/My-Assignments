package week3.day1;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// Declare String Input as Follow
		  String test="changeme"; 
		  System.out.println("Given String is "+test);
		  
		//Convert the String to character array
			char[] charArray = test.toCharArray();	 
		
		//Traverse through each character (using loop)
			for (int i = 0; i < charArray.length; i++) {
		
		//find the odd index within the loop (use mod operator)
				if (i%2!=0) {
		
		//within the loop, change the character to uppercase, if the index is odd else don't change
					charArray [i] = Character.toUpperCase(charArray[i]);
				}
			}
			
		System.out.println("The text in upper case is : ");
		System.out.println(charArray);
	}

}
