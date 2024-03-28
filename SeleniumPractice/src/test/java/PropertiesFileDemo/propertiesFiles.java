package PropertiesFileDemo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import OrangeHRM.Login;

public class propertiesFiles {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver=  new FirefoxDriver();
		readConfigFile configFile=new readConfigFile();
		driver.get(configFile.getUrl());
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath( "//input[@placeholder='Username']")).sendKeys(configFile.getName());	
		driver.findElement(By.name ( "password")).sendKeys(configFile.getPassword());
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
	}


}
