package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
WebDriver driver;
public LoginPageFactory(WebDriver d) {
	driver = d;
	PageFactory.initElements(driver, this);
}
@FindBy(id="user-name")
WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="login-button")
WebElement login;

public void enterUsername(String newName) {
	username.sendKeys(newName);
}

public void enterPassword(String pasword) {
	password.sendKeys(pasword);
}
public void clickLoginButton() {
	login.click();
}



}
