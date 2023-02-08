package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAction {

	public static void main(String[] args) throws InterruptedException {
		//setup the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load the url
		driver.get("https://www.leafground.com/drag.xhtml");
		
		Actions builder=new Actions(driver);
		
		//draggable
		WebElement draggable = driver.findElement(By.xpath("(//span[@class='ui-panel-title'])[1]"));
		System.out.println("Location Before Dragging : " +draggable.getLocation());
		builder.dragAndDropBy(draggable, 100, 50).perform();
		System.out.println("Location After Dragging : " +draggable.getLocation());
		
		//droppable
		WebElement source = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		builder.dragAndDrop(source, destination).perform();
				
		//draggable rows
		WebElement row1 = driver.findElement(By.xpath("(//table)[6]//tr[2]"));
		WebElement row2 = driver.findElement(By.xpath("(//table)[6]//tr[5]"));
		builder.dragAndDrop(row1, row2).perform();
				
		//draggable column 
		WebElement col1 = driver.findElement(By.xpath("(//table)[5]//th[2]"));
		WebElement col2 = driver.findElement(By.xpath("(//table)[5]//th[3]"));
		builder.dragAndDrop(col1, col2).perform();
		
		Thread.sleep(1000);
		String confirm = driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		String msg="Columns reordered";
		if (confirm.equals(msg)) {
			System.out.println("The columns are reordered");
		}
		
		//scroll down
		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(), 'All Rights Reserved')]"));
		builder.scrollToElement(scroll).perform();
		
		//Resize image
		WebElement resize = driver.findElement(By.xpath("//div[contains(@class, 'ui-resizable')]"));
		Point location = resize.getLocation();
		int x= location.getX();
		int y= location.getY();
		System.out.println(x + " " + y);
		
		builder.clickAndHold(resize).moveByOffset(50, 10).release().build().perform();
		Point location2 = resize.getLocation();
		int x2=location2.getX();
		int y2=location2.getY();
		System.out.println(x2 + " " + y2);
		
		//progress bar
		WebElement prgbar = driver.findElement(By.xpath("//span[text()='Start']"));
		prgbar.click();
		Thread.sleep(1000);
		String pb1 = driver.findElement(By.xpath("//span[text()='Progress Completed']")).getText();
		String pb2="Progress Completed";
		if (pb1.equals(pb2)) {
			System.out.println("Progress completed");
		} else {
			System.out.println("Progress incomplete");
		}

		//range slider
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Point location3 = slider.getLocation();
		System.out.println("Initial value : " +location3);
		builder.dragAndDropBy(slider, 20, 60).perform();
		
		Point loc1 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]")).getLocation();
		System.out.println("Final value : " +loc1);
		
		//Point loc2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]")).getLocation();
		//System.out.println("Highest value : " + loc2);

		//int x3= loc1.getX();
		//int y3=loc1.getY();
		
		
	}

}
