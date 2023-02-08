package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver stock=new ChromeDriver(ch);
		stock.manage().window().maximize();
		stock.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load the url
		stock.get("https://www.chittorgarh.com/");
		System.out.println(stock.getTitle());
		
		//click stock market
		stock.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		System.out.println(stock.getTitle());
		
		//click on nse bulk deals
		stock.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		System.out.println(stock.getTitle());
		
		//get all the security names
		List<WebElement> lst = stock.findElements(By.xpath("//table//tr[\"+i+\"]/td[3]"));
		System.out.println("No. of Rows : " +lst.size());
		
		List<String> sname = new ArrayList<String>();
		System.out.println("Security names are : \n");
		
		for (int i = 0; i < lst.size(); i++) {
			String text = lst.get(i).getText();
			sname.add(text);
			
		}
		
		System.out.println(sname);
		
		//Ensure whether there are duplicate Security names

		Set <String> dup=new HashSet<String>(sname);
		System.out.println("Size after removing duplicates : " +dup.size());
		
		if(dup.size()!=lst.size()) {
			System.out.println("The table has duplicate security names");
		}
		else {
			System.out.println("The table does not contain any duplicate security names");
		}
	}
		
		
	}

