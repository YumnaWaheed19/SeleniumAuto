package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProvider {

//	public FirefoxDriver driver;
//	public String baseUrl ="https://www.google.com";
//
//	@BeforeTest
//	public void setup() {
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
//		driver=  new FirefoxDriver();
//		driver.get(baseUrl);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	}

	@DataProvider(name="SearchDataSet")
	public Object[][] searchData(){
		Object[][] searchkeyword= new Object[3][2];
		searchkeyword[0][0]="Pakistan";
		searchkeyword[0][1]="Minar-e-Pakistan";
		
		searchkeyword[1][0]="Pakistan";
		searchkeyword[1][1]="Quaid-e-Azam House Museum";
		
		searchkeyword[2][0]="Pakistan";
		searchkeyword[2][1]="Quaid-e-Azam House Museum";

		return searchkeyword;

	}
	@Test(dataProvider = "SearchDataSet")
	public void TestdataProvider(String Country, String Monument) {
		//WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	    System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get("https://www.google.com/");
	    WebElement searchbox = driver.findElement(By.name("q"));
	    searchbox.sendKeys(Country + " " + Monument);
	    driver.findElement(By.name("btnK")).click();
	}
}
