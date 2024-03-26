package selenium;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
public class SelAlert {

	RemoteWebDriver  driver ;
	@BeforeTest
	public void setup() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("build", "Alert");
		capabilities.setCapability("name", "Interact with Select");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Chrome"); //We can change browser "CrossBrowser"
		capabilities.setCapability("browserVersion", "121.0");
		try {
			driver = new RemoteWebDriver(new URL("https://yumnawaheed19:tXIZEIhppLtFMRcPUfV6wpT3Nnrl58n3VYnBHtDFYADIaRghBT@hub.lambdatest.com/wd/hub"), capabilities);
		}catch (MalformedURLException e)  {
			e.printStackTrace();
		}
	}



	@Test
	public void Alert() throws InterruptedException {
		//Whenever there is an alert we can't inspect it 
		driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
		
		driver.findElement(By.xpath("//*[@id='__next']/section[3]/div/div/div/div[1]/p/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/section[3]/div/div/div/div[2]/div/p[1]/button")).click();
		alert.dismiss();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"__next\"]/section[3]/div/div/div/div[3]/p[1]/button")).click();
		alert.sendKeys("Wowww");
		alert.accept();
		Thread.sleep(3000);

	}


	//
	//	@Test
	//	public void Dropdown() {
	//		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	//		//WebDriver driver = new ChromeDriver();
	//		//driver.manage().window().maximize();
	//		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
	//
	//		String title = driver.getTitle();
	//		System.out.println("Title" + title);
	//		WebElement dropdown = driver.findElement(By.id("select-demo"));
	//		Select sel = new Select(dropdown);
	//		sel.selectByVisibleText("Friday");
	//		WebElement selectedOption = sel.getFirstSelectedOption();
	//		//sel.selectByValue("Friday");
	//      // sel.selectByIndex("3");
	//		//Select multi dropdown 
	//		WebElement multiSel = driver.findElement(By.id("multi-select"));
	//		Select coutries = new Select(multiSel);
	//		coutries.selectByIndex(2);
	//		coutries.selectByValue("Texas");
	//		
	//		List<WebElement> allSelectedOptions = coutries.getAllSelectedOptions();
	//		for(WebElement element : allSelectedOptions ) {
	//			System.out.println("All Selected Options: " + element.getText());
	//		}
	//
	//
	//
	//	}


	//	@Test
	//	public void FormDemo() {
	//		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	//		//WebDriver driver = new ChromeDriver();
	//		//driver.manage().window().maximize();
	//		driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");
	//		String title = driver.getTitle();
	//		System.out.println("Title" + title);
	//		WebElement a = driver.findElement(By.id("sum1"));
	//		WebElement b = driver.findElement(By.id("sum2"));
	//		a.sendKeys("2");
	//		b.sendKeys("3");
	//		driver.findElement(By.xpath("//button[text()='Get Sum']")).click();
	//		String text = driver.findElement(By.id("addmessage")).getText();
	//		System.out.println(text);
	//		
	//		
	//
	//	}

	@AfterTest 
	public void tearDown() {
		driver.quit();
	}
}
