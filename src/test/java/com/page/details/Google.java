package com.page.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Google {

	private WebDriver driver;
	
	public Google(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[text()='Gmail']")
	private WebElement gmailLink;
	
	public void clickGmailLink() {
		this.gmailLink.click();
	}
	
	
}
