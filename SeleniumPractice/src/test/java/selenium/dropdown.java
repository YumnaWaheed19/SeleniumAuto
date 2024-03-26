package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class dropdown {
	@Test
	public void Dropdown() { 
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
		String title = driver.getTitle();
		System.out.println("Title" + title);
		WebElement dropdown = driver.findElement(By.id("select-demo"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Friday");
		WebElement selectedOption = sel.getFirstSelectedOption();
		//sel.selectByValue("Friday");
		// sel.selectByIndex("3");
		//Select multi dropdown 
		WebElement multiSel = driver.findElement(By.id("multi-select"));
		Select coutries = new Select(multiSel);
		coutries.selectByIndex(2);
		coutries.selectByValue("Texas");
		
		List<WebElement> allSelectedOptions = coutries.getAllSelectedOptions();
		for(WebElement element : allSelectedOptions ) {
			System.out.println("All Selected Options: " + element.getText());
		}



	}

}
