package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class automateNow {

	public FirefoxDriver driver;
	public String baseUrl ="https://practice-automation.com/";

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		//driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test(enabled = false)
	public void accordation() {
		driver.get(baseUrl + "/accordions");
		driver.findElement(By.tagName("summary")).click();
		WebElement accordationText=  driver.findElement(By.className("wp-block-coblocks-accordion-item__content"));
		String expectettext =  accordationText.getText();
		String actualString = "This is an accordion item.";
		Assert.assertTrue(actualString.contains(expectettext));
	}
	@Test(enabled = true)
	public void brokenlinks() throws InterruptedException, MalformedURLException, IOException {
		driver.get(baseUrl + "/broken-links");
		Thread.sleep(5000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link : links) {
			String linkURL = link.getAttribute("href");
			//we need to get status
			HttpURLConnection con = (HttpURLConnection) new URL(linkURL).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int responseCode = con.getResponseCode();
			if(responseCode >= 400) {
				System.out.println("link Text: " + link.getText() + "\n" + "Response Code: " + responseCode);
			}
			else {
				System.out.println("The page hasn't any broken link");
			}
		}
	}
}
