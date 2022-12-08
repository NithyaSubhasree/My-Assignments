package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int num=34343;
		int reverse=num;
		int a;
		for (int sum=0; reverse>num; reverse =num/10) {
			reverse = num % 10;
			sum= sum*10 + reverse;
			break;
			}
		if (num==reverse) {
			System.out.println("The given number is a Palindrome");
		}
		else {
			System.out.println("The given number is Not a Palindrome");
		}

	}

}
