package SeleniumPackage;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Selenium_Alert{
	@Test
	public void input() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();

		//Type your name & accept
		driver.findElement(By.id("prompt")).click();
		driver.switchTo().alert();
		alert.sendKeys("Yumna Waheed");
		Thread.sleep(1000);
		alert.accept();
		String text = driver.findElement(By.id("myName")).getText();
		System.out.println(text);
		
		//sweetAlert
		driver.findElement(By.id("modern")).click();
		Thread.sleep(1000);
		String sweettext = driver.findElement(By.xpath("(//div[@class='card-content']//p)[2]")).getText();
		System.out.println(sweettext);
		driver.findElement(By.xpath("//div[@class='modal is-active']//button[1]")).click();
		
		//Dismiss the Alert & print the alert text
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.dismiss();
		
		
		
	}
}
