package SeleniumPackage;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RadioAndCheckbox{
	@Test
	public void input() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letcode.in/radio");
//		driver.findElement(By.xpath("(//label[text()=' Yes '])[1]")).click();
//
//
//		//Confirm last field is disabled
//		boolean disabled = driver.findElement(By.xpath("(//label[text()=' Going ']/following-sibling::label)[2]")).isEnabled();
//		System.out.println("Disabled: " + disabled);

		//Find which one is selected

//		WebElement val = driver.findElement(By.xpath("//label[@class='checkbox']//input)[1]"));
//		List<WebElement>radios = val.findElements(By.xpath("//input[@type ='radio']"));
//
//		for(WebElement radio : radios) {
//
//			if(radio.getAttribute("value").contains("four")){
//				radio.click();
//				String bt = (radio.getAttribute("value") + "  " + radio.isSelected());
//				// Assert.assertEquals(bt, "four  true");
//				System.out.println(bt);
//
//			}  
//					
//
//		}
		WebElement  Selected = driver.findElement(By.xpath("(//label[@class='checkbox']//input)[1]"));
		boolean select = Selected.isSelected();
		System.out.println("Selected: " +select);
		
		//check if button is displayed or not
		WebElement  disbtn = driver.findElement(By.xpath("//div[@class='navbar-item']//div[1]"));
		System.out.println("Displayed: " + disbtn.isDisplayed());
	}
}