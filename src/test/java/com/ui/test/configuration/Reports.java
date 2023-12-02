package com.ui.test.configuration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.utilities.Utilities;

public class Reports implements ITestListener {

		
	private ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		this.extentTest = this.extentReports.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SUCCESS) {
			Markup markup = MarkupHelper.createLabel(result.getName() + " is Passed", ExtentColor.GREEN);
			this.extentTest.log(Status.PASS, markup);
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.FAILURE) {
			Markup markup = MarkupHelper.createLabel(result.getName() + " is FAILED", ExtentColor.RED);
			this.extentTest.log(Status.FAIL, markup);
			this.extentTest.log(Status.FAIL, result.getThrowable());
			Utilities utilities = new Utilities();
			//this.extentTest.addScreenCaptureFromBase64String(utilities.getBase64(this.hooksConfiguration.getDriver()));
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		this.extentHtmlReporter = new ExtentHtmlReporter("./target/extentReport/extentReport.html");
		this.extentHtmlReporter.config().setDocumentTitle("Test");
		this.extentHtmlReporter.config().setReportName("Test");
		this.extentHtmlReporter.config().setTheme(Theme.DARK);
		this.extentReports = new ExtentReports();
		this.extentReports.attachReporter(this.extentHtmlReporter);
		this.extentReports.setSystemInfo("OS", "Windows");

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		this.extentReports.flush();
	}

}
