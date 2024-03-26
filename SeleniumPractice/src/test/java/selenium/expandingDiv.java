package selenium;

import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SeleniumPractice.TheInternetHerokuApp;

public class expandingDiv {
	public WebDriver driver;
	public String baseUrl = "https://testpages.eviltester.com/styled/expandingdiv.html";


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	//a div expands when you hover over it.
	@Test
	public void expands() {
		Actions  actions= new Actions(driver);
		WebElement element= driver.findElement(By.className("expand"));
		actions.moveToElement(element).perform();
		WebElement link= element.findElement(By.xpath("//div[@class='expand']//a[1]"));
		String linkString= link.getAttribute("href");
		System.out.println("Link: "+linkString);
		link.click();
	}
	
	

}
