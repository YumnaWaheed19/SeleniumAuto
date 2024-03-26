package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.AbstractParallelWorker.Arguments;

import SeleniumPractice.TheInternetHerokuApp;

public class Scroll {
	public WebDriver driver;
	public String baseUrl = "https://www.calculator.net";
	TheInternetHerokuApp app;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		app= new TheInternetHerokuApp(driver);
	}
	@Test
	public void jsExecuter() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scroll vertically
		Thread.sleep(3000);
		js.executeScript("window.scroll(0,500)");
		
//		To scroll down the webpage by the visibility of an element -> vertically or horizontally
		WebElement element= driver.findElement(By.linkText("Due Date Calculator"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		//to scroll down the bottom of the webpage 
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		
	}
}
