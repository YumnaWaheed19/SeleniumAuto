package seleniumTestPractice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

public class TestAutomation {
	private WebDriver driver;
	@Test 
	public void setup() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=  new ChromeDriver();
		driver.get("https://signon.service-now.com/x_snc_sso_auth.do?pageId=username");
		WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Get a ServiceNow ID')]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();


	}
	@Test
	public void signup() throws InterruptedException {
		driver.findElement(By.id("firstName")).sendKeys("Yumna");
		driver.findElement(By.id("lastName")).sendKeys("Waheed");
		driver.findElement(By.id("email")).sendKeys("yumnawaheed19@gmail.com");
		WebElement countryElement= driver.findElement(By.id("country"));
		countryElement.click();
		Select select = new Select(countryElement);
		select.selectByValue("PK");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("confirmPassword")).sendKeys("123");
		driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
		driver.findElement(By.id("tnc_label")).click();

	}
	
	
		//		String actualTitleString =  "ServiceNow";
		//		String expecteString=  driver.getTitle();
		//		System.out.println(expecteString);
		//		Assert.assertEquals(actualTitleString, expecteString);
		//		Thread.sleep(3000);
		//		WebElement emailElement = driver.findElement(By.name("email")); // Replace with your actual locator
		//		emailElement.sendKeys("yumnawaheed19@gmail.com");
		//		driver.findElement(By.id("username_submit_button")).click();

		//Find the associated label using a suitable strategy (e.g., "for" attribute, parent element, etc.)
		//WebElement labelElement = driver.findElement(By.xpath("//span[text()='Email']")); // Replace with your actual locator

	
}
