package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestClass {
	@Test
	public void logintestPage() {
	// TODO Auto-generated method stub
	System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	WebDriver driver=  new FirefoxDriver();

	LoginPageFactory LoginPg = new LoginPageFactory(driver);

	driver.get("https://www.saucedemo.com/");
	LoginPg.enterUsername("standard_user");
	LoginPg.enterPassword("secret_sauce");
	LoginPg.clickLoginButton();
	}
}
