package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//setup the window and load the url
		WebDriverManager.chromedriver().setup();
		ChromeDriver frame=new ChromeDriver();
		frame.manage().window().maximize();
		frame.get("https://www.leafground.com/frame.xhtml");
		frame.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	//Handle inside frame
		frame.switchTo().frame(0);
		WebElement f1 = frame.findElement(By.xpath("//button[@id='Click']"));
		f1.click();
		System.out.println(f1.getText());
		frame.switchTo().defaultContent();
		//frame.switchTo().parentFrame();
		
		
	//nested frame
		//using id
		frame.switchTo().frame(2);
		frame.switchTo().frame("frame2");
		WebElement nf = frame.findElement(By.xpath("//button[@id='Click']"));
		nf.click();
		System.out.println(nf.getText());
	//take snapshot 
		//Add throws exception
			Thread.sleep(3000);
		//step1 : Take a snap
			File source = frame.getScreenshotAs(OutputType.FILE);
		//step2 ; Save the file as local drive
			File destination=new File("snapshot/frame.jpg");
		//combine source and destination
			FileUtils.copyFile(source, destination);
		frame.switchTo().defaultContent();
		
	//using web element 
	//frame.findElement(By.xpath("//iframe[@id='frame2']")).click();
	//WebElement nf = frame.findElement(By.xpath("//button[text()='Click Me']"));
	//nf.click();
	//System.out.println(nf.getText());
		
	//Count frames
		frame.switchTo().frame(1);
		WebElement cf = frame.findElement(By.xpath("//button[@id='Click']"));
		cf.click();
		System.out.println(cf.getText());
		frame.switchTo().defaultContent();
		
		
		int size = frame.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		
		
	}
}