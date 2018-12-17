package com.cybertek;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExamples {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.out.println("setting up WebDriver before class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void doubleClickTest() {
		driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
		WebElement slide = driver.findElement(By.id("slide_header"));
		Actions action = new Actions(driver);
		// doubleClick double clicks on the element
		// perform performs the action
		action.doubleClick(slide).perform();
	}

	@Test
	public void hoverTest1() {
		driver.get("https://www.amazon.com/");
		WebElement hello = driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
		Actions action = new Actions(driver);
		// movetoElement hovers on the element
		action.moveToElement(hello).perform();
		driver.findElement(By.linkText("Your Garage")).click();
	}

	@Test
	public void hoverTest2() {
		driver.get("https://www.amazon.com/");
		// WebElement hello=driver.findElement(By.xpath("//span[.='Hello. Sign in']"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[.='Back to top']"))).perform();

	}

	@Test
	public void scrollTest() throws InterruptedException {
		driver.get("http://amazon.com");
		Actions action = new Actions(driver);
		//
		action.sendKeys(Keys.PAGE_DOWN).perform();
		action.sendKeys(Keys.ARROW_DOWN).perform();

		action.sendKeys(Keys.ARROW_DOWN).perform();
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element) scrolls
		// down
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(false);", element) ->
		// scrolls up

	}
	@Test
	public void dragDropTest1() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action = new Actions(driver);
		//drag and drop actions involves 2 elements: source and target
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droptarget"));
		action.dragAndDrop(source, target).perform();
		//action.dragAndDropBy(source, 0, -200).perform();// it goes up
		
		
	}
	
	@Test
	public void dragDropTest2() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action = new Actions(driver);
		//drag and drop actions involves 2 elements: source and target
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droptarget"));
		//move mouse to source
		//click on mouse and hold on source
		//move to target
		//release the mouse
		//action.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();//does the same
		action.moveToElement(source).clickAndHold().moveToElement(target).release().perform(); //does the same
		//action.pause(1000); //same as thread.sleep(1000)
	}
	
	@Test
	public void dragDropTest3() {
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		Actions action = new Actions(driver);
	
	
	}
}
