package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	public static void main(String[] args) throws IOException {
		
		ReadExcelData readexcel = new ReadExcelData();
		String value = readexcel.getMapData("Naresh1");
	System.out.println(value);
		
	}
	
	public static  Map<String, Map<String, String>> readExcel() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\Demosheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet =workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		  
		  Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
		  
		  Map<String, String> dataMap = new HashMap<String, String>();
		  
		  //Looping over entire row
		  for(int i=0; i<=lastRow; i++){
			  
			  Row row = sheet.getRow(i);
			  
			  //1st Cell as Value
			  Cell valueCell = row.getCell(1);
				  
			  //0th Cell as Key
			  Cell keyCell = row.getCell(0);
				  
			  String value = valueCell.getStringCellValue().trim();
			  String key = keyCell.getStringCellValue().trim();
				  
			  //Putting key & value in dataMap
			  dataMap.put(key, value);
				  
			  //Putting dataMap to excelFileMap
			  excelFileMap.put("DataSheet", dataMap);
		  }
		  
		 //Returning excelFileMap
		return excelFileMap;

	}
	
	//Method to retrieve value
	public static String getMapData(String key) throws IOException{

		Map<String, String> m = readExcel().get("DataSheet");
		String value = m.get(key);
		
		return value;
		
	}

}
