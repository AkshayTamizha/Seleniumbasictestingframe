package com.reusablecomponent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel_Operations {
	
	String filepath;
	
	Sheet sh;
	
	public Excel_Operations(String sheetname)  {
		
		 try {
			filepath = System.getProperty("user.dir")+Properties_Operation.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		 File testdatafile = new File(filepath);
			
			Workbook wb = null;
			try {
				wb = WorkbookFactory.create(testdatafile);
			} catch (Exception e) {
				
				e.printStackTrace();
			} 
			 sh=wb.getSheet(sheetname);
			
	}
	
	
	public HashMap<String, String> getTestDataInMap(int rownum) throws Exception {
		
		// where is excel file
		
		File testdatafile = new File(filepath);
		
		Workbook wb = WorkbookFactory.create(testdatafile);
		Sheet sh=wb.getSheet("InsurancePremium");
		
		//sh.getRow(0).getCell(1).toString();
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for( int i = 0; i<sh.getRow(0).getLastCellNum(); i++) {
			
			sh.getRow(0).getCell(i).setCellType(CellType.STRING);
			
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rownum).getCell(i).toString());
		}
		
		return hm;
		
		//openfile=workbook
		//read data by row by row and put in map
	}
	//get row count
	public int getRowCount() {
		
		//int rowcount=sh.getLastRowNum(); instead of this shortcut below
		
		return sh.getLastRowNum();
	}
//get column count
	public int getColumnCount() {
		
		return sh.getRow(0).getLastCellNum();
		
	}
	
	
	
	
	
	
	
}
