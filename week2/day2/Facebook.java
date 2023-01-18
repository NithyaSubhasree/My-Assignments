package week2.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver facebook=new ChromeDriver();
		facebook.manage().window().maximize();
		facebook.get("https://en-gb.facebook.com/");
		facebook.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		facebook.findElement(By.xpath("//a[text()='Create New Account']")).click();
		facebook.findElement(By.name("firstname")).sendKeys("Nithya");
		facebook.findElement(By.name("lastname")).sendKeys("Subhasree");
		facebook.findElement(By.name("reg_email__")).sendKeys("8508430756");
		facebook.findElement(By.id("password_step_input")).sendKeys("nithya");
		
		//select date
		WebElement day = facebook.findElement(By.id("day"));
		Select daydrop=new Select(day);
		Thread.sleep(2000);
		daydrop.selectByValue("11");
		
		//select month
		WebElement month = facebook.findElement(By.name("birthday_month"));
	    Select monthdrop=new Select(month);
	    Thread.sleep(2000);
	    monthdrop.selectByIndex(1);
	    
	    //select year
	    WebElement year = facebook.findElement(By.id("year"));
	    Select yeardrop=new Select(year);
	    Thread.sleep(2000);
	    yeardrop.selectByVisibleText("1997");
	    
	    //select female
	    Thread.sleep(2000);
	    facebook.findElement(By.xpath("//label[text()='Female']")).click();
	}
}

		