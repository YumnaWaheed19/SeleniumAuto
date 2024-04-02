package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;


//Data Driven testing is test automation framework that store data in spreadsheet and table format
public class DataDrivenTestingExp {

	public static void main(String[] args) throws InterruptedException {
		//Excel -> Workbook -> sheet -> row -> cell 
		XSSFSheet sheet;
		XSSFWorkbook workbook = null;
		//XSSFRow row;
		//XSSFCell cell;

		//create an object of file class to open file 
		File excelFile =new File("./Files/TestData.xlsx");

		//Create object of fileinputStream to read data from file
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Excel -> Workbook -> sheet ->row->cell 
		try {
			workbook=new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
		int totalRows= sheet.getLastRowNum()+1;
		int totalCells =sheet.getRow(0).getLastCellNum();

		for(int currentRow=1;currentRow<totalRows; currentRow++){
			//			for(int currentCell=1;currentCell<totalCells;currentCell++) {
			//				System.out.println(sheet.getRow(currentRow).getCell(currentCell).toString());
			//				System.out.println("\t");
			//				
			//			}
			//			System.out.println("\n");

			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxDriver driver= new FirefoxDriver();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(currentRow).getCell(0).toString());
			driver.findElement(By.id("password")).sendKeys(sheet.getRow(currentRow).getCell(1).toString());
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
		}




	}

}
