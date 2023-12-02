package com.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.page.details.Google;
import com.page.details.Yahoo;
import com.test.utilities.Utilities;

public class TestRunner2 {

	private WebDriver driver;
	private Utilities utilities;
	private Google google;
	private Yahoo yahoo;
	
	
	@BeforeClass
	public void launchBrowser() {
		this.utilities = new Utilities();
	//	this.driver = this.utilities.launchBrowser("chrome");
	}
	
	@Test
	public void navigateToTricy() {
	//	this.launchBrowser();
		System.out.println("Driver Instance for Trichy : " + this.driver);
		System.out.println("Thread : " + Thread.currentThread().getId());
		this.driver.get("https://www.nitt.edu");
	//	this.tearDown();
		
	}

	@Test
	public void navigateToWarangal() {
		//this.launchBrowser();
		System.out.println("Driver Instance for Warangal : " + this.driver);
		System.out.println("Thread : " + Thread.currentThread().getId());
		this.driver.get("https://www.nitw.ac.in/");
		//this.tearDown();
		
	}

	
	@AfterClass
	public void tearDown() {
	//	this.utilities.closeBrowser();
		System.out.println("Closing Thread : " + Thread.currentThread().getId());
	}
}
