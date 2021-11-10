package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ApplicationUI;

public class AntiBacterial {
	public WebDriver driver;
	ApplicationUI apps = new ApplicationUI();

	public AntiBacterial(WebDriver driver) {
		this.driver = driver;
	}
public WebElement getPreview() {
	return driver.findElement(apps.preview);
}
	public WebElement getAnti() {
		return driver.findElement(apps.anti);
	}
}