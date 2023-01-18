package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		/*http://leaftaps.com/opentaps/control/main
		 
		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver delete=new ChromeDriver();
		delete.manage().window().maximize();
		
		//Launch the browser
		delete.get("http://leaftaps.com/opentaps/control/main");
		delete.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username
		delete.findElement(By.id("username")).sendKeys("democsr");
		
		//Enter the password
		delete.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login
		delete.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		delete.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		
		//Click Leads link
		delete.findElement(By.linkText("Leads")).click();
		
		//Click Find leads
		delete.findElement(By.linkText("Find Leads")).click();
		
		//Click on Phone
		delete.findElement(By.xpath("(//span[@class='x-tab-strip-inner']/span)[2]")).click();
		
		//Enter phone number
		delete.findElement(By.name("phoneNumber")).sendKeys("8508430756");
		
		//Click find leads button
		delete.findElement(By.linkText("Find Leads")).click();
		
		//Capture lead ID of First Resulting lead
		WebElement leadId = delete.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		System.out.println(leadId);

		//Click First Resulting lead
		delete.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Click Delete
		delete.findElement(By.xpath("(//div[@class='frameSectionExtra']/a)[4]")).click();
		
		//Click Find leads
		delete.findElement(By.linkText("Find Leads")).click();
		
		//Enter captured lead ID
		delete.findElement(By.xpath("(//div[@class='x-form-element']/input)[11]"));
		
		
		
		//Click find leads button
		
		
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		
		
		//Close the browser (Do not log out)
	
	
	}

}
