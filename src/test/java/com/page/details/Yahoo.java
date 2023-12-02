package com.page.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Yahoo {

	private WebDriver driver;
	
	public Yahoo(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@id='ybar-sbq']")
	private WebElement inputBox;
	
	public void enterData() {
		this.inputBox.sendKeys("Test");
	}
	
	
}
