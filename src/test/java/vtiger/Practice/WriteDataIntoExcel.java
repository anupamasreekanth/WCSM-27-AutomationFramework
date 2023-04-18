package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws IOException {
		//STEP1:OPEN THE DOCUMENT IN JAVA READABLE FORMAT
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//STEP2:CREATE A WORKBOOK
		Workbook wb=WorkbookFactory.create(fis);
		//STEP3:GET CONTROL OF SHEET
		Sheet sh=wb.getSheet("Contacts");
		//STEP4:GET CONTROL OF ROW
		Row rw=sh.getRow(4);
		//STEP5:CREATE A CELL IN THAT ROW
		Cell ce=rw.createCell(9);
		//STEP6:SET VALUE TO THE CELL
		ce.setCellValue("ANU");
		//STEP7:OPEN THE DOCUMENT IN WRITE MODE
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		//STEP8:WRITE THE DATA
		wb.write(fos);
		System.out.println("data added");
		

	}

}
