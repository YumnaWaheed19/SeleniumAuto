package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable {
	WebDriver driver;
	public String baseUrl ="https://letcode.in/table";
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	// Add all the prices and check if the total is correct
	@Test(enabled = false)
	public void webTableAddPrice() {
		WebElement table= driver.findElement(By.id("shopping"));
		List<WebElement> lst = table.findElements(By.tagName("td"));
		for(int i= 0; i<lst.size(); i++) {
			//System.out.println(lst.get(i).getText());
		}

		List<WebElement> roWebElement=table.findElements(By.cssSelector("tbody tr"));
		int size = roWebElement.size();
		System.out.println(size);
		int sum = 0;
		for(int i= 0;i<size;i++){
			List<WebElement> rows = roWebElement.get(i).findElements(By.tagName("td"));
			WebElement pricElement = rows.get(1);
			String priceString=pricElement.getText();
			System.out.println(priceString);
			sum = sum + Integer.parseInt(priceString);

		}

		System.out.println("Total Sum: " +sum);

		List<WebElement> totalSumElement = driver.findElements(By.cssSelector("tfoot td"));
		WebElement getTotal = totalSumElement.get(1);
		String p= getTotal.getText();
		System.out.println(p);
		int totalPrice =Integer.parseInt(p);
		System.out.println(totalPrice);
		Assert.assertEquals(sum, totalPrice);
	}
	//Mark Raj as present
	@Test
	public void checkBox() {
		WebElement table2 =driver.findElement(By.id("simpletable"));
		List<WebElement> rows= table2.findElements(By.cssSelector("tbody tr"));
		int size =rows.size();
		System.out.println(size);
		for(int i=0;i<size;i++){
			List<WebElement> col= rows.get(i).findElements(By.tagName("td"));
			WebElement lname= col.get(1);
			String lnameString = lname.getText();
			System.out.println(lnameString);
			if(lnameString.equals("Raj")) {
				WebElement checkBox=col.get(3).findElement(By.id("second"));
				checkBox.click();
			}
		}

	}

}
