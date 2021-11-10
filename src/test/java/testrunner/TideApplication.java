package testrunner;

//import pageobjects.AntiBacterial;
import pageobjects.Home;
import pageobjects.Laundary;
import pageobjects.PowderPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utility.ExtentReportsClass;
import utility.ReadPropertyFile;

public class TideApplication {

	WebDriver driver;
	protected static Logger log = LogManager.getLogger(TideApplication.class.getName());

	@Test(priority = 1)
	public void testcase1() throws IOException, InterruptedException {
		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		driver.get(read.getUrl());
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		Home home = new Home(driver);
		// WebDriverWait wait=new WebDriverWait(driver,5000);

		Actions a = new Actions(driver);
		ExtentReportsClass er = new ExtentReportsClass(driver);
		er.start("At Home Page");
		PowderPage p = new PowderPage(driver);
		log.info("navigated to home page");
		WebElement product = home.getProduct();

		a.moveToElement(product).build().perform();
		home.getPowder().click();
		if (p.getFree().getText().equalsIgnoreCase("Free and Gentle"))
			log.info("it has tide free and gentle powder");

//		home.getSearch().sendKeys("Antibacterial");
//		home.getButton().click();
//		AntiBacterial ab = new AntiBacterial(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 30000);
//		WebElement bacterial = ab.getAnti();
//		wait.until(ExpectedConditions.textToBePresentInElement(bacterial, "Antibacterial"));
//		if (bacterial.getText().equalsIgnoreCase("Antibacterial"))
//			log.info("Yes there is an Antibacterial Product");
		er.end();
	}

	@Test(priority = 2)
	public void testcase3() throws IOException {
		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		driver.get(read.getUrl());
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Laundary l = new Laundary(driver);

		ExtentReportsClass er = new ExtentReportsClass(driver);
		Home home = new Home(driver);
		WebElement wash = home.getWash();
		Actions a = new Actions(driver);
		a.moveToElement(wash).build().perform();
		home.getLaundary().click();
er.start("At Laundary Page");
	   if(l.getRead().getText().equalsIgnoreCase("How to Read Laundry Symbols"))
			log.info("yes correct  it displays how to read laundary symbols");
	er.end();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
