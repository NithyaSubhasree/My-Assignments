package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) {
/*1. Launch the URL https://www.ajio.com/
2. In the search box, type as "bags" and press enter
3. To the left  of the screen under " Gender" click the "Men"
4. Under "Category" click "Fashion Bags"
5. Print the count of the items Found. 
6. Get the list of brand of the products displayed in the page and print the list.
7. Get the list of names of the bags and print it
 */

		WebDriverManager.chromedriver().setup();
		ChromeDriver list=new ChromeDriver();
		list.get("https://www.ajio.com/");
		list.manage().window().maximize();
		list.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		list.findElement(By.name("searchVal")).sendKeys("bags" , Keys.ENTER);
		
	}

}
