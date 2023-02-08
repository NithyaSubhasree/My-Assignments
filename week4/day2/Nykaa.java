package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver nykaa=new ChromeDriver(ch);
		nykaa.manage().window().maximize();
		nykaa.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//load url
		nykaa.get("https://www.nykaa.com/");
		
		//Mouseover on Brands and Search L'Oreal Paris
		WebElement brands = nykaa.findElement(By.xpath("//a[text()='brands']"));
		
		Actions builder=new Actions(nykaa);
		builder.moveToElement(brands).perform();
		
		nykaa.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		
		//click L'Oreal Paris
		nykaa.findElement(By.xpath("(//a[contains(text(), 'Paris')])[1]")).click();
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("Title of the page is : " +nykaa.getTitle());
		
		//Click sort By and select customer top rated
		Thread.sleep(1000);
		nykaa.findElement(By.className("sort-name")).click();
		
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//scroll 
		Thread.sleep(1000);
		WebElement scroll = nykaa.findElement(By.xpath("(//span[text()='Price'])[1]"));
		builder.scrollToElement(scroll).perform();
		
		//Click Category and click Hair->Click haircare->Shampoo
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("//span[text()='Category']")).click();
		
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("//span[text()='Hair']")).click();
		
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("//span[text()='Hair Care']")).click();
		
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		
		//scroll
		WebElement scroll1 = nykaa.findElement(By.xpath("//span[text()='Formulation']"));
		builder.scrollToElement(scroll1).perform();
		
		//Click->Concern->Color Protection
		nykaa.findElement(By.xpath("//span[text()='Concern']")).click();
		nykaa.findElement(By.xpath("(//div[contains(@class, 'indicator checkbox ')])[10]")).click();
		
		//check whether the Filter is applied with Shampoo
		String text="shampoo";
		String text1 = nykaa.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
		if(text.equalsIgnoreCase(text1)) {
			System.out.println("The filter Shampoo is applied successfully");
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		nykaa.findElement(By.xpath("//div[contains(text(),'Colour Protect Shampoo')]")).click();
		
		
		//GO to the new window and select size as 175ml
		String windowHandle = nykaa.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(nykaa.getTitle());
		
		
		Set<String> windowHandles = nykaa.getWindowHandles();
		List<String> lst=new ArrayList<String> (windowHandles);
		nykaa.switchTo().window(lst.get(1));
		System.out.println(nykaa.getWindowHandle());
		System.out.println(nykaa.getTitle());
		
		WebElement size = nykaa.findElement(By.xpath("//select[@title='SIZE']"));
		Select sz=new Select(size);
		sz.selectByIndex(1);
		
		//Print the MRP of the product
		String mrp = nykaa.findElement(By.xpath("(//span[contains(text(),'189')])[1]")).getText();
		System.out.println("Price of the shampoo is : " + mrp );
		
		//Click on ADD to BAG
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		
		//String conmsg = nykaa.findElement(By.xpath("//div[@class='body']")).getText();
		//System.out.println(conmsg);
		
		//Go to Shopping Bag
		Thread.sleep(1000);
		nykaa.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		//handle frame
		Thread.sleep(1000);
		nykaa.switchTo().frame(0);
		
		//Print the Grand Total amount
		//String gtotal = nykaa.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']")).getText();
		//System.out.println("Grand Total Amount : " + gtotal);
		
		String Gt = nykaa.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']")).getText();
		String replaceAll1 = Gt.replaceAll("\\D", "");
		int Grandtotal=Integer.parseInt(replaceAll1);
		System.out.println("Grand total amount :"+Grandtotal);
		
		
		//Click Proceed
		nykaa.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		//Click on Continue as Guest
		nykaa.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		//Check if this grand total is the same in step 14
		nykaa.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
		
		
		String gtot = nykaa.findElement(By.xpath("(//p[contains(@class, 'eka6zu20')])[6]")).getText();
		//String replaceAll2 = gtot.replaceAll("\\D", "");
		String replaceAll2 = gtot.replaceAll("\\D", "");
		int GrandTotal1=Integer.parseInt(replaceAll2);
		System.out.println("Final Grand Total is : " +GrandTotal1);
		
		
		if(Gt.equals(gtot)) {
			System.out.println("The grand total is same");
		}
		else {
			System.out.println("The grand total is different");
		}
		
		//Close all windows
		nykaa.quit();
		System.out.println("End of testing");
		
}
}
