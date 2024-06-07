package com.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class TestListener implements ITestListener, ISuiteListener {

	
	
	@Override
	 public void onTestStart(ITestResult result) {
		System.out.println("test started");
	
		ExtentReport.createTest(result.getName());
		  }

	@Override
		  public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed");
		  }

	@Override
		  public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getName() + " is failed");
		  }

	@Override
	  public void onStart(ISuite suite) {
		
		System.out.println("reports intitiating");
		ExtentReport.initReports();
		  } 

		
	@Override
		  public  void onFinish(ISuite suite) {
		ExtentReport.teardownreports();
		  }
}
