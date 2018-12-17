package com.cybertek;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestThatDependEachother extends TestBase {
	@Test(priority=1)
	public void openThePage() {
		driver.get("http://google.com");
	}
	@Test(priority=2)
	public void search() {
		driver.findElement(By.name("q")).sendKeys("bla bla");
	}
}
