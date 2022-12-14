package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
	//set up the path
		WebDriverManager.chromedriver().setup();
	//create object for chrome driver
		ChromeDriver driver=new ChromeDriver();
	//window maximize
		driver.manage().window().maximize();
	//load the url
		driver.get("http://leaftaps.com/opentaps/control/login");
	//wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//enter the user name
		driver.findElement(By.id("username")).sendKeys("democsr");
	//enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	//click login button
		driver.findElement(By.className("decorativeSubmit")).click();
	//click the link
		driver.findElement(By.linkText("CRM/SFA")).click();
	}

}