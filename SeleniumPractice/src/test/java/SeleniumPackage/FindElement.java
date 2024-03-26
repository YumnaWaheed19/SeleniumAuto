package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FindElement {
	@Test
	public void findElement() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/elements");
		driver.findElement(By.xpath("//input[@placeholder='Enter your git user name eg., ortonikc']")).sendKeys("YumnaWaheed19",Keys.ENTER);
	//	driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		// when we have to interact multiple elements - print all repository (e.g, we have 30/ 2 repository)
		List<WebElement> links = driver.findElements(By.xpath("(//div[@class='block'])[1]//li"));
		for (WebElement ele :links) {
			System.out.println(ele.getText());  //print repository links
		}
	}
}
