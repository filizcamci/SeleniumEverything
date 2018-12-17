package com.cybertek;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownDemo {
// https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
		//1. find select tag
		WebElement selectTag=driver.findElement(By.name("mt_html_select_box"));
		//2. create select object from the select tag
		Select list=new Select(selectTag);
		WebElement selected=list.getFirstSelectedOption();
		System.out.println(selected.getText());
		System.out.println(list.getFirstSelectedOption().getText());
		List<WebElement> options=list.getOptions();
		for(WebElement each:options) {
			System.out.println(each.getText());
		}
		list.selectByVisibleText("Madrid");
		list.deselectByIndex(1);
		list.deselectAll();
		Select secondList=new Select(driver.findElement(By.cssSelector("slect[multiple='yes']")));
		secondList.selectByVisibleText("New York");
		secondList.selectByVisibleText("Madrid");
		secondList.getAllSelectedOptions();
		List<WebElement> allSelectedOptions=secondList.getAllSelectedOptions();
		//use for each to print out
		allSelectedOptions.size();
		secondList.deselectAll();
		allSelectedOptions.size();
		
}
	/*
	 * public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//open browser
		WebDriver driver = new ChromeDriver();
		//go to web site
		driver.get("https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/");
			
		WebElement selectTag = driver.findElement(By.name("my_html_select_box"));
		
		//2. create select object 
		Select list = new Select(selectTag);
		//getFirstSelectOption
		//first option
		WebElement selected= list.getFirstSelectedOption();
		System.out.println(selected.getText());
         
		//second option
		System.out.println(list.getFirstSelectedOption().getText());
		//get all options from select , getOptions() returns everything as a list
	    List<WebElement> options =list.getOptions();
	    	System.out.println("from list :");
	    for (WebElement eachOption : options) {
	    
			System.out.println(eachOption.getText());
		}
		//select using the visible text
	    System.out.println("_________________");
	    list.selectByVisibleText("Madrid");
	    System.out.println("selected by text :\t" + list.getFirstSelectedOption().getText());
		
		
		//select by using index
	    list.selectByIndex(0);
	    System.out.println("selected by index:\t" + list.getFirstSelectedOption().getText());
		driver.close();
		
	}
	 */
}
