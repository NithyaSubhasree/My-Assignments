package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlert {

	public static void main(String[] args) throws InterruptedException {
		
		//setup window
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load url
		driver.get("https://www.leafground.com/alert.xhtml");
		
		//Simple Dialog
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		Thread.sleep(2000);
		sa.accept();
		String text = driver.findElement(By.id("simple_result")).getText();
		System.out.println(text);
		
		//Confirm Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert ca = driver.switchTo().alert();
		System.out.println(ca.getText());;
		Thread.sleep(2000);
		ca.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
			//cancel option in confirm dialog
				driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
				Alert ca1 = driver.switchTo().alert();
				System.out.println(ca1.getText());
				Thread.sleep(1000);
				ca1.dismiss();
				System.out.println(driver.findElement(By.id("result")).getText());
			
		//sweet alert
			driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
			driver.getTitle();
			WebElement swa = driver.findElement(By.xpath("//div[@style='height: auto;']/p"));
			System.out.println(swa);
			driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
			
			//sweet alert close
				driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
				driver.getTitle();
				String swa1 = driver.findElement(By.xpath("//div[@style='height: auto;']/p")).getText();
				System.out.println(swa1);
				driver.findElement(By.xpath("//a[@role='button']/span")).click();
				
		//sweet modal dialog
			driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
			driver.getTitle();
			String sma = driver.findElement(By.xpath("//p[@class='m-0']")).getText();
			System.out.println(sma);
			driver.findElement(By.xpath("(//a[@role='button']//span)[2]")).click();
			
		//Prompt Alert
			driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
			Alert pa = driver.switchTo().alert();
			Thread.sleep(2000);
			System.out.println(pa.getText());
			pa.sendKeys("Nithya");
			Thread.sleep(3000);
			pa.accept();
			String par = driver.findElement(By.id("confirm_result")).getText();
			System.out.println(par);
			
			//prompt alert cancel
				driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
				Alert pa1 = driver.switchTo().alert();
				System.out.println(pa1.getText());
				Thread.sleep(1000);
				pa1.sendKeys("Nithya");
				Thread.sleep(3000);
				pa1.dismiss();
				String par1 = driver.findElement(By.id("confirm_result")).getText();
				System.out.println(par1);
			
		//sweet alert
			driver.findElement(By.xpath("//span[text()='Delete']")).click();
			Thread.sleep(3000);
			String swar = driver.getTitle();
			System.out.println(swar);
			System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Are you sure')]")).getText());
			driver.findElement(By.xpath("//span[text()='Yes']")).click();
			
			//sweet alert cancel
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Are you sure')]")).getText());
				driver.findElement(By.xpath("//span[text()='No']")).click();
			
			//sweet alert close 
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				Thread.sleep(3000);
				System.out.println(driver.getTitle());
				System.out.println(driver.findElement(By.xpath("//span[contains(text(), 'Are you sure')]")).getText());
				driver.findElement(By.xpath("(//a[@role='button']/span)[6]")).click();
				
		//minimize, maximize and close the window 
			driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath("(//a[@role='button']/span)[5]")).click();
			driver.findElement(By.xpath("(//a[@role='button']/span)[4]")).click();
			driver.findElement(By.xpath("(//a[@role='button']/span)[3]")).click();
			
	}

}
