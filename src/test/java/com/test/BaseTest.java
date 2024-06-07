package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class BaseTest  {

	
	@BeforeSuite
	public void setUpSuite() {
		
		
		
	}
	
	@AfterSuite
public void tearDownSuite() {
		
		
		
	}
@BeforeMethod
public void setUp() {
	
	
	
}
	
@AfterMethod
public void teardown() {
	
	
	
}
}
