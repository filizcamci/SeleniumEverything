package com.cybertek;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
//or
//import org.testng.annotations.*; 

public class TestNGDemo {
	@BeforeClass
	public void setUpClass() {
		System.out.println("runs once before everythong in this class");
	}
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("runs before every method");
		
	}
	//@Ignore
	@Test
	public void testOne() {
		System.out.println("first one");
	}
	@Test
	public void testTwo() {
		System.out.println("second one");
		//to skip a test just comment out the @test or put @ignore before it
		//to run a test case come to the method click on it and run it
	}
	@AfterMethod
	public void tearDownMethod(){
		System.out.println("runs after each method");
		//reporting, cleaning happens here
		}
	 @AfterClass
	  public void tearDownClass() {
	    System.out.println("runs once after everything in this class");
	  }
}
