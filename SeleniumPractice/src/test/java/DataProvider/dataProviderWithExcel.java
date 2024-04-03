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

public class dataProviderWithExcel {


	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}
	
	@Test(dataProvider = "getExcelData")
	public void openGoogle(String keyword) {
		WebElement searchElement=driver.findElement(By.name("q"));
		searchElement.sendKeys(keyword);
		searchElement.sendKeys(Keys.ENTER);
	}

	@DataProvider(name="getExcelData")
	public Object[][] excelData() throws IOException{
		File filePath=new File(".\\Files\\Search.xlsx");
			String excelFile =filePath.getAbsolutePath();
			Object[][] searchdata= getExcelData(excelFile, "Sheet1");
			return searchdata;
		
	}
	
	public String[][] getExcelData(String filename, String sheetName) throws IOException{
		String[][] data= null;	 //two-dimensional array
		try {
			//Create object of fileinputStream to read data from file
			FileInputStream inputStream= new FileInputStream(filename);
			XSSFWorkbook workbook =new XSSFWorkbook(inputStream);
			XSSFSheet sheet= workbook.getSheet(sheetName);

			int totalRows= sheet.getLastRowNum() +1;  // count my number of Rows
			int totalCells =sheet.getRow(0).getLastCellNum(); // get last ColNum 
			System.out.println(totalCells);
			data= new String[totalRows-1][totalCells];
			for(int currentRow=1;currentRow<totalRows; currentRow++){
				for(int currentCell=0;currentCell<totalCells;currentCell++) {
					data[currentRow-1][currentCell]= sheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
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
