package TestNgParameter;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testngParameters {

	/*@BeforeTest runs only once before the 1st @Test method runs but 
	  @BeforeMethod runs each time prior to the run of each @Test*/
	
	public WebDriver driver;
	@BeforeMethod(description = "Open sauce demo website")
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
	
	}
	@Test(invocationCount = 2)
	@Parameters({"uname","pass"})
	public void login(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
