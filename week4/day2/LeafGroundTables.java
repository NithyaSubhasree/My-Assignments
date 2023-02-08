package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTables {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver tables=new ChromeDriver();
		tables.manage().window().maximize();
		tables.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		tables.get("https://leafground.com/table.xhtml");
				
		//count of tagname
		List<WebElement> tag = tables.findElements(By.tagName("th"));
		System.out.println("No. of Header tag : " + tag.size());
		
		//Get the column count
		List<WebElement> col = tables.findElements(By.xpath("(//table[@role='grid'])[1]//th"));
		System.out.println("No. of columns : " + col.size());
		for (int i = 0; i < col.size(); i++) {
			System.out.println(col.get(i).getText());
		}
		
		//get the entire row count 
		List<WebElement> row = tables.findElements(By.xpath("(//table[@role='grid'])[2]//tr"));
		System.out.println("No. of rows : " + row.size());
		for (int j = 0; j < row.size(); j++) {
			System.out.println(row.get(j).getText());
		}
		
		//Print particular data
		String pd = tables.findElement(By.xpath("(//table[@role='grid'])[2]//tr[2]//td[2]")).getText();
		System.out.println(pd);
				
		//Get the particular column data (Country Names)
		List<WebElement> cn = tables.findElements(By.xpath("(//table[@role='grid'])[2]//tr/td[2]"));
		System.out.println("No. of countries in table" + cn.size());
		
		List<String> cnames=new ArrayList<String>();
		for (int i = 0; i < cn.size(); i++) {
			String cns = cn.get(i).getText();
			cnames.add(cns);
		}
		System.out.println("Countries names are : " +cnames);
		
		
		
	}

}
