package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver create=new ChromeDriver();
		create.manage().window().maximize();
		create.get("http://leaftaps.com/opentaps/control/login");
		create.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		create.findElement(By.id("username")).sendKeys("democsr");
		create.findElement(By.id("password")).sendKeys("crmsfa");
		create.findElement(By.className("decorativeSubmit")).click();
		create.findElement(By.linkText("CRM/SFA")).click();
		create.findElement(By.linkText("Leads")).click();
		create.findElement(By.linkText("Create Lead")).click();
		create.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		create.findElement(By.id("createLeadForm_firstName")).sendKeys("Nithya");
		create.findElement(By.id("createLeadForm_lastName")).sendKeys("Subhasree");
		create.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("S");
		create.findElement(By.name("departmentName")).sendKeys("Civil");
		create.findElement(By.id("createLeadForm_description")).sendKeys("Non IT to IT Transformation");
		create.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("nithyasubhasree4@gmail.com");
		create.findElement(By.className("smallSubmit")).click();
		System.out.println(create.getTitle());
		
}
	
}
