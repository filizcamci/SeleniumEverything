package com.cybertek;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TabWindowExample extends TestBase {
	@Test
	public void switchToWindow() {
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getTitle());
		String firstWindow = driver.getWindowHandle();
		System.out.println(firstWindow);
		Set<String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles);
		for(String handle: windowHandles) {
			if(!handle.equals(firstWindow)) {
				driver.switchTo().window(handle);
				}
		}
		System.out.println(driver.getTitle());
	}
	@Test
	public void switchByTitleTest() {
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		String expectedTitle="New Window";
		
		switchByTitle(expectedTitle);
		
		assertEquals(driver.getTitle(),expectedTitle,"titles do not match");
	}
}
