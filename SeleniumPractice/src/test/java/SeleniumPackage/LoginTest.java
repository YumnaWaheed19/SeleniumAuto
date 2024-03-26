package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {
	//By using Page Factory - write it on above the function and on header
	//@CacheLookup
	//@FindBy(xpath ="\"//div[@class='buttons']//a[1]") private WebElement loginBtn;
	
	@Test
	public void input() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://letcode.in/");
		String email ="koushik350@gmail.com";
		String pass = "Pass123$";
		WebElement signIn = driver.findElement(By.linkText("Log in"));
		signIn.click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		//this.loginBtn.click(); // by using page factory - without using driver 
		//so here we have toast message and if we immediately click on sign out it will give you an error
		//we have to wait until toast message is disappear
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alertdialog']")) ;
		wait.until(ExpectedConditions.invisibilityOf(toast));
		
		//wait.until(ExpectedConditions.elementToBeClickable(toast));
		driver.findElement(By.xpath("//div[@class='buttons']//a[1]")).click();
		
		//get source code of a page 
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}


}
