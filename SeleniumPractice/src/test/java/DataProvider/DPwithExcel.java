package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPwithExcel {

	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
	}

	@Test(dataProvider  = "login")
	public void login(String Username, String Password) {
		WebElement uname=driver.findElement(By.id("user-name"));
		uname.sendKeys(Username);
		WebElement pass= driver.findElement(By.id("password"));
		pass.sendKeys(Password);
		WebElement login= driver.findElement(By.id("login-button"));
		login.sendKeys(Keys.ENTER);

	}
	@DataProvider(name="login")
	public Object[][] loginData() throws IOException{
		File file= new File("./Files/TestData.xlsx");
		String filePath= file.getAbsolutePath();
		Object[][] loginInfo= getExcelData(filePath, "Sheet1");
		return loginInfo;	
	}

	public String[][] getExcelData(String filePath, String sheetName) throws IOException{
		String data[][]=null;
		try {
			//create object of fileInputStream to read file
			FileInputStream inputStream=new FileInputStream(filePath);

			//workbook -> Sheet ->row -> cell
			XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
			XSSFSheet sheet= workbook.getSheet(sheetName);

			//get total no. of rows -> count number of Rows
			int ttlRows= sheet.getLastRowNum()+1; 

			//get total no of cells -> get my Row which start from 0 and last ColNum 
			int ttlCells= sheet.getRow(0).getLastCellNum();

			data= new String[ttlRows-1][2];
			System.out.println(new String[ttlRows-1][2]);
			for(int currentRow=1;currentRow<ttlRows;currentRow++) {
				for(int currentCell=0;currentCell<2;currentCell++) {
					System.out.println(currentRow +" " + currentCell);
					data[currentRow-1][currentCell]= sheet.getRow(currentRow).getCell(currentCell).toString();
					System.out.println(data[currentRow-1][currentCell]);
				}

			}
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
}
