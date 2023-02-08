package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

	public static void main(String[] args) throws InterruptedException {
		//setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver window=new ChromeDriver();
		window.manage().window().maximize();
		window.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//load url
		window.get("https://leafground.com/window.xhtml");
		String windowHandle = window.getWindowHandle();
		System.out.println(window.getTitle());
		
		//Click and confirm new window opens
		window.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println(window.getWindowHandle());
		System.out.println(window.getTitle());
		Set<String> tab = window.getWindowHandles();
		List<String> win1=new ArrayList<String>(tab);
		window.switchTo().window(win1.get(1));
		System.out.println(window.getWindowHandle());
		System.out.println(window.getTitle());
		
		//Find the number of opened tabs
		window.switchTo().window(win1.get(0));
		window.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = window.getWindowHandles();
		List<String> opn=new ArrayList<String> (windowHandles2);
		System.out.println(opn.size() + " tabs are opened");
		
		//Close all windows except primary
		window.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		for (String str : window.getWindowHandles()) {
			if(!str.equals(windowHandle)) {
				window.switchTo().window(str);
				window.close();
			}
			
		}
		
		window.switchTo().window(windowHandle);
		
		//wait for two new tabs to open
		window.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(2000);
		
	}

}
