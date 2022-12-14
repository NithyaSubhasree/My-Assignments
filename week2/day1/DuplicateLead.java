package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver duplicate=new ChromeDriver();
		duplicate.manage().window().maximize();
		duplicate.get("http://leaftaps.com/opentaps/control/login");
		duplicate.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		duplicate.findElement(By.id("username")).sendKeys("democsr");
		duplicate.findElement(By.id("password")).sendKeys("crmsfa");
		duplicate.findElement(By.className("decorativeSubmit")).click();
		duplicate.findElement(By.linkText("CRM/SFA")).click();
		duplicate.findElement(By.linkText("Leads")).click();
		duplicate.findElement(By.linkText("Create Lead")).click();
		duplicate.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		duplicate.findElement(By.id("createLeadForm_firstName")).sendKeys("Nithya");
		duplicate.findElement(By.id("createLeadForm_lastName")).sendKeys("Subhasree");
		duplicate.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("S");
		duplicate.findElement(By.name("departmentName")).sendKeys("Civil");
		duplicate.findElement(By.id("createLeadForm_description")).sendKeys("Non IT to IT Transformation");
		duplicate.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("nithyasubhasree4@gmail.com");
		duplicate.findElement(By.className("smallSubmit")).click();
		System.out.println(duplicate.getTitle());
		duplicate.findElement(By.linkText("Duplicate Lead")).click();
		duplicate.findElement(By.id("createLeadForm_companyName")).clear();
		duplicate.findElement(By.id("createLeadForm_companyName")).sendKeys("LMW");
		duplicate.findElement(By.id("createLeadForm_firstName")).clear();
		duplicate.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhineshwar");
		duplicate.findElement(By.name("submitButton")).click();
		System.out.println(duplicate.getTitle());
	}
}

		
		
				