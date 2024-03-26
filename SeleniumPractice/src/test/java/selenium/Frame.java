package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Frame {
	@Test
	public void frames() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/frame");
		//driver.findElement(By.name("fname")).sendKeys("Yumna"); //no such element exception so the issue is -> we have a frame 
		// so if an element is there within the frame then first of all we have to switch to the frame
		
		//below are three methods of locating a frame ->by name/id, index and webelement
		
		//parent Frame
		//driver.switchTo().frame("firstFr");
		//driver.switchTo().frame(1);  //by index
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src ='frameUI']"));
		driver.switchTo().frame(iframe);
		
		
		driver.findElement(By.name("fname")).sendKeys("Yumna");
		driver.findElement(By.name("lname")).sendKeys("Waheed");
		
		
		//nested frame  //child frame
		WebElement second_iframe = driver.findElement(By.cssSelector("iframe.has-background-white"));
		driver.switchTo().frame(second_iframe);
		driver.findElement(By.name("email")).sendKeys("yumnawaheed19@gmail.com");
		
		//parent Frame
		driver.switchTo().parentFrame();
		driver.findElement(By.name("fname")).sendKeys("Test");
		
		//Default content
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Log in")).click();

		
	}
}


//make config class for selenium grid (desired capabilities) and extends to other classes

