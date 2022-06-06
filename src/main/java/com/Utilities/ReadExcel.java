package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static	XSSFWorkbook workbook;
	public static   XSSFSheet worksheet;
	public static   XSSFRow row;
	public static   XSSFCell cell;
	//String path=System.getProperty("user.dir")+"/src/main/java/com/Utilities/Exceldata.xlsx";
	public static FileInputStream fis;
	
	public static int getrowcount(String path,String worksheetname) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(worksheetname);
		int rowcount=worksheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
		
	}
	public static int getcellcount(String path,String worksheetname,int rownum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(worksheetname);
		//int rowcount=worksheet.getLastRowNum();
		int cellcount=worksheet.getRow(0).getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	
	}
	
	public static String getCellData(String path,String worksheetname,int rownum,int colnum) throws IOException
	{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		worksheet=workbook.getSheet(worksheetname);
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fis.close();
		return data;
		
	}
	
}
