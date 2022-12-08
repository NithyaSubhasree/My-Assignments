package week1.day1;

public class Mobile {
	public void makeCall() {
		String mobileModel="Redmi Note 7 Pro";
		float mobileWeight=186f;
	}
	public void sendMsg() {
		boolean fullCharged=true;
		int mobileCost=15000;
	}
	public static void main(String[] args) {
		Mobile obj=new Mobile();
		obj.makeCall();
		obj.sendMsg();
		System.out.println("This is my Mobile");
	}
}
