package Alerts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.net.SocketException;

public class Main {
	
	@SuppressWarnings({ })
	public static void main(String[] args)  {
		
		PrintStream ps=null;
				
		try {
			HandleAlerts ha=new HandleAlerts();
			
			ha.setUpDriver();
			ha.navigation();
			String res1=ha.alertWithOk();
			String res2=ha.alertWithOkAndCancel();
			String res3=ha.alertWithTextbox();
			ha.close();
			
			ps=new PrintStream(new File(System.getProperty("user.dir")+"\\Console.txt"));
			ps.print(res1);			
			ps.print(res2);			
			ps.print(res3);		
			
			FileOutputStream file=new FileOutputStream(new File(System.getProperty("user.dir")+"\\ConsoleOutput.xlsx"));
			
			XSSFWorkbook workbook=new XSSFWorkbook();
			XSSFSheet sheet=workbook.createSheet("Alert details");
			
			String[] consoleOutput= {res1,res2,res3};
			
			int rowNum=0;
			
			for(String l:consoleOutput) {
				
				XSSFRow row=sheet.createRow(rowNum++);
				XSSFCell cell=row.createCell(0);
				cell.setCellValue(l);
			}
			
			workbook.write(file);
			workbook.close();
			file.close();		
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
				
	}

}
