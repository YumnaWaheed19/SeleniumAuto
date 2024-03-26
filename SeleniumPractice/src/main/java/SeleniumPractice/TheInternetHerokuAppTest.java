package SeleniumPractice;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TheInternetHerokuAppTest {

	public WebDriver driver;
	public String baseUrl = "https://the-internet.herokuapp.com/";
	TheInternetHerokuApp app;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		app= new TheInternetHerokuApp(driver);
	}

	@Test(enabled = false)
	public void contextMenuTest() {
		driver.get(baseUrl + "/context_menu");
		app.contextMenu();
	}

	@Test(enabled = false)
	public void digestAuthTest() {
		String username="admin";
		String password="admin";
		app.digestAuthentication(username, password);
	}
	@Test(enabled = false)
	public void formAuthTest() {
		driver.get(baseUrl + "/login");
		String username="admin";
		String password = "admin";
		app.formAuth(username, password);
	}
	@Test(enabled = false)
	public void keyPressesTest() {
		driver.get(baseUrl + "/key_presses");
		app.keyPresses(Keys.ALT);
		app.keyPresses(Keys.ESCAPE);
	}
	@Test(enabled = false)
	public void mouseAction() {
		driver.get(baseUrl + "/hovers");
		app.hover();
	}
	@Test(enabled = false)
	public void sfdTest() {
		app.sfd("admin", "admin");
	}
	@Test(enabled = false)
	public void iframeTest() {
		driver.get(baseUrl + "/iframe");
		app.iframe();
	}
	@Test(enabled = false)
	public void uiMenuTest() {
		driver.get(baseUrl + "/jqueryui/menu");
		app.uiMenu();
	}
	@Test	
	public void dynamicContentTest() {
		driver.get(baseUrl + "/dynamic_content");
		WebElement dynamiContent = driver.findElement(By.id("content"));
		List<WebElement> dynamicEle = dynamiContent.findElements(By.cssSelector("img"));
		for(int i = 0;i<dynamicEle.size();i++) {
			
			String imgUrl=dynamicEle.get(i).getAttribute("src");
			System.out.println(imgUrl);
		}
	}
	@Test(enabled = false)
	public void checkJavaScriptErrors() {
		driver.get(baseUrl + "/javascript_error");
	}
	@Test(enabled = false)
	public void shadowDomTest() {
		driver.get(baseUrl + "/shadowdom");
	}
	@Test(enabled = false)
	public void deepSelectorTest() {

	}
	//	@Test
	//	public void geolocationTest() throws InterruptedException {
	//		driver.get(baseUrl + "/geolocation");
	//		app.geoLocation();
	//	}
	//	@AfterTest
	//	public void tearDown() {
	//		try {
	//			if(driver!=null) {
	//				driver.quit();
	//				driver.close();
	//			}
	//		} catch (NoSuchMethodError e) {
	//			System.err.println("WebDriver session is already closed.");
	//		}
	//
	//	}

}
