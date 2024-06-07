package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	private static ExtentTest test;  //thread safe --> ThreadLocal
	  private static ExtentReports extent;
	  
	  public static void  initReports() {
		  
		
		  ExtentSparkReporter spark = new ExtentSparkReporter("kranthi.html");
		  spark.config().setTheme(Theme.DARK);
		  spark.config().setDocumentTitle("AutomationReport");
		  extent = new ExtentReports();
		  extent.attachReporter(spark);

	  }
	  
	  
	  public static void teardownreports() {
		  
		  extent.flush();
	  }
	  
	  public static void createTest(String name) {
		  
		 test =  extent.createTest(name );
		 ExtentManager.setExtent(test);
	  }
	  
	  
	  public static void addAuthor(String[] authors) {
		  
		  for(String author: authors )
		  ExtentManager.getTest().assignAuthor(author);
		  
	  }
	  
	  public static void addCategory(String[] categories){
	        for(String category:categories) {
	            ExtentManager.getTest().assignCategory(category);
	        }
	  
}}
