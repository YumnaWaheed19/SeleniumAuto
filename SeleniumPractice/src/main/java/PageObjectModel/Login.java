package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	//In POM we consider every web-page a separate application.
	WebDriver driver;
	public Login(WebDriver d){
		driver = d;
	}
	
	//locate an elements
	By username = By.id("user-name");
	By password = By.id("password");
	By login = By.id("login-button");
	
	public void enterUsername(String newName) {
		driver.findElement(username).sendKeys(newName);
	}
	
	public void enterPassword(String pasword) {
		driver.findElement(password).sendKeys(pasword);
	}
	public void clickLoginButton() {
		driver.findElement(login).click();;
	}
	
	
}
