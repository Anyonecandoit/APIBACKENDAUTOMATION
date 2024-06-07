package com.test;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestExtentReport {

	
	@Test
	 public static void  extentTest() throws IOException {
		  
		  ExtentReports extent = new ExtentReports();
		 
		  final File CONF = new File("F:\\001-apitesting\\configfile.json");
		  ExtentSparkReporter spark = new ExtentSparkReporter("kranthi.html");
		  spark.loadJSONConfig(CONF);
//		final  File CONFIG = new File("F:\\001-apitesting\\extentconfig.xml");
//		  
//		  spark.loadXMLConfig(CONFIG);		  
//		  spark.config().setTheme(Theme.DARK);
//		  spark.config().setDocumentTitle("AutomationReport");
//		  
//		  spark.config().setReportName("Automation");
		  extent.attachReporter(spark);
		  
	ExtentTest test = 	  extent.createTest("login test").assignAuthor("kranthi").assignCategory("smoke").assignDevice("chrome");
		  test.pass("login test started sucessfully");
		  test.pass("url loaded");
		  
			ExtentTest test1 = 	  extent.createTest("homepage test").assignAuthor("kranthi").assignAuthor("bob").assignCategory("smoke").assignDevice("chrome");
		  test1.pass("logged in  sucessfully");
	
		  test1.fail("xxx");
		  
		  extent.flush();

	  }
}
