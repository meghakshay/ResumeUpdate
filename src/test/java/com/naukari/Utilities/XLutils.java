package com.naukari.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLutils {
		public static FileInputStream fin;
		public static FileOutputStream fout;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws; 
		public static XSSFRow row;
		public static XSSFCell cell;
		
	public static int getRowCount(String xlfile, String sheet) throws IOException {
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(sheet);
		int totalrow = ws.getLastRowNum();
		wb.close();
		fin.close();
		
		return totalrow;
		
	}	
	
	public static int getCellCouunt(String xlfile, String sheet, int rownum) throws IOException {
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fin.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String sheet, int rownum, int cellnum) throws IOException {
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(sheet);
		row = ws.getRow(rownum);
		cell = row.getCell(cellnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return  cellData;
		} catch (Exception e) {
			data = " ";
		}
		wb.close();
		fin.close();
		return data;
	}
	
	public static void setCellData(String xlfile, String sheet,String data[]) throws IOException {
		fin = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fin);
		ws = wb.getSheet(sheet);
		int rowCount = ws.getLastRowNum()-ws.getFirstRowNum();
		System.out.println("rowCount="+rowCount);
		XSSFRow row = ws.getRow(0);
		XSSFRow newRow=ws.createRow(rowCount+1);
		System.out.println("newRow="+newRow);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell cell = newRow.createCell(i);
			
			cell.setCellValue(data[i]);
		}

//		row = ws.getRow(rownum);
//		cell = row.getCell(cellnum);
//		cell.setCellValue(data);
		fout = new FileOutputStream(xlfile);
		wb.write(fout);
		wb.close();
		fin.close();
		fout.close();
		
	}

}
