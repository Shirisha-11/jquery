package com.utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public WebDriver driver;
	public String frameworkDir = System.getProperty("user.dir");
	public String webDriverPath = frameworkDir + File.separator + "Resources" + File.separator + "chromedriver.exe";

	public void openWebPage(String path) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		 driver.get(path);

		// WebDriver driver = new ChromeDriver();
		// Maximize the screen
		driver.manage().window().maximize();
	}

	// Explicit wait method for element clickable
	public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void swithWindow(WebDriver driver) {
		try {
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
