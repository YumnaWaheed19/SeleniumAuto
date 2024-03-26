package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ajax {

	public FirefoxDriver driver;
	public String baseUrl ="https://testpages.eviltester.com/styled/basic-ajax-test.html";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void ajaxCall() throws InterruptedException {
		WebElement selCategory = driver.findElement(By.id("combo1"));
		Select sel = new Select(selCategory);
		WebElement language = driver.findElement(By.id("combo2"));
		Select selLanguage = new Select(language);	
		sel.selectByValue("2");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo2")));
		String optionString=sel.getFirstSelectedOption().getText();
		String beforeText= selLanguage.getFirstSelectedOption().getText();
		System.out.println(beforeText);
		System.out.println(optionString);
		Thread.sleep(1000);
	}
}
