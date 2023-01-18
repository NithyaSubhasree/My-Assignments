package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		/*/*http://leaftaps.com/opentaps/control/main
			* 1	Launch the browser
			* 2	Enter the username
			* 3	Enter the password
			* 4	Click Login
			* 5	Click crm/sfa link
			* 6	Click Leads link
			* 7	Click Find leads
			* 8	Enter first name
			* 9	Click Find leads button
			* 10 Click on first resulting lead
			* 11 Verify title of the page
			* 12 Click Edit
			* 13 Change the company name
			* 14 Click Update
			* 15 Confirm the changed name appears
			* 16 Close the browser (Do not log out)
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver edit=new ChromeDriver();
		edit.manage().window().maximize();
		
		//launch browser
		edit.get("http://leaftaps.com/opentaps/control/main");
		edit.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//enter username
		edit.findElement(By.id("username")).sendKeys("democsr");
		
		//enter the password
		edit.findElement(By.id("password")).sendKeys("crmsfa");
		
		//click login
		edit.findElement(By.className("decorativeSubmit")).click();
		String title = edit.getTitle();
		System.out.println(title);
		
		//click crm/sfa link
		edit.findElement(By.xpath("//a[contains(text(),'SFA')]")).click();
		String title1 = edit.getTitle();
		System.out.println(title1);
		
		//Click Leads link
		edit.findElement(By.linkText("Leads")).click();
		String title2 = edit.getTitle();
		System.out.println(title2);

		//Click Find leads
		edit.findElement(By.linkText("Find Leads")).click();
		System.out.println(edit.getTitle());
		
		//Enter first name
		edit.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("nithya");
		
		//Click Find leads button
		edit.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Click on first resulting lead
		Thread.sleep(2000);
		edit.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell')]/a[1]")).click();
		
		//Verify title of the page
		String title3="View Lead | opentaps CRM";
		String title4 = edit.getTitle();
		if (title4.equalsIgnoreCase(title3)) {
			System.out.println("Title Matched");
		}
		else {
			System.out.println("Title Mismatched");
		}
		
		//Click Edit
		edit.findElement(By.xpath("//a[@class='subMenuButton'][3]")).click();
		
		//Change the company name
		edit.findElement(By.id("updateLeadForm_companyName")).clear();
		edit.findElement(By.id("updateLeadForm_companyName")).sendKeys("LMW");
		
		//Click Update
		edit.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
		
		//Confirm the changed name appears
		boolean displayed = edit.findElement(By.id("viewLead_companyName_sp")).isDisplayed();
		System.out.println(displayed);
		
		//Close the browser (Do not log out)
		edit.close();
		
	}

		
	}
