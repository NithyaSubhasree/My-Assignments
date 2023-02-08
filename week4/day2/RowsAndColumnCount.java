package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsAndColumnCount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver count=new ChromeDriver(ch);
		count.manage().window().maximize();
		count.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load the url
		count.get(" https://html.com/tags/table/");
		
		// Get the count of number of rows
		List<WebElement> table1 = count.findElements(By.xpath("(//table)[1]//tr"));
		List<WebElement> table2 = count.findElements(By.xpath("(//table)[2]//tr"));
		System.out.println("No. of rows in Table 1 : " +table1.size());
		System.out.println("No. of rows in Table 2 : " +table2.size());
		
		//Get the count of number of columns
		List<WebElement> column1 = count.findElements(By.xpath("(//table)[1]//th"));
		List<WebElement> column2 = count.findElements(By.xpath("(//table)[2]//th"));
		System.out.println("No. of columns in Table 1 : " +column1.size());
		System.out.println("No. of columns in Table 2 : " + column2.size());
		
	}
}
