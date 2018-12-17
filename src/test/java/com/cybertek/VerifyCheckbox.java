package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Verify checkbox functionality
 * 1.Open browser
 * 2.Go to http://the-internet.herokuapp.com/checkboxes
 * 3.Verify that the first checkbox is not selected
 * 4.Verify that the second checkbox is selected
 * 5.Click on the first checkbox
 * 6.Verify that the first checkbox is selected
 * 7.Verify that the second checkbox is selected
 * 8.Clickon the second checkbox
 * 9.Verify that the first checkbox is selected10.Verify that the second checkbox is not selected
 */
public class VerifyCheckbox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		//WebElement firstone = driver.findElement(By.tagName("input")); //it finds the first element with tagname "input"
		//WebElement firstone=driver.findElement(By.xpath("//input[@type='checkbox']")); 
		WebElement firstone=driver.findElement(By.cssSelector("input[type='checkbox']"));
		//all of the above firstones find the same element
		//*[@id="checkboxes"]/input[2] //copied from chrome xpath
		WebElement secondone = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		//WebElement secondone=driver.findElement(By.cssSelector("input[type='checkbox'][2]"));
		System.out.println(firstone.isSelected());
		System.out.println(secondone.isSelected());
		firstone.click();
		System.out.println(firstone.isSelected());
		secondone.click();
		System.out.println(secondone.isSelected());
		

		Thread.sleep(7000);
		driver.close();
	}

}
