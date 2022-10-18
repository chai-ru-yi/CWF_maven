package com.sddevops.CWF_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NewTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;
	
	


	

	@Test
	public void checkTitle2() {
		webDriver.navigate().to("http://localhost:8010/CWF_maven.eclipse/AddProductListing.jsp");

		Assert.assertEquals(webDriver.getTitle(), "Add Product Listing");

		System.out.println("Title: " + webDriver.getTitle());

		webDriver.findElement(By.className("btn-success")).click();

		
		System.out.println("New title: " + webDriver.getTitle());
	}



	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		webDriver = new ChromeDriver();
	}



	@AfterTest
	public void afterTest() {
		
		// webDriver.quit();
	}
	
	//test

}
