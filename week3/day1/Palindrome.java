package week3.day1;

public class Palindrome {

	public static void main(String[] args) {
	//Declare A String value as"madam"
		String value = "madam";
	//Declare another String rev value as ""
	String rev="";
	
	//Iterate over the String in reverse order
	for (int i = value.length()-1; i >=0 ; i--) {
		
	//Add the char into rev
		rev = rev + value.charAt(i);
	}
	
	//Compare the original String with the reversed String, if it is same then print palinDrome 
	if(rev.equals(value)) {
		System.out.println("The given string " +value + " is a palindrome");
		
	}
	
	else {
		System.out.println("The given string " +value + " is not a Palindrome");
	}
	//Hint: Use .equals or .equalsIgnoreCase when you compare a String 

	}

}
