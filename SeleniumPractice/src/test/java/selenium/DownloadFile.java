package selenium;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DownloadFile {
	@Test
	public void upload() throws InterruptedException {
		
		/*sometimes what happened in chrome when download a file -> Chrome displays a notification 
		'keep and discard' that we'll get for security reason so to avoid that use ChromeOptions-> Hashmap*/
		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> prefs = new	HashMap<String, Object>();
		prefs.put("download.prompt_for_download", false);
		option.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=112.0.5615.49/");
		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		Thread.sleep(1000);
	}
}
