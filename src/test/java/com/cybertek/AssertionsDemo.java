package com.cybertek;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertionsDemo {
	@AfterMethod
	public void tearDownMethod(){
		System.out.println("garantees to run");
		//reporting, cleaning happens here
		}
@Test
public void testOne() {
	String a="ab";
	String b="bb";
	 System.out.println("asserting first");
	Assert.assertTrue(a.contains(b));//assertTrue takes a boolean parameter if it takes false value
	//then test fails
	//if assertion fails rest of the method does not run
	 System.out.println("asserted first");
}
@Test
public void tesTwo() {
	String a="abb";
	String b="bb";
	 System.out.println("asserting second");
	Assert.assertTrue(a.contains(b));
	 System.out.println("asserted second");
}
}
