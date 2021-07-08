package com.CleverTap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QOEMatrix {
	
	static String xlpath = System.getProperty("user.dir") + "\\Performance\\performance.xlsx";
	static int LastRow = 0;
	
	
	public static void creatExcelPerformance() {
		try {
			File dir = new File(System.getProperty("user.dir") + "\\Performance");
			if (!dir.isDirectory()) {
				dir.mkdir();
			}
			File file = new File(xlpath);
			if (!file.exists()) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				workbook.createSheet("Performance");
				FileOutputStream fos = new FileOutputStream(new File(xlpath));
				workbook.write(fos);
				workbook.close();
				XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(xlpath));
				XSSFSheet sheet = workbook1.getSheetAt(0);
				XSSFRow xrow = sheet.getRow(0);
				if (xrow == null) {
					xrow = sheet.createRow(0);
				}
				Cell cell = null;
				if (cell == null) {
					cell = xrow.createCell(1);
					cell.setCellValue("Scenario");
					cell = xrow.createCell(2);
					cell.setCellValue("Time Taken (Sec)");
					cell = xrow.createCell(3);
					cell.setCellValue("App Native Heap Memory");
					cell = xrow.createCell(4);
					cell.setCellValue("App Total Memory");
					cell = xrow.createCell(5);
					cell.setCellValue("CPU Usage");
					cell = xrow.createCell(6);
					cell.setCellValue("GPU Memory");
					cell = xrow.createCell(7);
					cell.setCellValue("GPU FPS");
					cell = xrow.createCell(8);
					cell.setCellValue("App Traffic usage");
				}
				FileOutputStream outputStream = new FileOutputStream(xlpath);
				workbook1.write(outputStream);
				workbook1.close();
				outputStream.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public static void InsertEventProperties(int row,String scenario,int Timetaken,int HeapMemo,int TotalMemo,int CPUUsage
			,int GPUUsage, double GPUFPS, int TrafficUsage){
			try {
				File file = new File(xlpath);
				if (file.exists()) {
					XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlpath));
					XSSFSheet sheet = workbook.getSheetAt(0);
					XSSFRow xrow = sheet.getRow(row);
					if (xrow == null) {
						xrow = sheet.createRow(row);
					}
					Cell cell = null;
					if (cell == null) {
						if(scenario.equals("Login1")) {
							XSSFRow row1 = sheet.getRow(0);
							cell = row1.createCell(0);
							cell.setCellValue((getCellValue(0,0)+1));
						}
						cell = xrow.createCell(1);
						cell.setCellValue(scenario);
						cell = xrow.createCell(2);
						cell.setCellValue(Timetaken);
						cell = xrow.createCell(3);
						cell.setCellValue(HeapMemo);
						cell = xrow.createCell(4);
						cell.setCellValue(TotalMemo);
						cell = xrow.createCell(5);
						cell.setCellValue(CPUUsage);
						cell = xrow.createCell(6);
						cell.setCellValue(GPUUsage);
						cell = xrow.createCell(7);
						cell.setCellValue(GPUFPS);
						cell = xrow.createCell(8);
						cell.setCellValue(TrafficUsage);
					}
					FileOutputStream outputStream = new FileOutputStream(xlpath);
					workbook.write(outputStream);
					workbook.close();
					outputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public static void AddFormulaToCell() throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(xlpath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow xrow = sheet.getRow(73);
		if (xrow == null) {
			xrow = sheet.createRow(73);
		}
		Cell cell = null;
		if (cell == null) {
			cell = xrow.createCell(2);
			cell.setCellFormula("SUM(C2,C7,C12,C17,C22,C27,C32,C37,C42,C47)/10");
			cell = xrow.createCell(3);
			cell.setCellFormula("SUM(D2,D7,D12,D17,D22,D27,D32,D37,D42,D47)/10");
			cell = xrow.createCell(4);
			cell.setCellFormula("SUM(E2,E7,E12,E17,E22,E27,E32,E37,E42,E47)/10");
			cell = xrow.createCell(5);
			cell.setCellFormula("SUM(F2,F7,F12,F17,F22,F27,F32,F37,,F42,F47)/10*100");
			cell = xrow.createCell(6);
			cell.setCellFormula("SUM(G2,G7,G12,G17,G22,G27,G32,G37,,G42,G47)/10");
			cell = xrow.createCell(7);
			cell.setCellFormula("SUM(H2,H7,H12,H17,H22,H27,H32,H37,,H42,H47)/10");
			cell = xrow.createCell(8);
			cell.setCellFormula("SUM(I6,I11,I16,I21,I26,I31,I36,I41,,I46,I51)/10");
		}
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		evaluator.evaluateAll();
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(xlpath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	static ArrayList<String> performaceDetails = new ArrayList<String>();

	public static void insertToExcel() {
		LastRow = getRowCount();
		if (performaceDetails.size() > 0) {
			for (int i = 0; i < performaceDetails.size(); i++) {
				int row = getRowCount();
				String result[] = performaceDetails.get(i).toString().split(",");
				InsertEventProperties((row+1), result[0], Integer.valueOf(result[1]), Integer.valueOf(result[2]), 
						Integer.valueOf(result[3]), Integer.valueOf(result[4]), Integer.valueOf(result[5]), Double.parseDouble(result[6]),
								Integer.valueOf(result[7]));
			}
		} else {
		}
	}
	
	public static int getRowCount() {
		int rc = 0;
		try {
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheetAt(0);
			rc = s.getLastRowNum();
		} catch (Exception e) {
		}
		return rc;
	}
	
	public static int getCellValue(int row, int col) {
		int data = 0;
		try {
			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
			XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
			data = (int)myExcelSheet.getRow(row).getCell(col).getNumericCellValue();
			myExcelBook.close();
		} catch (Exception e) {
		}
		return data;
	}
	
	public static void main(String[] args) throws IOException {
//		creatExcelPerformance();
//		insertToExcel();
//		System.out.println(VerifyIteration());
		System.out.println("Done");
	}
	
	public static void clearOldData() {
		 File file = new File(xlpath);
	        file.delete();
	}
	
	public static boolean VerifyIteration() {
		int data = 0;
		try {
			XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(xlpath));
			XSSFSheet myExcelSheet = myExcelBook.getSheetAt(0);
			data = (int)myExcelSheet.getRow(0).getCell(0).getNumericCellValue();
			myExcelBook.close();
			if(data != 10) {
				return true;
			}else {
				AddFormulaToCell();
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
//	performaceDetails.add("Login1"+",12,30,349,5,38,67.12,1243");
//	performaceDetails.add("Login2"+",12,30,349,5,38,67.23,1243");
//	performaceDetails.add("Login3"+",12,30,349,5,38,67.54,1243");
//	performaceDetails.add("Login4"+",12,30,349,5,38,67.89,1243");
	
}
