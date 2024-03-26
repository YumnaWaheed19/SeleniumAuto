package selenium;

import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HandleAuth {

//	RemoteWebDriver  driver ;
//	@Parameters({"browsername", "testName"})
//	@BeforeTest
//	public void setup(String browser, String testName) {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("build", "Handle Auth");
//		capabilities.setCapability("name", testName);
//		capabilities.setCapability("platform", "Windows 10");
//		capabilities.setCapability("browserName", browser); //We can change browser "CrossBrowser"
//		capabilities.setCapability("browserVersion", "121.0");
//		try {
//			driver = new RemoteWebDriver(new URL("https://yumnawaheed19:tXIZEIhppLtFMRcPUfV6wpT3Nnrl58n3VYnBHtDFYADIaRghBT@hub.lambdatest.com/wd/hub"), capabilities);
//		}catch (MalformedURLException e)  {
//			e.printStackTrace();
//		}
//	}

	public FirefoxDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(enabled = false)
	public void handleAuth() {
		String username = "admin";
		String password = "admin";
		//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//		ChromeDriver driver = new ChromeDriver();
		driver.get("https://" +username+ ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");

		String text = driver.findElement(By.cssSelector("div#content > div > p")).getText();
		String expected = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(text.trim(),expected);

	}

	@Test
	public void handleAuthentication() throws InterruptedException {
		String  username="authorized";
		String password = "password001";
		String url = "testpages.eviltester.com/styled/auth/basic-auth-results.html";
//		driver.get("https://testpages.eviltester.com/styled/auth/basic-auth-test.html");
//		driver.findElement(By.xpath("//a[contains(text(),'Basic Auth Protected Page')]")).click();
		Thread.sleep(1000);
		driver.get("https://" + username + ":" + password + "@" + url );

	}
	@AfterTest
	public void close() { 
		driver.quit();
	}
}
