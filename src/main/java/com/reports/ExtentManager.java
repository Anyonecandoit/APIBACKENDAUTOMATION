package com.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	
	
	public static ThreadLocal<ExtentTest> extenttest =  new ThreadLocal<>(); 
	
	
	public static ExtentTest  getTest() {
		
		return extenttest.get();
		
	}


	 static void setExtent(ExtentTest test){
		 extenttest.set(test);
	    }
}
