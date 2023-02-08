package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryValues {

	public static void main(String[] args) {

		//setup the path
			WebDriverManager.chromedriver().setup();
			ChromeDriver values=new ChromeDriver();
			values.manage().window().maximize();
			values.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		//load url
			values.get("https://html.com/tags/table/");
			
		//locate the table
			List<WebElement> lst = values.findElements(By.xpath("(//table)[1]//tr[2]/td"));
			System.out.println("No. of columns present : " + lst.size());
			
		String str = "Absolute Usage";
		String str1 = values.findElement(By.xpath("(//table)[1]//tr[2]/td[1]")).getText();
		
		List<String> abs=new ArrayList<String>();
		
		if(str.equals(str1)) {
			for (int i = 1; i < lst.size(); i++) {
				String val = lst.get(i).getText();
				abs.add(val);
				
			}
			System.out.println("Absolute Usage are : " + abs);
		}
			
}
}
