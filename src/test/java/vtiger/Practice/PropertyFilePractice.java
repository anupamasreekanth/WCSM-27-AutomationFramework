package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		//Step1:convert physical file into java readable object
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		//step2:create object of properties from java.util package
		Properties pObj=new Properties();
		//step3:Load the fileInput stream into properties
		pObj.load(fis);
		//step4:Access the values with keys
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		System.out.println(URL);
		System.out.println(USERNAME);
	}

}
