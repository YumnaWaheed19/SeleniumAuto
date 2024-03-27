package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class fillFormInOneStatement {
	public String baseUrl ="https://www.saucedemo.com/";
	public WebDriver driver;

	@Test
	public void login() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		Actions actions= new Actions(driver);
		Action seriesOfActions= actions.moveToElement(driver.findElement(By.id("user-name")))
				.click()
				.sendKeys("standard_user", Keys.TAB)
				.sendKeys("secret_sauce", Keys.ENTER).build();
		seriesOfActions.perform();
	}
}
