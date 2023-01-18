package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver contact=new ChromeDriver();
		contact.manage().window().maximize();
		contact.get("http://leaftaps.com/opentaps/control/login");
		contact.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		contact.findElement(By.id("username")).sendKeys("democsr");
		contact.findElement(By.id("password")).sendKeys("crmsfa");
		contact.findElement(By.className("decorativeSubmit")).click();
		contact.findElement(By.linkText("CRM/SFA")).click();
		contact.findElement(By.linkText("Contacts")).click();
		contact.findElement(By.linkText("Create Contact")).click();
		contact.findElement(By.id("firstNameField")).sendKeys("Nithya");
		contact.findElement(By.id("lastNameField")).sendKeys("Subhasree");
		contact.findElement(By.name("submitButton")).click();
		System.out.println(contact.getTitle());
		String text= contact.findElement(By.id("viewContact_firstName_sp")).getText();
		System.out.println(text);
		contact.close();
	}
}