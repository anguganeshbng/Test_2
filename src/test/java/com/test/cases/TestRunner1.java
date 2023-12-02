package com.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.page.details.Google;
import com.page.details.Yahoo;
import com.test.utilities.Utilities;

public class TestRunner1 {

	private WebDriver driver;
	private Utilities utilities;
	private Google google;
	private Yahoo yahoo;
	
	
	@BeforeClass
	public void launchBrowser() {
		this.utilities = new Utilities();
		//this.driver = this.utilities.launchBrowser("chrome");
	}
	
	@Test
	public void navigateToGoogle() {
	//	this.launchBrowser();
		System.out.println("Driver Instance for Google : " + this.driver);
		System.out.println("Thread : " + Thread.currentThread().getId());
		this.driver.get("https://www.google.com");
		this.google = PageFactory.initElements(driver, Google.class);		
		this.google.clickGmailLink();
	//	this.tearDown();
		
	}

	@Test
	public void navigateToYahoo() {
		//this.launchBrowser();
		System.out.println("Driver Instance for Yahoo : " + this.driver);
		System.out.println("Thread : " + Thread.currentThread().getId());
		this.driver.get("https://www.yahoo.com");
		this.yahoo = PageFactory.initElements(driver, Yahoo.class);		
		this.yahoo.enterData();
		//this.tearDown();
	}

	
	@AfterClass
	public void tearDown() {
		// this.utilities.closeBrowser();
		System.out.println("Closing Thread : " + Thread.currentThread().getId());
	}
}
