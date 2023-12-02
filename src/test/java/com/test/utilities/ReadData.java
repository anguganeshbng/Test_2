package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadData {

	public static FileInputStream fis;
	public static Workbook wb;
	public static Sheet sh;

	static {
		try {
			fis = new FileInputStream("./ExcelFileLocation/Book.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sh = wb.getSheet("Sheet1");
	}

	@DataProvider(name = "readExcel")
	public String[][] readExcelData(Method method) {

		String tcName = method.getName();
		int rowCount = this.getTotalRowsWithRunModeAsY(tcName);
		int columnCount = this.getTotalColumnsWithRunModeAsY(tcName);

		String[][] inputData = new String[rowCount][columnCount];

		for (int row = 1, r = 0; row < sh.getPhysicalNumberOfRows(); row++) {
			String testCaseName = sh.getRow(row).getCell(0).getStringCellValue();
			String runMode = sh.getRow(row).getCell(1).getStringCellValue();

			if (testCaseName.equalsIgnoreCase(tcName) && runMode.equalsIgnoreCase("y")) {
				for (int column = 2, c = 0; column < sh.getRow(row).getPhysicalNumberOfCells(); column++, c++) {
					inputData[r][c] = sh.getRow(row).getCell(column).getStringCellValue();
				}
				r++;
			}
		}

		return inputData;

	}

	@DataProvider(name = "readExcelUsingMap")
	public Iterator<Object> readExcelDataUsingMap(Method method) {

		String tcName = method.getName();
		List<Object> inputDataList = new ArrayList<>();	

		for (int row = 1; row < sh.getPhysicalNumberOfRows(); row++) {
			String testCaseName = sh.getRow(row).getCell(0).getStringCellValue();
			String runMode = sh.getRow(row).getCell(1).getStringCellValue();

			if (testCaseName.equalsIgnoreCase(tcName) && runMode.equalsIgnoreCase("y")) {
				Map<String, String> inputData = new HashMap<>();
				for (int column = 2; column < sh.getRow(row).getPhysicalNumberOfCells(); column++) {
					String key = sh.getRow(0).getCell(column).getStringCellValue();
					String value = sh.getRow(row).getCell(column).getStringCellValue();
					inputData.put(key, value);
				}
				inputDataList.add(inputData);
			}
		}

		return  inputDataList.iterator();

	}

	public int getTotalRowsWithRunModeAsY(String methodName) {
		int rowCount = 0;
		for (int row = 1; row < sh.getPhysicalNumberOfRows(); row++) {
			String tcName = sh.getRow(row).getCell(0).getStringCellValue();
			String runMode = sh.getRow(row).getCell(1).getStringCellValue();
			if (tcName.equalsIgnoreCase(methodName) && runMode.equalsIgnoreCase("y"))
				rowCount++;
		}

		return rowCount;
	}

	public int getTotalColumnsWithRunModeAsY(String methodName) {
		int columnCount = 0;
		for (int row = 1; row < sh.getPhysicalNumberOfRows(); row++) {
			String tcName = sh.getRow(row).getCell(0).getStringCellValue();
			String runMode = sh.getRow(row).getCell(1).getStringCellValue();
			if (tcName.equalsIgnoreCase(methodName) && runMode.equalsIgnoreCase("y")) {
				columnCount = sh.getRow(row).getPhysicalNumberOfCells() - 2;
				break;
			}

		}

		return columnCount;
	}

}
