package com.cybertek;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

//IFrame/Frame is a tag to embed html code inside another html code
/*
 * <html>
 * 	<iframe>
 * <html>
 * </html>
 * 	</iframe>
 *</html>
 */
public class IFramesTest extends TestBase {
	@Test
	public void IFrameTest() {
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		// driver.findElement(By.id("tinymce")).sendKeys("something");
		// above test fails since selenium can see only one html at a time
		// we have to switch between iframes to solve the issue
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		// switches to iframe
		driver.switchTo().frame(iframe);
		// driver.switchTo().frame("mce_0_ifr");//selenium assumes this string is id or
		// name of the frame
		// driver.switchTo().frame(1);//takes the index of the frame
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("something");
		// to go back
		driver.switchTo().defaultContent();
		// driver.switchTo().parentFrame(); //goes to one step up parent frame
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	}
}
