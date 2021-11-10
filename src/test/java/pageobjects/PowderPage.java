package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ApplicationUI;

public class PowderPage {

	public WebDriver driver;
	ApplicationUI apps = new ApplicationUI();

	public PowderPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFree() {
		return driver.findElement(apps.free);
	}
}
