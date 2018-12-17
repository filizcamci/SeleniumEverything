package com.cybertek;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupExamples extends TestBase {

	@Test
	public void jsAlertTest() {
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("(//button)[1]")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		//click ok on alert
		alert.accept();
		
		driver.findElement(By.xpath("(//button)[2]")).click();
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		//clicking cancel on alert
		alert.dismiss();
		
		driver.findElement(By.xpath("(//button)[3]")).click();
		alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("hello");
		alert.accept();
		
		//verifying alert is present
		try {
			Alert alert1=driver.switchTo().alert();
		}catch(NoAlertPresentException e) {
			Assert.fail("alert not present");
		}
	}
	@Test
	public void htmlPopup() {
		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		//driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
		assertTrue(driver.findElement(By.xpath("//span[.='No']")).isDisplayed());
		
		
		//below alert does not work on html alerts
		//Alert alert=driver.switchTo().alert();
		//alert.dismiss();
		driver.findElement(By.xpath("//span[.='No']")).click();
		
	}
}
