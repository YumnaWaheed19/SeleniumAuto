package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		
		Login LoginPg = new Login(driver);
		
		driver.get("https://www.saucedemo.com/");
		LoginPg.enterUsername("standard_user");
		LoginPg.enterPassword("secret_sauce");
		LoginPg.clickLoginButton();
	}

}
