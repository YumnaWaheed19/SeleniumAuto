package DataDrivenTesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataDrivenTestingExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFSheet sheet;
		XSSFWorkbook workbook = null;
//		XSSFRow row;
//		XSSFCell cell;

		//create an object of file class to open file 
		//	String filepath=System.getProperty("user.dir");
		File excelFile =new File("C:\\Users\\kjkj\\Downloads\\TestData.xlsx");

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
		
		
//		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
		int totalRows= sheet.getLastRowNum()+1;
		int totalCells =sheet.getRow(0).getLastCellNum();
		
		for(int currentRow=0;currentRow<totalRows; currentRow++){
			for(int currentCell=0;currentCell<totalCells;currentCell++) {
				System.out.println(sheet.getRow(currentRow).getCell(currentCell).toString());
				System.out.println("\t");
				
			}
			System.out.println("\n");
		}
		

	}

}
