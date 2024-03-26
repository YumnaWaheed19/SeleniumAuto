package OrangeHRM;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.primitives.Bytes;
public class LoginTest {
	public String baseUrl ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void loginTestPositive() throws InterruptedException {
		Login LoginPg = new Login(driver);
		LoginPg.enterName("Admin");
		String password="admin123";
		//Encrypted password -> to secure password from hackers
		byte[] encodedPassword=org.apache.commons.codec.binary.Base64.encodeBase64(password.getBytes());
		System.out.println(new String(encodedPassword));
		//decode password
		byte[] decodedPassword=org.apache.commons.codec.binary.Base64.decodeBase64("YWRtaW4xMjM=");
		LoginPg.enterPassword(new String(decodedPassword));	
		LoginPg.clickLoginBtn();
		LoginPg.verifyTitle("OrangeHRM");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPg.logout();
	}
//	@Test
//	public void loginTestNegative() {
//		Login LoginPg = new Login(driver);
//		LoginPg.enterName("123");
//		LoginPg.enterPassword("admin");	
//		LoginPg.clickLoginBtn();
//		LoginPg.loginFailedTitle("Invalid credentials");
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
