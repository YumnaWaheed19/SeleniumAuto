package SeleniumPractice;

import java.net.PasswordAuthentication;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TheInternetHerokuApp {
	WebDriver driver;
	public TheInternetHerokuApp(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	} 

	@FindBy(id= "hot-spot") WebElement contextMenu;
	@FindBy(css ="div#content>div>p") WebElement authText;
	@FindBy(id ="username") WebElement uname;
	@FindBy(id ="password") WebElement pass;
	@FindBy(xpath ="//button[@type='submit']//i[1]") WebElement submitBtn;
	@FindBy(id= "flash") WebElement alertElement;
	@FindBy(xpath = "//div[@class='example']//button[1]") WebElement location;
	@FindBy(id = "target")  WebElement keypresElement;
	@FindBy(xpath = "(//div[@class='figure']//img)[1]")  WebElement hoverElement;
	@FindBy(xpath = "(//div[@class='figcaption']//h5)[1]") WebElement hoverResult;
	@FindBy(id = "result") List<WebElement> result;
	@FindBy(xpath = "//a[contains(text(),'Dummy.txt')]") WebElement fileDownload;
	@FindBy(id= "mce_0_ifr") WebElement iframe;
	@FindBy(id = "tinymce") WebElement enterText;
	String url = "the-internet.herokuapp.com/digest_auth";

	public void contextMenu() {
		//for right click call context_click function of Action class
		Actions actions= new Actions(driver);
		actions.contextClick(contextMenu).perform();
		Alert alert= driver.switchTo().alert();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		alert.accept();
	}

	public void digestAuthentication(String username, String password) {
		//to handle auth we need to use following url format "https://" +username + ":" + password + "@"  + url"
		driver.get("https://" +username + ":" + password + "@"  + url);
		String ExpectedResult = authText.getText();
		String actualString = "Congratulations! You must have the proper credentials.";
		System.out.println(ExpectedResult);
		Assert.assertTrue(actualString.contains(ExpectedResult));	

	}
	//Form Authentication 
	public void formAuth(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		submitBtn.click();
		String alertString = alertElement.getText();
		System.out.println(alertString);
		if(alertElement.isDisplayed()) {
			System.out.println("Error message is displyed");
		}
		else {
			System.out.println("Error message isn't displyed");
		}
		String actualAlertString = "Your username is invalid!";
		Assert.assertTrue(alertString.contains(actualAlertString));
	}

	//KeyPresses
	public void keyPresses(Keys keyPresses) {
		keypresElement.sendKeys(keyPresses);
		List<WebElement> lstElements = result;
		for(int i = 0; i<lstElements.size(); i++) {
			System.out.println("Result:  " +lstElements.get(i).getText());
		}
	}
	//hover
	public void hover() {
		Actions actions = new Actions(driver);
		actions.moveToElement(hoverElement).perform();
		System.out.println("Hover Result: " + hoverResult.getText());
	}
	//Secure File Download
	public void sfd(String u_name, String pas) {
		String fileUrl ="the-internet.herokuapp.com/download_secure";
		driver.get("https://" + u_name + ":" + pas + "@" + fileUrl);
		fileDownload.click();

	}
	//GeoLocation
	public void geoLocation() throws InterruptedException {
		// Emulate geolocation
		// driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		location.click();
		Thread.sleep(2000);
		WebDriver.TargetLocator alert = driver.switchTo();
		alert.alert().accept();
	}
	//iFrame
	public void iframe() {
		//find iframe from the inspect elements
		driver.switchTo().frame(iframe);
		enterText.sendKeys("successfull");
	}
	//JQuery UI Menus -> "https://www.youtube.com/watch?v=whvgrQhBZrY"
	public void uiMenu() {
		WebElement enabled = driver.findElement(By.id("ui-id-3"));
		WebElement downloads = driver.findElement(By.id("ui-id-4"));
		WebElement pdf = driver.findElement(By.id("ui-id-5"));	
		Actions actions= new Actions(driver);
		actions.moveToElement(enabled).pause(Duration.ofSeconds(2)).
		moveToElement(downloads).pause(Duration.ofSeconds(2)).
		moveToElement(pdf).click().build().perform();
	}
	//JavaScript on-load event error
	public void eventError() {	
	}
	//Forgot Password
	public void forgotPass() {

	}
	//shadowDom
	public void shadowDom() {

	}
	//Deep Selector
	public void deepSelector() {

	}
	//broken Images
	//dynamic button

}
