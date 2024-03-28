package HeadlessBrowserDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

import OrangeHRM.addEmpolyee;
/*Headless Browser -> means a web browser without user interface
headless browser are those which actually access the WebPage but GUI/Screen is hidden from user
Screen/steps are visible to user in real browser but in headless browser it is hidden.
*/
public class headlessBrowserTesting {

	public static void main(String[] args) throws InterruptedException {
		
		
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			// convert it into headless browser
			//ChromeOptions options=new ChromeOptions();  //for chromedriver
			FirefoxOptions options= new FirefoxOptions();
			options.setHeadless(true);
			WebDriver driver=  new FirefoxDriver(options);

			driver.get("https://www.google.com");
			System.out.println("Befor Search:  " +driver.getTitle());
			WebElement searchBox= driver.findElement(By.name("q"));
			searchBox.sendKeys("Laptop");
			searchBox.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			System.out.println("After Search:  " +driver.getTitle());

			driver.quit();
			
			
	}

}
