package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel sheet
 * @author sreek
 * 
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on row and cell value
	 * @param SheetName
	 * @param rowNum
	 * @param celNo
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException
	 * *throws IOException
	 */
	public String readDataFromExcel(String SheetName,int rowNo,int celNo) throws IOException
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(SheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
		wb.close();
		return value;
				}
	
	/**
	 * This method will get the total rows utilized
	 * @param sheet
	 * @return
	 * @throws FileNotFoundException 
	 * @throws encrypted document exception
	 * @throws IOexception
	 */
	public int getRowCount(String SheetName) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	
	
	
	
	/**
	 * This method will write data into excel
	 * @param SheetName
	 * @param rowNo
	 * @param value
	 * @param EncryptedDocumentException
	 * @param IOException
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * 
	 */
	
	public void writeDataIntoExcel(String SheetName,int rowNum,int celNo,String value) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row rw=sh.createRow(rowNum);
		Cell cel=rw.createCell(celNo);
		cel.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	/*
	 * This method will read data from excel sheet and return it to data provider
	 * @param sheetname
	 * @return
	 * @throws IOException
	 * 
	 */
	public Object[][] readDatafromExcelToDataProvider(String SheetName) throws IOException 	{
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
				
	}
	
	
	
	
	
}
