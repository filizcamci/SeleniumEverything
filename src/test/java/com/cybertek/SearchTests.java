package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Test Case 1: Amazon search results
 * 1.Go to amazon.com
 * 2.Enter searchtermSelenium book
 * 3.Verify that a resultwith “Selenium Testing Tools Cookbook”is displayed
 *  anywhere in the results4.Enter search term Java OCA book5.Verify that a 
 *  resultwith “Selenium Testing Tools Cookbook”is not displayed anywhere in the results
 */
public class SearchTests {
	@Test
	public void amazonSearchOne() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		String str = "Selenium Testing Tools Cookbook";
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(str + Keys.ENTER);
		/*
		 * <h2 data-attribute="Selenium Framework Design in Data-Driven Testing: Build
		 * data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and
		 * TestNG" data-max-rows="2"
		 * class="a-size-medium s-inline  s-access-title  a-text-normal"><span
		 * class="a-offscreen">[Sponsored]</span>Selenium Framework Design in
		 * Data-Driven Testing: Build data-driven test frameworks using Selenium
		 * WebDriver, AppiumDriver, Java, and TestNG</h2>
		 * css-->h2.a-size-medium.s-inline.s-access-title.a-text-normal
		 * (//*[starts-with(@data-attribute, 'Selenium Framework')])[1]
		 * xpath-->(//h2[@class='a-size-medium s-inline s-access-title
		 * a-text-normal'])[1] xpath-->(//h2[@class='a-size-medium s-inline
		 * s-access-title a-text-normal']) tag[@id=
		 */
		String xpath = "//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal'][.='Selenium Testing Tools Cookbook']";
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		/*4.Enter search term Java OCA book
		 * 5.Verify that a resultwith “Selenium Testing Tools Cookbook”is not displayed anywhere in the results
		 */
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java OCA Book" + Keys.ENTER);
		Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
		//System.out.println(driver.findElement(By.xpath(xpath)).isDisplayed());

		//driver.close();
	}
}
