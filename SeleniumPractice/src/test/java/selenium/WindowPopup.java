package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowPopup {
	@Test
	public void window() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow); 
		//When click on linkedin button a child window open 
		driver.findElement(By.linkText("Follow us On Linkedin")).click();
		Set<String> windowHandles = driver.getWindowHandles(); //multiple windows
		List<String> windows = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windows.get(1)); // it means switch from parent window to chils window.
		//get(1)-> move to child window, get(0) move to parent window
		driver.close(); //switch to child window then immediately close to it
		
		String title = driver.getTitle();
		System.out.println("Child Window: " + title);
		System.out.println(title);
		//switch to parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Back to Parent Window: " + driver.getTitle()); //print tab title
		
		//driver.close(); // when we have child and parent window then active window will be closed. now th child window is closed not the parent because child window is active
		//if you want to quit both windows , close all tabs then use driver.quit()
	driver.quit();
	}
}
