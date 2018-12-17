package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Verify Search term
 * 1.Open browser
 * 2.Open Etsy homepage3.Enter search term
 * 4.Verify the results page title contains the search term5.Verify search entry is still saved in the search bar
 */

public class VerifySearch {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://etsy.com");
	//driver.findElement(By.id("search-query")).sendKeys("fathers day gift");
	
	String searchTerm="fathers day gift";
	WebElement input=driver.findElement(By.id("search-query"));
			//input.sendKeys(searchTerm);
			
			
			input.sendKeys(searchTerm+Keys.ENTER);//page directed to results page
			input = driver.findElement(By.id("search-query"));
			String actual=input.getAttribute("value");
			System.out.println(actual);
			if(actual.equals(searchTerm)) {
				System.out.println("pass");
			}else {
				System.out.println("fail");
				System.out.println("expected: "+searchTerm);
				System.out.println("actual: "+actual);
			}
			Thread.sleep(7000);
			driver.close();
			//driver.findElement(By.linkText("sell on etsy")).click();
			}
// public static void main(String[] args) {
//    
//    WebDriverManager.chromedriver().setup();
//    WebDriver driver = new ChromeDriver();
//    driver.get("http://etsy.com");
//    String searchTerm = "fathers day gifts";
//    
//    WebElement input = driver.findElement(By.id("search-query"));
//    
//    input.sendKeys(searchTerm+Keys.ENTER);// page reshreshed/ directed to results page
//    // locate the element again. 
//    input = driver.findElement(By.id("search-query"));
//    
//    // get the text of the element
//    String actual = input.getAttribute("value");
//    
//    System.out.println(actual);
//
//    if (actual.equals(searchTerm)) {
//      System.out.println("pass");
//    } else {
//      System.out.println("fail");
//      System.out.println("expected:\t"+searchTerm);
//      System.out.println("found:\t"+actual);
//    }
//    
//	
}

