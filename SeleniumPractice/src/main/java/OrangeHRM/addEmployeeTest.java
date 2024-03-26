package OrangeHRM;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class addEmployeeTest {
	public String baseUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	addEmpolyee emp;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emp = new addEmpolyee(driver);	
		emp.login("Admin", "admin123");

	}
	@Test
	public void addEmp() throws IOException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emp.clickPIM();
		emp.addEmployee("Yumna", "Waheed", "19022");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Get screenshot file type
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//crate fileHandler constructor
		FileHandler fileHandle= new FileHandler();
		fileHandle.copy(screenShotFile, new File("./snaps/Screenhot.png"));


	}
	//	@Test
	//	public void searchMenuTest() throws InterruptedException {
	//		emp.search();
	//	}
	//	@Test
	//	public void searchEmp() throws InterruptedException {
	//		emp.clickPIM();
	//		emp.searchEmployee("Yumna");
	//	}	
	//	@Test
	//	public void searchAdminTest() throws InterruptedException {
	//		emp.searchAdmin();
	//	}

	//	@AfterTest
	//	public void tearDown() {
	//	    try {
	//	        // Close the WebDriver only if it is still active
	//	        if (driver != null) {
	//	            driver.quit();
	//	        }
	//	    } catch (NoSuchSessionException e) {
	//	        // Catch and handle NoSuchSessionException
	//	        System.err.println("WebDriver session is already closed.");
	//	    }
	//	}
}
