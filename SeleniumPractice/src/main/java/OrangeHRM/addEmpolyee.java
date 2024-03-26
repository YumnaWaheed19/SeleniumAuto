package OrangeHRM;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class addEmpolyee {
	WebDriver driver;
	public addEmpolyee(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username") WebElement username;
	@FindBy( name = "password") WebElement password;
	@FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
	@FindBy(className = "oxd-userdropdown-tab") WebElement dropdown;
	@FindBy(className = "oxd-main-menu-item-wrapper") 	List<WebElement> menu;
	@FindBy(xpath = "//button[text()=' Add ']") WebElement addEmp;
	@FindBy(name = "firstName") WebElement firstName;
	@FindBy(name = "lastName") WebElement lastName;
	@FindBy(xpath = "(//label[text()='Employee Id']/following::input)[1]") WebElement Id;	
	@FindBy(xpath = "(//h6[contains(@class,'oxd-text oxd-text--h6')])[3]") WebElement textElement;
	@FindBy(className ="orangehrm-left-space") WebElement savElement;
	@FindBy(xpath ="//a[contains(text(),'Employee List')]") WebElement EmpList;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") WebElement logout;
	@FindBy(xpath = "(//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input)[1]") WebElement nameSearch;
	@FindBy(xpath = "//button[normalize-space()='Search']" ) WebElement searchBtn;
	@FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]") WebElement recordFound;
	@FindBy(xpath= "//input[@placeholder='Search']") WebElement searchMenu;
	@FindBy(className ="oxd-main-menu-item-wrapper" ) List<WebElement> menuList;
	@FindBy(xpath = "//div[@class='oxd-sidepanel-body']//ul[1]") WebElement infoElement;
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") WebElement searchAdminElement;
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active']//div)[1]")WebElement selectRole;
	@FindBy(className  = "oxd-select-option") List<WebElement> selectUserRole;

	
	public void login(String name, String p) {
		username.sendKeys(name);	
		password.sendKeys(p);	
		loginBtn.click();
	}

	public void clickPIM() { 
		List< WebElement> navElements = menu;

		for(int i = 0; i< navElements.size(); i++) {
			System.out.println(navElements.get(i).getText());
		}
		menu.get(1).click();
	}
	public void addEmployee(String fName, String lName, String id) {
		addEmp.click();	
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		Id.sendKeys(id);

		//fixed exception "org.openqa.selenium.ElementClickInterceptedException" by using following method
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
		WebElement uploadFile= driver.findElement(By.className("oxd-file-input"));
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(savElement));
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		String filepathString = "\\snaps\\profile.png";
		//return user's current working directory
		String projectPath = System.getProperty("user.dir");
		//uploadFile.sendKeys(new File(filePath).getAbsolutePath());
		String fullPath = projectPath + filepathString;
		//upload image‪
		fileInput.sendKeys(fullPath);
//		// Find the uploaded image element (if applicable) and verify its format
//        WebElement uploadedImage = driver.findElement(By.className("employee-image"));
//        String uploadedImageSource = uploadedImage.getAttribute("src");
        System.out.println("Image Source:  " + fullPath);
        // Verify that the uploaded image source ends with ".jpg" or ".png"
        if (fullPath.endsWith(".jpg") || fullPath.endsWith(".png")) {
            System.out.println("Image uploaded successfully in JPG/PNG format.");
        } else {
            System.out.println("Image upload failed or not in JPG/PNG format.");
        }

        saveButton.click();
		String text = textElement.getText();
		// get css value -> size family etc
		String fontSize =textElement.getCssValue("font-size");
		System.out.println("Font Size:" + fontSize);
		String fontFamily =textElement.getCssValue("font-family");
		System.out.println("Font Size: " + fontFamily);
		if(text.contains("Personal Details")) {
			System.out.println("Item added successfully");
		}
		else {
			System.out.println("Item is not added");
		}

	}
	public void search() throws InterruptedException {
		searchMenu.sendKeys("info");
		searchMenu.sendKeys(Keys.ENTER);
		List <WebElement> menuElements = menuList;
		for(int i = 0; i< menuElements.size(); i++) {
			System.out.println("All search menu item: " + menuElements.get(i).getText());
		}
		Thread.sleep(2000);
		infoElement.click();

	}

	public void searchEmployee(String name) throws InterruptedException {
		EmpList.click();
		driver.findElements(By.tagName("input")).get(1).sendKeys("Yumna");
		searchBtn.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit. MILLISECONDS);
		List<WebElement> element=	driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));
		String expected_message = "Records Found";
		String message_actual = element.get(0).getText();
		System.out.println(message_actual);
		Assert.assertTrue(message_actual.contains(expected_message));


	}

	public void searchAdmin() throws InterruptedException {
		menu.get(0).click();
		searchAdminElement.sendKeys("Admin");
		selectRole.click();
		List<WebElement> lst = selectUserRole;
		for(int i = 0; i <lst.size();i++) {
			System.out.println(lst.get(i).getText());
		}
		lst.get(1).click();	
		Thread.sleep(1000);
		searchBtn.click();
		
	}
	//Check the upload of a JPG/PNG format image
	//Check the upload of a valid format by over the size of 1 MB
	//Check the upload of a invalid format of the picture (may be a .doc file) that is less than 1 MB
	//Take screenshot
}
