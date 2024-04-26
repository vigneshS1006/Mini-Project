package Alerts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadProperties {
	
	public static Properties readPropertiesFile() {//return property file with loaded file
		
		FileInputStream fis=null;		
	
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\alertHandle.properties";	
			
		try {
			fis=new FileInputStream(filePath);
		}
		
		catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}		
		
		Properties property=new Properties();		
		
		try {
			property.load(fis);//file loaded into properties object
		} 
		catch (IOException e2) {			
			e2.printStackTrace();
		}
		
		return property;	
			
		}
	
	@SuppressWarnings({ "resource" })
	public static String readExcel() {//reading the excel file 	
		
		FileInputStream file=null;
		String value = "";
		
		try {
			 file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\testData.xlsx");			 
			
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");			
			XSSFRow currentRow=sheet.getRow(1);
			XSSFCell cell=currentRow.getCell(0);
			value=cell.toString();
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}
		
		return value;		
	}
}
	


