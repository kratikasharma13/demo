package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	 static XSSFWorkbook wb;
//	 static XSSFSheet sheet1;
	private String data;
	static XSSFSheet Sheet1;
public 	ExcelDataConfig(String excelpath, String sheetName) {
	File src = new File(excelpath);
	FileInputStream fis;
	try {
		fis = new FileInputStream(src);
	
		wb = new XSSFWorkbook(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Sheet1 = wb.getSheet(sheetName);
}
public int getcolumnCount(String sheetName) {
	int col = Sheet1.getRow(0).getLastCellNum();
	return col;
}

public  static String getData(String  sheetname, int row, int column)
{
	Sheet1=	wb.getSheet(sheetname);
String data=	Sheet1.getRow(row).getCell(column).getStringCellValue();
	return data;
	}

public int getRowCount(int sheetname) {
int row=	wb.getSheetAt(sheetname).getLastRowNum();
row=row+1;
return row;
}

}