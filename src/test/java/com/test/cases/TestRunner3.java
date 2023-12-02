package com.test.cases;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import com.test.utilities.ReadData;

public class TestRunner3 {

	
	/*@Test(dataProvider =  "readExcel", dataProviderClass = ReadData.class)
	public void login(String[] inputData) {
		
		String username = inputData[0];
		String password = inputData[1];
		
		System.out.println("Username : " + username);
		System.out.println("Password : " + password);
		Arrays.toString(inputData);
		
	}*/
	
	@Test(dataProvider =  "readExcelUsingMap", dataProviderClass = ReadData.class)
	public void login(Object inputDataObject) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> inputData =  (Map<String, String>) inputDataObject;		
		inputData.keySet().forEach(eachKey -> System.out.println(eachKey + " : " + inputData.get(eachKey)));		
	}
}
