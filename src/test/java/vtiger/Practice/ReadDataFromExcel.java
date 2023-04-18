package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//STEP1:OPEN THE DOCUMENT IN JAVA READABLE FORMAT
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				//STEP2:CREATE A WORKBOOK
				Workbook wb=WorkbookFactory.create(fis);
				//STEP3:GET CONTROL OF SHEET
				Sheet sh=wb.getSheet("Contacts");
				//STEP4:GET CONTROL OF ROW
				Row rw=sh.getRow(4);
				//STEP5:GET CONTROL OF CELL
				Cell ce=rw.getCell(1);
				//STEP6:READ THE DATA INSIDE THE CELL
				String Value=ce.getStringCellValue();
				System.out.println(Value);

	}

}
