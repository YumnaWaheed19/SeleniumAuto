package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Input{
	@Test
	public void input() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/edit");
		driver.findElement(By.id("fullName")).sendKeys("Yumna Waheed");
		
		//Enter your full name
		driver.findElement(By.id("join")).sendKeys(" Yumna Waheed", Keys.TAB);
		
		//append text and press tab key
		String value = driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(value);
		
		//clear the text box
		driver.findElement(By.id("clearMe")).clear();
		
		
		//confirm is it disabled
		boolean isEdit = driver.findElement(By.id("noEdit")).isEnabled();
		//Assert.assertEquals(enabled, "false");
		System.out.println(isEdit);
		
		
		//confirm is it readonly
		String isReadonly = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		//Assert.assertEquals(enabled, "false");
		System.out.println(isReadonly);
		
	}

}
