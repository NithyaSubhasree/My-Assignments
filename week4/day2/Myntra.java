package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		
		Actions builder=new Actions(driver);
		
		//Mouse hover on MeN
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(men).perform();
		
		//Click Jackets 
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		//Find the total count of item 
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("There are " +count + "Jackets available");

		//Validate the sum of categories count matches
		String catcount = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		
		if(count.equals(catcount)) {
			System.out.println("The count is same");
		}
		else {
			System.out.println("Count is not same");
		}
		
		//Check jackets
		driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).click();
		
		//Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		//Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		//Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		
		
		//Confirm all the Coats are of brand Duke Hint : Use list
		List<WebElement> coats = driver.findElements(By.xpath("//h3[text()='Duke']"));
		System.out.println("Size of coats : " +coats.size());
		
		List<String> lst=new ArrayList<String>();
		int c=0;
		for (int i = 0; i < lst.size() ; i++) {
			String coatval = coats.get(i).getText();
			lst.add(coatval); 
			if(!(lst.get(i).equals("Duke"))) {
				c=c+1;
			}
		}
		if (c==0) {
			System.out.println("All coats are Duke");
			
		}
		
		//Sort by Better Discount
		WebElement sort = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		builder.moveToElement(sort).perform();
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		
		//Find the price of first displayed item
		String pfitem = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of first displayed item is : " +pfitem);
		
		//Click on the first product
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lstname=new ArrayList<String> (windowHandles);
		driver.switchTo().window(lstname.get(1));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		
		//Take a screen shot
		Thread.sleep(1000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./Myntra/Jacket.png");
		FileUtils.copyFile(source, destination);
		
		//Click on WishList Now
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		
		//Close Browser
		driver.quit();
		
	}

}
