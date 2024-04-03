package DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDataProvider {

	public WebDriver driver;
	@BeforeMethod(description = "Open sauce demo website")
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();	
		//options.setHeadless(true);
		driver=  new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");

	}

	@DataProvider(name= "login")
	public Object[][] logiCredentials(){

		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"problem_user","secret_sauce"}
		};	
	}

	@Test(dataProvider = "login",enabled = false)
	public void login(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

	}	

	@Test(dataProvider = "loginCredentails", dataProviderClass = DataProviderClass.class, enabled = true)
	public void loginWithDPClass(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

	}

	@DataProvider(name= "sum")
	public Integer[][] Sum(){
		return new Integer[][] {
			{2,3,5},
			{5,5,10}
		};
	}
	
	@Test(dataProvider = "sum", enabled = false)
	public void sumTest(int a, int b, int result) {
		Assert.assertEquals(a, b, result);
	}
}
