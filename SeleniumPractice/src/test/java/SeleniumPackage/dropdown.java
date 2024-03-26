package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dropdown{
	@Test
	public void input() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/dropdowns");
		WebElement dropdown =	driver.findElement(By.id("fruits"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Mango");


		WebElement selByVal =	driver.findElement(By.id("country"));
		Select val = new Select(selByVal);
		val.selectByValue("India");


		WebElement multiSel =	driver.findElement(By.id("superheros"));
		Select mul = new Select(multiSel);
		mul.selectByValue("ek");
		mul.selectByIndex(2);
		boolean multi = mul.isMultiple();
		System.out.println(multi);

		//deselect an element
		mul.deselectByIndex(2);

		List<WebElement> allSelectedOptions = mul.getAllSelectedOptions();
		for(WebElement element : allSelectedOptions ) {
			System.out.println("All Selected Options: " + element.getText());
		}

		//select last option
		WebElement lastSel =	driver.findElement(By.id("lang"));
		Select lastSelectedOption = new Select(lastSel);
		//System.out.println(lastSelectedOption.getFirstSelectedOption());
		//get the size of drop down
		int selectOptions = lastSelectedOption.getOptions().size();
		lastSelectedOption.selectByIndex(selectOptions - 1);

	}
}
