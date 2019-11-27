package com.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Utilities {
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports reports;
	public static String projectPath = System.getProperty("user.dir");
	
	public String reportFilePath;
	public Date date;
	static Date dte = new Date();
	static String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dte);
	static String reportFileName = "Testing_" + dateFormat;
	public static String screenShotFilePath=projectPath+"/Screenshort/";
	public String driverPath=projectPath+"/Drivers/";
	
	
	public ExtentTest reportsFile(String testCaseName) {
		reportFilePath = projectPath + "/Reports/searching .html";
		reports = new ExtentReports(reportFilePath, false);
		test = reports.startTest(testCaseName);
		return test;
	}
	

	public void endReport() {
		reports.endTest(test);
		reports.flush();
	}

public static String captureScreenshot(WebDriver driver, String screenshotname) {

	try {

		// Set the Current Date and Time
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		Date dt = new Date();
		System.out.println(dateFormat.format(dt));

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File("D:/Selinium/FlightTicketBooking/Screenshots/" 
		
				+ dateFormat.format(dt) + "_" + screenshotname + ".jpg"));
		System.out.println("screenshot has taken");
	} catch (Exception e) {
		System.out.println("exception while taking screenshot" + e.getMessage());
	}
	return screenshotname;
}




}

