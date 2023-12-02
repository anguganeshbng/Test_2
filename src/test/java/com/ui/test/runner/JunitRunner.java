package com.ui.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(
		
		features = "./Features",
		glue = {"com.ui.test.steps",
			    "com.ui.test.configuration"},
		tags = "@NavigateToGoogle",
		dryRun = false,
		monochrome = true,
		plugin = {
				   "pretty",	
				   "html:target/CucumberHTML/cucumberReport.html",
				   "json:target/CucumberJson/cucumberJsonReport.json",
				   "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				   },
		publish = false		
		
		
		)




public class JunitRunner {

	
	
}

