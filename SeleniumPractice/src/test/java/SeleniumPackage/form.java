package SeleniumPackage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class form{
	public FirefoxDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(enabled = false)
	public void input() throws InterruptedException {
		driver.get("https://letcode.in/forms");
		driver.findElement(By.id("firstname")).sendKeys("Yumna");
		driver.findElement(By.id("lasttname")).sendKeys("Waheed");
		WebElement email=	driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("yumnawaheed19@gmail.com");
		WebElement selCountryCode = driver.findElement(By.xpath("(//div[@class='select']//select)[1]"));
		Select sel = new Select(selCountryCode);
		sel.selectByValue("92");
		driver.findElement(By.id("Phno")).sendKeys("3135233049");
		driver.findElement(By.id("Addl1")).sendKeys("xyz");
		driver.findElement(By.id("Addl2")).sendKeys("xyz");
		driver.findElement(By.id("state")).sendKeys("xyz");
		driver.findElement(By.id("postalcode")).sendKeys("123");	
		WebElement selCountry = driver.findElement(By.xpath("(//div[@class='select']//select)[2]"));
		Select selCoun = new Select(selCountry);
		selCoun.selectByValue("Pakistan");		
		driver.findElement(By.id("Date")).sendKeys("12/02/2023");
		driver.findElement(By.id("female")).click();

		WebElement checkbox = driver.findElement(By.xpath("//label[@class='checkbox']//input[1]"));
		if(!checkbox.isSelected()) {
			System.out.println("Please check terms and conditions");
			//checkbox.click();
		}

	}
	@Test(enabled = false)
	public void htmlForm() throws InterruptedException {
		driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
		driver.findElement(By.name("username")).sendKeys("Yumna");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		List<WebElement> formData =driver.findElements(By.tagName("li"));
		for(int i=0; i<formData.size();i++) {
			System.out.println("Your Info: " +formData.get(i).getText() );
		}
	}
	@Test
	public void formvalidation() {
		driver.get("https://testpages.eviltester.com/styled/basic-javascript-validation-test.html");
		WebElement age301 = driver.findElement(By.id("lteq30a"));
		age301.sendKeys("35");
		age301.sendKeys(Keys.ENTER);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(age301.getText());
		WebElement age302 = driver.findElement(By.id("lteq30b"));
		age302.sendKeys("20");
		int age = Integer.parseInt(age302.getAttribute("value"));
	    if (age > 40) {
	        // Perform actions if age is greater than 40
	        // For example, print a message
	        System.out.println("Age is greater than 40.");
	    }
	}
}

