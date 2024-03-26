package TestNGDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDataProvider {

	/*Similar to TestNG Parameters, Data Providers are a means to pass data to test methods in TestNG. 
	Using Data Provider in TestNG, we can easily inject multiple values into the same test case. It 
	comes inbuilt in TestNG and is popularly used in data-driven frameworks.
	Object{row][column] -> 
	 */

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

	public FirefoxDriver driver;
	public String baseUrl ="https://www.google.com";

	@Test(dataProvider = "SearchDataSet")
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
