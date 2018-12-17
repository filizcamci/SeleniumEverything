package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Characteristics of a Good Test Case:
	Only test one thing in a test case
	Test case should have an exact and accurate purpose
	Test case should be written in a clear and easy to understand language
	Test Case Should be Relatively Small
	Test case should be independent
	Test case should not have unnecessary steps or words
	Test case should be traceable to requirements or design
	Test case should be repeatable
	Test case should use consistent terminology and identification of functionality
 */

/*
 * TestBase class --> 
is a class that serves as a utility class for all the tests. other tests extend the testbase class. TestBase class contains common methods like open, close driver, get url, wait utilities, browser utilities.


Pop up   -> anything that pops up from the page
    
common are pop up, modals, alerts, dialog, confirmation

3 types of pop ups:
    
    1. OS based pop ups
        Selenium cannot control OS based pop ups, windows. other tools which can are: AutoIT, Sikuli, RObot
    2. JavaScript Pop ups
        SOme alerts come from javascript, they are not in the HTML Code. the browser create the alerts.
        Selenium can handle JS alerts.
        If there is an alert on the page, selenium cannot do any operation on this page, you will get UnhandledAlertException exception.

        To deal with JS alerts, we have ALert class, it has accept, dismiss, getttext, sendkeys methods that does operations on alerts

        NoAlertPresentException  -> is thrown when we use alert = driver.switchTo().alert(); when there is no actual alert on page

        accept()   -> clicking OK on alerts

    3. HTML based pop ups.
        can be handled just like any other webelements, these alerts are part of the HTML code. using selenium we can locate and do 
        all operations like click, type etc

How to verify HTML alert is present?    
    just like we verify any other element. locate and assert isDisplayed()


How to verify JS alert is present?
 */

public class TestBase {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// WebDriverManager.firefoxdriver().setup();
		// driver = new FirefoxDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void switchByTitle(String title) {
		String original=driver.getWindowHandle();
		
		for(String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals(title)) {
				//do not do anything else since we are in the right window
				return;
			}
		}
		driver.switchTo().window(original);
	}
	
	
	
	
	
}
