package com.sddevops.CWF_maven.eclipse;
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
	public void checkTitle() {
		webDriver.navigate().to("http://localhost:8090/BeautyMasks/ProductServlet/dashboard");
	
		Assert.assertEquals(webDriver.getTitle(), "Product List");
	
		System.out.println("Title: " + webDriver.getTitle());
		
//		Assert.assertLinkPresent("home");
//		Assert.clickLink("home");
//		Assert.assertTitleEquals("Home");
		
		webDriver.findElement(By.className("btn-success")).click();
		
		Assert.assertTrue(webDriver.getTitle().contains("Add Product Listing"));
		System.out.println("New title: " + webDriver.getTitle());
	}

	
	
	
	
	
	
	
	
	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// use C:\Program Files\Google\Chrome\chromedriver_win32
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		//webDriver.quit();
	}

}
