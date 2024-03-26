package SeleniumPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandling {
	
	public FirefoxDriver driver;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void window() throws InterruptedException{
		driver.get("https://letcode.in/windows");
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		for (String winId: list) {
			System.out.println(winId);
		}
		int size = list.size();
		//Open new window 
		System.out.println("No. of Windows opened: " +size);
		driver.switchTo().window(list.get(0)); 
		System.out.println("Title " + driver.getTitle());
//		driver.close(); // close current window
//		driver.quit(); // close all windowa
		
	}
}
