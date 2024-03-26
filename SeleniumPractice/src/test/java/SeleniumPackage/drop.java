package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class drop{
	@Test
	public void input() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://letcode.in/dropable");
//		WebElement source = driver.findElement(By.id("draggable"));
//		WebElement target = driver.findElement(By.id("droppable"));
//		Actions action = new Actions(driver);
//		action.dragAndDrop(source, target).perform();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://app.clickup.com/login");
		driver.findElement(By.id("login-email-input")).sendKeys("yumnawaheed19@gmail.com");
		driver.findElement(By.id("login-password-input")).sendKeys("Yumn@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Board')]")).click();
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("section[data-id='86endv2ne']"));
		WebElement target = driver.findElement(By.id("droppable"));
		action.dragAndDrop(source, target).perform();

//		WebElement source = driver.findElement(By.id("draggable"));
//		WebElement target = driver.findElement(By.id("droppable"));
//		Actions action = new Actions(driver);
//		action.dragAndDrop(source, target).perform();


	}
}