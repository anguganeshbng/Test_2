package com.ui.test.runner;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberPropertiesProvider;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(

		features = "./Features", 
		glue = { "com.ui.test.steps",
				"com.ui.test.configuration" },
		tags = "@NavigateToGoogle", 
		dryRun = false, 
		monochrome = true, 
		plugin = { "pretty",
				   "html:target/CucumberHTML/cucumberReport.html",
				   "json:target/CucumberJson/cucumberJsonReport.json",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"	
				 }, 
		publish = false

)

public class TestNGRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
