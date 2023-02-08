package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		Actions builder=new Actions(driver);
		
		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro",Keys.ENTER);
		
		//Get the price of the first product
		Thread.sleep(1000);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		String replaceAll = price.replaceAll("[^a-zA-Z0-9]", "");
		int prc = Integer.parseInt(replaceAll);
		System.out.println("The price of first product is : " +prc);
		
		//Print the number of customer ratings for the first displayed product
		Thread.sleep(1000);
		String crating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		String replaceAll2 = crating.replaceAll("[^a-zA-Z0-9]", "");
		int rating = Integer.parseInt(replaceAll2);
		System.out.println("No. of customer ratings for the first displayed product is : " +rating);
		
		//Mouse Hover on the stars
		Thread.sleep(1000);
		WebElement mouse = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small')])[1]"));
		builder.moveToElement(mouse).perform();
		
		//Get the percentage of ratings for the 5 star.
		Thread.sleep(1000);
		//String percent = driver.findElement(By.xpath("(//span[@class='a-size-base']/a)[2]")).getText();
		//percent = percent.replaceAll("[^a-zA-Z0-9]", "");
		//int percentage = Integer.parseInt(replaceAll3);
		//System.out.println("The percentage of ratings for 5 star is : " + percent);
		
		
		//Click the first text link of the first image
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		//get the set of window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		//convert set to list
		List<String> lst=new ArrayList<String>(windowHandles);
		
		//move the control into second open window
		driver.switchTo().window(lst.get(1));
		
		
		//Take a screen shot of the product displayed
		Thread.sleep(1000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Amazon/oneplus.png");
		FileUtils.copyFile(source, destination);
		
		//Click 'Add to Cart' button
		Thread.sleep(1000);
		WebElement scroll = driver.findElement(By.xpath("//span[text()='Add gift options']"));
		builder.scrollToElement(scroll).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		
		//Get the cart subtotal and verify if it is correct.
		Thread.sleep(1000);
		String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Grand Total : " +subtotal);
		subtotal = subtotal.replaceAll("[^a-zA-Z0-9]", "");
		//int tot = Integer.parseInt(replaceAll4);
		
		if(price.contains(subtotal)){
			System.out.println("Price is same");
		}
		else {
			System.out.println("Price is not same");
		}
		
		driver.quit();
		
	}

}
