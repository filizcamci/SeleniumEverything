package seleniumwaits;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * go to http://the-internet.herokuapp.com/dynamic_loading/1
 * click start
 * verify hello world is displayed
 */
public class SleepTest {
	WebDriver driver;

	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//wait #1
		//waits for specified duration while executing the findelement method
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		//element is already on the page but not visible in the beginning
		WebElement message=driver.findElement(By.xpath("//h4[.='Hello World!']"));
		
		//wait #2
		Thread.sleep(5000);
		//this is the least recommended wait
		
		//wait #3
		//new Actions(driver).pause(5000);
		//behaves as same as #2
		assertTrue(message.isDisplayed(),"MESSAGE NOT DISPLAYED!");
		driver.close();
		
	}
	@Test
	public void test2() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//wait #4
		//this setting will control how long driver will/should wait when page is loading
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//wait #5
		//waits background (ajax) process to finish
		//driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		driver.findElement(By.id("btn")).click();
		WebElement message=driver.findElement(By.id("message"));
		assertEquals(message.getText(),"It's gone!","MESSAGE NOT DISPLAYED!");
		driver.findElement(By.id("btn")).click();
		message=driver.findElement(By.id("message"));
		assertEquals(message.getText(),"It's back!","MESSAGE NOT DISPLAYED!");
		driver.close();
	}
}
