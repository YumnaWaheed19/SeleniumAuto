package selenium;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Screenshot {

	@Test
	public void screenShot() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileHandler fileHandler = new FileHandler();
		try {
		fileHandler.copy(screenshotAs, new File("./snaps/img1.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		//store specific screenshot id in ele
		WebElement ele = driver.findElement(By.id("sum2"));
		File screenshotAs2 = ele.getScreenshotAs(OutputType.FILE);
		try {
		fileHandler.copy(screenshotAs2, new File("./snaps/ele.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
