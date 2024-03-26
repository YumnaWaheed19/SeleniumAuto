package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class refreshNow {

	public WebDriver driver;
	public String baseUrl = "https://testpages.eviltester.com/styled/refresh";
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void refresh() throws InterruptedException{
		//driver.navigate().refresh();
		WebElement refreshNowBtn= driver.findElement(By.id("button"));
		refreshNowBtn.click();
		Thread.sleep(5000);
		WebElement refreshdateElement=driver.findElement(By.id("refreshdate"));
		String textString=refreshdateElement.getText();
		System.out.println(textString);
		
		
	}
}