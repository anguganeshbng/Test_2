package com.ui.retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRun implements IRetryAnalyzer {

	public int minRetry;
	public static final int maxRetry = 2;

	public ReRun() {
		// TODO Auto-generated constructor stub
		this.minRetry = 0;
	}

	@Override
	public boolean retry(ITestResult result) {

		// TODO Auto-generated method stub
		if (this.minRetry < ReRun.maxRetry) {
			this.minRetry++;
			return true;
		}

		this.minRetry = 0;
		return false;

	}

}
