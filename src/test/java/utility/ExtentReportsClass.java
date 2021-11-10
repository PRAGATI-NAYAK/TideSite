/*
package com.mindtree.utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsClass{
    WebDriver driver;
	public ExtentTest logger;
	public ExtentReports report;
	
	
public void setUpSuite() {
	ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+TakeScreenShots.getCurrentDateTime()+".html"));
	report=new ExtentReports();
	report.attachReporter(extent);
	}


public ExtentReportsClass(WebDriver driver) {
	this.driver=driver;
}

public void startTest(String name) {
	logger=report.createTest(name);
}

public void printlog(String name) {
	logger.info(name);
	
}

public void tearDownMethod(ITestResult result) throws IOException {
	if(result.getStatus() == ITestResult.FAILURE) {
		
	logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShots.captureScreenshot(driver)).build());
	}
	else if(result.getStatus() == ITestResult.SUCCESS) {
		
		logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(TakeScreenShots.captureScreenshot(driver)).build());
		}

	report.flush();
}
}
*/

package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	WebDriver driver;
	public ExtentTest logger;
	public ExtentReports extent;

	public ExtentReportsClass(WebDriver driver) throws IOException {

		ReadPropertyFile read = new ReadPropertyFile();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		extent = new ExtentReports(System.getProperty("user.dir") + read.getExtentReportPath()
				+ TakeScreenShots.getCurrentDateTime() + ".html");
	}

	public void start(String name) throws IOException {

		logger = extent.startTest(name);
		logger.log(LogStatus.PASS,
				logger.addScreenCapture(TakeScreenShots.captureScreenshot(driver)) + "Test Passed " + name);

	}

	public void end() {
		extent.endTest(logger);
		extent.flush();
	}
}
