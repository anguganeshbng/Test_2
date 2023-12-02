package com.test.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.Scenario;

public class Utilities {

	private WebDriver driver;
	
	
	/*public WebDriver launchBrowser(String brname) {
		switch (brname) {
		case "chrome":
			this.driver =  new ChromeDriver();
			break;
		case "edge":
			this.driver =  new EdgeDriver();
			break;	
		default:
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		return driver;
	}*/
	
	public byte[] getScreenshotInBytes(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BYTES);		
	}
	
	public String getBase64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BASE64);		
	}
	
	public String getScreenshotFilePath(WebDriver driver, Scenario scenario) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFilePath = "./target/Screenshot/" + scenario.getName() + ".PNG";
		File destination = new File(destinationFilePath);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destinationFilePath;
	}
	

	
}
