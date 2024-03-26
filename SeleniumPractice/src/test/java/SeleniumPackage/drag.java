package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class drag{
		@Test
		public void input() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://letcode.in/draggable");
	
			// Locating the source element
			WebElement source = driver.findElement(By.id("sample-box"));
			String title = source.getText();
			System.out.println(title);
			Actions action = new Actions(driver);
			//  Getting the position of the source element
			Point position = source.getLocation();
			int x = position.getX();
			int y = position.getY();
			System.out.println("x =>"  + x + "&" + "y: "  +y);
			// Calculating the new position for drag and drop
			int xOffset = x + 20; // Adjust these offsets as needed
			int yOffset = y + 30; // Adjust these offsets as needed
			System.out.println("xOffset: "  + xOffset + "&" + "yOffset: "  +yOffset);
	
			// Performing the drag-and-drop action using the calculated position
	
			action.dragAndDropBy(source, xOffset, yOffset).build().perform();
		}


}