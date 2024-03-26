package SeleniumPackage;

import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class button{
	@Test
	public void input() {	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/buttons");
	}
//		
//		//click button
//		driver.findElement(By.id("home")).click();
//		Thread.sleep(1000);
//		driver.navigate().back();
//		
//		//get the color of the button
//		WebElement btn = driver.findElement(By.id("color"));
//		String buttonColor = btn.getCssValue("background-color");	
//		System.out.println(buttonColor);	
//		
//		//Get the X & Y co-ordinates
//		WebElement source = driver.findElement(By.id("position"));
//		Point location = source.getLocation();
//		int x = location.getX();
//		int y =location.getY();
//		System.out.println("x: " + x + "," + "y: " + y);
//		
//		//Find the height & width of the button
//		WebElement size = driver.findElement(By.id("property"));
//		Dimension buttonSize = size.getSize();
//		//Dimension buttonSize = size.getDImension();
//		System.out.println(buttonSize);
//		
//		//Confirm button is disabled
//		boolean isDisabled = driver.findElement(By.id("isDisabled")).isEnabled();
//		System.out.println(isDisabled);
//		
//		//Click and Hold Button
//		Actions action = new Actions(driver);
//		WebElement clickHold = driver.findElement(By.xpath("(//button[@class='button is-primary'])[2]"));
//		action.moveToElement(clickHold);
//		action.clickAndHold().perform();
//		Thread.sleep(1000);
//		WebElement AfterHold = driver.findElement(By.xpath("//button[@id='isDisabled']//h2[1]"));
//		System.out.println(AfterHold.getText());
//	}
}