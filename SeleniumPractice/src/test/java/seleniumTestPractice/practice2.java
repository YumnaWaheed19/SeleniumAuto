
package seleniumTestPractice;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.mustache.Value;

public class practice2 {
	static WebDriver driver;

	@BeforeTest 
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=  new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void verifyTitle() {
		String titleString= driver.getTitle();
		String actualString= "Swag Labs";
		System.out.println(titleString);
		Assert.assertEquals(titleString, actualString);
	}
//		@Test
//		public void verifyUpperText() {
//			WebElement loginText = driver.findElement(By.id("login-button"));
//			String expectedString= "Login";
//			String textString=loginText.getAttribute("value");
//			System.out.println("Button Text: " + textString);
//			if(textString.equals(textString.toUpperCase())) {
//				Assert.assertEquals(expectedString, textString.toUpperCase());
//				System.out.println("Text is in upper case");
//	
//			}
//			else {
//				System.out.println("Text is not in upper case");
//	
//			}
//		}

//	@Test 
//	public void verifyFilter() {
//		//		WebElement filterElement=driver.findElement(By.className("select_container"));
//		//		filterElement.getText();
//		//		System.out.println("Value:  " + filterElement);
//		WebElement selectElement = driver.findElement(By.className("product_sort_container"));
//
//		// Create a Select object from the WebElement
//		Select select = new Select(selectElement);
//
//		// Get the selected option value
//		String selectedOptionValue = select.getFirstSelectedOption().getAttribute("value");
//		System.out.println("Value:  " + selectedOptionValue);
//	}
//	
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
		
		//verify product text
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed());
		//Add first product into a cart
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		List<WebElement> productList = driver.findElements(By.xpath("(//button[text()='Add to cart'])"));
		// Get the count of products
		int productCount = productList.size();

		// Print the count of products
		System.out.println("Number of products: " + productCount);
		if (productCount > 0) {
			// Access the last element in the list
			WebElement lastProduct = productList.get(productCount - 1);
			// Now you can perform actions on the last product element
			// For example, click on the last product
			lastProduct.click();
			System.out.println("product found ");
		} else {
			System.out.println("No products found");
		}
		WebElement badgElement= driver.findElement(By.id("shopping_cart_container"));
		badgElement.click();
		driver.findElement(By.xpath("(//button[text()='Remove'])[1]")).click();
		WebElement cartCountElement=driver.findElement(By.className("shopping_cart_badge"));
		String countString =cartCountElement.getText();
		System.out.println(countString);
		Assert.assertEquals(countString, "1");
	}
	//verify add to cart button
	@Test
	public void changeFilter() {
		WebElement element=driver.findElement(By.id("continue-shopping"));
		element.click();
		WebElement filterElement=driver.findElement(By.className("product_sort_container"));
		filterElement.click();
		Select filterSelect = new Select(filterElement);
		filterSelect.selectByValue("lohi");
		
	}
	

	//	@Test
	//	public void addToCart() {
	//		
	//	//	WebElement elementList = 
	//				driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
	//
	////        // Check if the list is not empty before attempting to access the first element
	////        if (!elementList.isEmpty()) {
	////            // Access the first element in the list
	////            WebElement firstElement = elementList.get(0);
	////
	////            // Now you can perform actions on the first element
	////            // For example, click on the first element
	////            firstElement.click();
	////        } else {
	////            System.out.println("Element list is empty");
	////        }
	//
	//		
	//	
	//		//System.out.println(sizElement.getSize());
	//		
	//	}
	//	@AfterMethod
	//	public void tearDown() {
	//		if (driver != null) {
	//			driver.quit();
	//		}
	//	}
}
