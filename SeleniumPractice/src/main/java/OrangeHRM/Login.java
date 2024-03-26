package OrangeHRM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
	WebDriver driver;
	public Login(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//input[@placeholder='Username']")
	WebElement username;

	@FindBy( name = "password")
	WebElement password;

	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement login;

	@FindBy(xpath= "//p[text()='Invalid credentials']")
	WebElement invalidCre;

	@FindBy(className = "oxd-userdropdown-tab")
	WebElement dropdown;

	@FindBy(className = "oxd-userdropdown-link")
	List<WebElement> dropdownElement;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logout;

	public void enterName(String name) {
		username.sendKeys(name);	
	}

	public void enterPassword(String p) {
		password.sendKeys(p);	
	}

	public void clickLoginBtn() {
		login.click();
	}
	public void verifyTitle(String title) {
		String expectedTitle = driver.getTitle();
		System.out.println(expectedTitle);
		Assert.assertEquals(title, expectedTitle);
		if(expectedTitle.equals("OrangeHRM")) {
			System.out.println("Login Sucessully");
		}
		else {
			System.out.println("Login Failed");	
		}
	}
	public void logout() throws InterruptedException {
		dropdown.click();
		//logout.click();
		List <WebElement> listElements = dropdownElement;
		for(int i =0; i<listElements.size(); i++)
		{
			Thread.sleep(1000);
			System.out.println("Element in a dropdown: " + listElements.get(i).getText());
		}
		listElements.get(3).click();
	}
	public void loginFailedTitle(String title) {
		String actualErrorMessage = invalidCre.getText();
		Assert.assertEquals(actualErrorMessage, title, "Invalid credentials");
		System.out.println("Error message displayed: " + actualErrorMessage);
	}
}
