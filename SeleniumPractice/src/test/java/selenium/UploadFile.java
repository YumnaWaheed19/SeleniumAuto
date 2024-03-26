package selenium;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class UploadFile {

	RemoteWebDriver  driver ;
	@Parameters({"browsername", "testName"})
	@BeforeTest
	public void setup(String browser, String testName) {
		//Selenium Grid
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Upload File");
		capabilities.setCapability("name", testName);
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", browser); //We can change browser "CrossBrowser"
		capabilities.setCapability("browserVersion", "112.0");
		try {
			driver = new RemoteWebDriver(new URL("https://yumnawaheed19:tXIZEIhppLtFMRcPUfV6wpT3Nnrl58n3VYnBHtDFYADIaRghBT@hub.lambdatest.com/wd/hub"), capabilities);
			driver.setFileDetector(new LocalFileDetector());
		}catch (MalformedURLException e)  {
			e.printStackTrace();
		}
	}


	@Test
	public void download() {
		//			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//			ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://blueimp.github.io/jQuery-File-Upload");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type= 'file']"));
		File file = new File("./snaps/img1.png");
		System.out.println("Upload file" + file.getAbsolutePath());
		uploadFile.sendKeys(file.getAbsolutePath());
		driver.findElement(By.xpath("//span[.='Start upload']")).click();
		boolean displayed =	driver.findElement(By.cssSelector("button[data-type='DELETE']")).isDisplayed();
		assertTrue(displayed);

	}




}
