package com.ui.test.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.test.utilities.Utilities;
import com.ui.test.configuration.HooksConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	private final HooksConfiguration hooks;
	private WebDriver driver;
	
	public LoginStepDef(HooksConfiguration hooks) {
		// TODO Auto-generated constructor stub
		this.hooks = hooks;
	}
	
	
	@Given("Launch Browser")
	public void launch_browser() {
	    System.out.println("Browser Launch Successfully. Executed from Method Block");
	}

	
	
	@Given("get Driver Instance")
	public void getDriverInstance() {
		this.driver = hooks.getDriver();		
	}

	
		@Then("Navigating {string}")
	public void navigating(String url) {
		this.driver.get(url);
		Assert.assertFalse(true);
	}

	
	@When("Navigate to {string}")
	public void navigate_to(String url) {		
		this.driver.get(url);
	}

}
