package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver merge=new ChromeDriver();
		merge.get("http://leaftaps.com/opentaps/control/login");
		merge.manage().window().maximize();
		merge.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		//Enter UserName and Password Using Id Locator
		merge.findElement(By.id("username")).sendKeys("democsr");
		merge.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click on Login Button using Class Locator
		merge.findElement(By.className("decorativeSubmit")).click();
		
		//Click on CRM/SFA Link
		merge.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Click on contacts Button
		merge.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Merge Contacts using Xpath Locator
		merge.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		merge.findElement(By.xpath("//img[@alt='Lookup']")).click();
		String windowHandle = merge.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(merge.getTitle());
		
		//convert set to list
		Set<String> windowHandles = merge.getWindowHandles();
		List<String> contact1=new ArrayList<String>(windowHandles);
		
		//switch handle to the new window
		merge.switchTo().window(contact1.get(1));
		System.out.println(merge.getWindowHandle());
		System.out.println(merge.getTitle());
		
		//Click on First Resulting Contact
		merge.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//switch control to parent page
		merge.switchTo().window(contact1.get(0)); 
	
		System.out.println(merge.getWindowHandle());
		System.out.println(merge.getTitle());
		
		//Click on Widget of To Contact
		merge.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		//switch handle to the new window
		String windowHandle2 = merge.getWindowHandle();
		System.out.println(windowHandle2);
		System.out.println(merge.getTitle());
		
		//convert set to list
		Set<String> windowHandles2 = merge.getWindowHandles();
		List<String> contact2=new ArrayList<String>(windowHandles2);
		
		//switch control to new window
		merge.switchTo().window(contact2.get(1));
		System.out.println(merge.getWindowHandle());
		System.out.println(merge.getTitle());
		
		//Click on Second Resulting Contact
		merge.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		
		//control to parent window
		merge.switchTo().window(contact2.get(0));
		
		//Click on Merge button using Xpath Locator
		merge.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//Accept the Alert
		Thread.sleep(3000);
	
		Alert confirm = merge.switchTo().alert();
		System.out.println(confirm.getText());
		confirm.accept();
		
		//Verify the title of the page
		System.out.println(merge.getTitle());
	}
}
