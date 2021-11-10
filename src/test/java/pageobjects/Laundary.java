package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ApplicationUI;

public class Laundary {
	public WebDriver driver;
	ApplicationUI apps = new ApplicationUI();

	public Laundary(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRead() {
		return driver.findElement(apps.read);
	}

}
