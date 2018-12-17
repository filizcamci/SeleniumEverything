package seleniumwaits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExplicitWaitTests {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test
	// oneWhereImplicitDoesNotWork
	public void test1() {
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		WebElement message = driver.findElement(By.cssSelector("#finish h4"));
		// space in css selector indicates descendant child(may be or not 1st child)
		// element with the id finish with child h4

		// Thread.sleep or something similar to it
		// thread.sleep waits in any case but we need something to wait for a specific
		// condition
		// see test2 for solution
		assertTrue(message.isDisplayed(), "MESSAGE SHOULD HAVE BEEN DISPLAYED!");
		assertEquals(message.getText(), "Hello World!", "MESSAGE NOT DISPLAYED!");

	}

	@Test
	// explicit wait for element to be visible
	public void test2() {
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		WebElement message = driver.findElement(By.cssSelector("#finish h4"));
		// wait #6
		// WebDriverWait:it is explicit wait
		// wait until message becomes visible
		// we pass the driver and the expected time

		// wait have 2 components
		// 1 -- duration
		// 2 -- what we are waiting for

		// condition --> what we are waiting for: element to be visible
		// element to disappear, element to have certain text
		// element to be clickable...

		// wait.until()--> starts waiting
		// ExpectedConditions --> contains the wait conditions which can be passed to
		// until() method
		// visibilityOf --> one of the conditions from hte ExpectedConditions class.
		// waits for the element
		// to be visible

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(message));

		// assertion will fail since the message is not loaded
		assertTrue(message.isDisplayed(), "Message should have displayed");
		assertEquals(message.getText(), "Hello World!");
	}

	@Test
	public void waitForDissappear() {
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		assertTrue(driver.findElement(By.cssSelector("#finish h4")).isDisplayed(), "Message should have displayed");
		// WebElement message=driver.findElement(By.cssSelector("#finish h4"));
	}
	
	@Test
	public void FluentWaitTest() {
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.id("btn")).click();
		
		//wait #7
		//Customize the wait 
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								.withTimeout(Duration.ofSeconds(5))            
								.pollingEvery(Duration.ofSeconds(1))    
                                .ignoring(NoSuchElementException.class);
		WebElement message = wait.until( dr -> dr.findElement(By.id("message")));
		
//		WebElement element=wait.until(new Function<WebDriver,WebElement>()){
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id("message"));
		
//			}
//		}
		/*
		 * for those that find lambdas easier to understand:
WebElement message = wait.until( dr -> dr.findElement(By.id("message")));
		 */
		
		//WebElement message=driver.findElement(By.id("message"));
	//	assertEquals(message.getText(),"It's gone!","MESSAGE NOT DISPLAYED!");
		//driver.findElement(By.id("btn")).click();
	}
	
	@AfterMethod
	public void clean() {
		driver.close();
	}

}
