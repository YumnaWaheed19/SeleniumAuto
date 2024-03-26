package selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class dragdrop {
//	RemoteWebDriver  driver ;
//	@Parameters({"browsername", "testName"})
//	@BeforeTest
//	public void setup() {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("build", "Move");
//		capabilities.setCapability("name", "Action");
//		capabilities.setCapability("platform", "Windows 10");
//		capabilities.setCapability("browserName","Chrome" ); //We can change browser "CrossBrowser"
//		capabilities.setCapability("browserVersion", "112.0");
//		try {
//			driver = new RemoteWebDriver(new URL("https://yumnawaheed19:tXIZEIhppLtFMRcPUfV6wpT3Nnrl58n3VYnBHtDFYADIaRghBT@hub.lambdatest.com/wd/hub"), capabilities);
//		}catch (MalformedURLException e)  {
//			e.printStackTrace();
//		}
//	}
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(enabled = false)  // we don't execute this test
	public void move() {
		driver.get("https://www.lambdatest.com/");
		WebElement devs = driver.findElement(By.xpath("//button[text()='Developers ']"));

		Actions builder = new Actions(driver);
		builder.moveToElement(devs).perform(); //whenever we do some actions we have to use perform()
		driver.findElement(By.xpath("(//h3[text()='API']/following-sibling::p)[2]")).click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.lambdatest.com/support/api-doc/");


	}

	//when we have both source and target

	@Test(enabled = false)
	public void dragedrop() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/dropable");
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target =driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform(); //whenever we do some actions we have to use perform(). perform call build function by itself
		Thread.sleep(5000);
	}

	//when we don't have target
	@Test(enabled = false)
	public void Draggable() {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://jqueryui.com/draggable");
//		driver.switchTo().frame(0);
//		WebElement source = driver.findElement(By.id("draggable"));
//		//if you have to do dynamically then 
//		Point location = source.getLocation();
//		int x =location.getX();
//		int y =location.getY();
//		Actions builder = new Actions(driver);
//		//from the box value coordination we are adding some coordination so we can expect that move base on some location
//		builder.dragAndDropBy(source,x+200, y+200).perform();// add xoffset and yoffset where you want to drop an element in a frame //whenever we do some actions we have to use perform(). perform call build function by itself
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.get("https://letcode.in/draggable");

		//Actions class method to drag and drop			
		Actions builder = new Actions(driver);

		WebElement from = driver.findElement(By.id("sample-box"));

		//	WebElement to = driver.findElement(By.id("droppable"));	 

		//Here, getting x and y offset to drop source object on target object location
		//First, get x and y offset for from object
		int xOffset = from.getLocation().getX();

		int yOffset =  from.getLocation().getY();

		System.out.println("xOffset1--->"+xOffset+" yOffset1--->"+yOffset);




		//Perform dragAndDropBy 
		builder.dragAndDropBy(from, xOffset,yOffset).perform();
	}
 
	
	@Test
	public void dragdropTest() {
		driver.get("https://testpages.eviltester.com/styled/drag-drop-javascript.html");
		WebElement sourcElement= driver.findElement(By.id("draggable1"));
		WebElement targetElement= driver.findElement(By.id("droppable1"));
		Actions actions= new Actions(driver);
		actions.dragAndDrop(sourcElement, targetElement).perform();
}
	
}
