package com.ui.test.configuration;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.http.entity.ContentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.model.Media;
import com.google.common.net.MediaType;
import com.test.utilities.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class HooksConfiguration {

	
	private WebDriver driver;
	private final Utilities utilities;
	
	public HooksConfiguration(Utilities utilities) {
		// TODO Auto-generated constructor stub
		this.utilities = utilities;
		
	}
	
	
	
	@Before
	public void launchBrowser() {
		//this.driver = utilities.launchBrowser("chrome");		
		String brname = "chrome";
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
		System.out.println("Thread ID : " + Thread.currentThread().getId());
	}
	
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshot(WebDriver driver) {
	    return utilities.getScreenshotInBytes(driver);
	}
	
	@After
	public void closeBrowser(Scenario scenario) {
		
		if(!scenario.getStatus().equals(Status.PASSED)) {	
			//utilities.getScreenshotFilePath(driver, scenario);
			scenario.attach(utilities.getScreenshotInBytes(driver), "image/png", "Cucumber Attachement : " + scenario.getName());
			Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(utilities.getBase64(driver), scenario.getName()).build();
			ExtentCucumberAdapter.getCurrentStep().log(com.aventstack.extentreports.Status.FAIL, media);
			Allure.addAttachment("Screenshot for failure scenario - Allure Attachment : " + scenario.getName(), new ByteArrayInputStream(this.saveScreenshot(driver)));
		//	ExtentCucumberAdapter.getCurrentScenario().lo
		}
		
		if(this.driver != null) {
			this.driver.close();
			this.driver.quit();
			this.driver = null;
		}
	}
}
