package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGDemo.Listener.class)
public class TestngListener {
	//Listener is an Interface ->based on the result of test cases -> if we take an action so listener is used t perform an action 
	//ITest Listener Methods -> onTestStart, onTestSuccess, onTestFailure, onTestSkipped, onStart, onFinish(), ontestfailedbutwithinsuccesspercentage
	public String baseUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@Test
	public void login() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}
	@Test
	public void testFail()
	{
		System.out.println("Failed test case.");
		Assert.assertTrue(false);
	}
	@Test
	public void testSkipped()
	{
		System.out.println("skipped test case.");
		throw new SkipException("skip exception thrown...");
	}
}
