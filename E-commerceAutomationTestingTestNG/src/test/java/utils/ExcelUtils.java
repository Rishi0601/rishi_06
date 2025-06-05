package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileOutputStream fileout;
	public static XSSFRow row;
	public static XSSFCell col;
	public static int rowvalue;
	public static int colvalue;

	public static String readdata(String filepath, String sheetname, int rownumber, int colnumber){
		try {
			file = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownumber);
		col = row.getCell(colnumber);
		String value;
		try {
			DataFormatter d = new DataFormatter();
			value = d.formatCellValue(col);
			return value;
		} catch (Exception e) {
			value = "";
		}
		try{
			workbook.close();
			file.close();
		} catch(IOException e){}
		return value;
	}

	// public static String readdata(String filePath, String sheetName, int rowNum, int colNum) {
    // 	FileInputStream fis=null;
	// 	List<List<String>> mainList=new ArrayList<>();
	// 	File file = new File(filePath);
	//      try {
	// 	 	fis = new FileInputStream(file);
	//   } catch (FileNotFoundException e) {
	// 	 e.printStackTrace();
	// 	 }
	// 	XSSFWorkbook workbook = null;
	// 	try {
	// 		workbook = new XSSFWorkbook(file);
	// 		XSSFSheet sheet = workbook.getSheet(sheetName);
	// 		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
	// 			XSSFRow row = sheet.getRow(i);
	// 			List<String> list=new ArrayList<>();
	// 			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
	// 				list.add(row.getCell(j).getStringCellValue());
	// 			}
	// 			mainList.add(list);
	// 		}
	// 		workbook.close();
	// 	} catch (Exception e) {
	// 	}
	//     return mainList.get(rowNum).get(colNum);
    //  }

	public static void writedata(String filepath, String sheetname, int rownumber, int colnumber, String value){
		try {
			file = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rownumber);
		col = row.getCell(colnumber);
		col.setCellValue(value);
		try {
			fileout = new FileOutputStream(filepath);
			workbook.write(fileout);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try{
			workbook.close();
			file.close();
			fileout.close();
		} catch(IOException e){}
	}
}


