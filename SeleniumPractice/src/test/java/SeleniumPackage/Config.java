package SeleniumPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Config {
	public	RemoteWebDriver  driver ;
	//@Parameters({"browsername", "testName"})
	@BeforeTest()
	public void setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Selenium Practice");
		capabilities.setCapability("name", "SelTest");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Chrome"); //We can change browser "CrossBrowser"
		capabilities.setCapability("browserVersion", "121.0");
		try {
			driver = new RemoteWebDriver(new URL("https://yumnawaheed19:tXIZEIhppLtFMRcPUfV6wpT3Nnrl58n3VYnBHtDFYADIaRghBT@hub.lambdatest.com/wd/hub"), capabilities);
		}catch (MalformedURLException e)  {
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
