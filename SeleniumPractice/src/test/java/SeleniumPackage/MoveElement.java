package SeleniumPackage;

	import java.awt.event.ActionEvent;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class MoveElement{
		public FirefoxDriver driver;

		@BeforeTest
		public void setup() {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=  new FirefoxDriver();
			//driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		@Test(enabled = false)
		public void input() throws InterruptedException {
			
			driver.get("https://letcode.in/sortable");
			WebElement source = driver.findElement(By.id("(//div[@id='sample-box1'])[2]"));
			
			Actions action = new Actions(driver);
			action.moveToElement(source).perform(); 
		}
		
		@Test
		public void hover() {
			driver.get("https://testpages.eviltester.com/styled/csspseudo/css-hover.html");
			WebElement hoverElement = driver.findElement(By.id("hoverpara"));
			Actions actions =new Actions(driver);
			actions.moveToElement(hoverElement).perform();
			WebElement textElement= driver.findElement(By.id("hoverparaeffect"));
			System.out.println(textElement.getText());
		}
		
}
