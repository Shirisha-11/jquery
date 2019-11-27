package com.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BaseClass;

public class JqueryPageObject extends BaseClass {

	WebDriver driver;
	public static final By SCROLLING = By.xpath("//a[@href='https://jquery.org/license/']");
	public static final By CHAPTERLISTLINKS = By.xpath("//aside[@id='chapter-list']/ul/li/a");
	public static final By RECENTUPDATELIST = By.xpath("//aside[@id='recent-updates']/ul/li/a");

	// Intializing constructor
	public JqueryPageObject(WebDriver driver) {
		this.driver = driver;
	}

	// Entering source location
	public void scrollingPage(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		waitForExpectedElement(driver, SCROLLING);
		// Find element by link text and store in variable "Element"
		WebElement Element = driver.findElement(SCROLLING);

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public void displayList(WebDriver driver) {
		waitForExpectedElement(driver, CHAPTERLISTLINKS);
		List<WebElement> links = driver.findElements(CHAPTERLISTLINKS);
		System.out.println("Chanter link elements");
		for (WebElement element : links) {
			String text = element.getText();
			System.out.println(text);
		}
	}

	public void displayRecentList(WebDriver driver) {
		waitForExpectedElement(driver, RECENTUPDATELIST);
		List<WebElement> links = driver.findElements(RECENTUPDATELIST);
		System.out.println("Recent updatelist elements");
		for (WebElement element : links) {
			String text = element.getText();
			System.out.println(text);
		}
		driver.close();
	}

	public void clickonAboutJqueryLink(WebDriver driver) throws InterruptedException {
		List<WebElement> list = driver.findElements(CHAPTERLISTLINKS);
		List<String> all_elements = new ArrayList<String>();
		// int listsize=list.size();
		String text;
		for (WebElement element : list) {
			all_elements.add(element.getAttribute("href"));
			System.out.println(all_elements);
			Thread.sleep(3000);
		}
		System.out.println();
		for (int i = 0; i < all_elements.size(); i++) {
			text = all_elements.get(i);
			driver.navigate().to(text);
			// Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			System.out.println("Url Name : " + currentURL);

			String currentTitleName = driver.getTitle();
			System.out.println("Title Name : " + currentTitleName);

			System.out.println();
			driver.navigate().back();

		}

	}

	public void clickonRecentUpdatelist(WebDriver driver) throws InterruptedException {
		waitForExpectedElement(driver, RECENTUPDATELIST);
		List<WebElement> list = driver.findElements(RECENTUPDATELIST);
		List<String> all_elements = new ArrayList<String>();
		// int listsize=list.size();
		String text;
		for (WebElement element : list) {
			all_elements.add(element.getAttribute("href"));
			System.out.println(all_elements);
			Thread.sleep(3000);
		}
		System.out.println();
		for (int i = 0; i < all_elements.size(); i++) {
			text = all_elements.get(i);
			driver.navigate().to(text);
			Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			System.out.println("Url Name : " + currentURL);

			String currentTitleName = driver.getTitle();
			System.out.println("Title Name : " + currentTitleName);

			System.out.println();
			driver.navigate().back();

		}
	}
}
