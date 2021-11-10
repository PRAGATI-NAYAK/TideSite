package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uistore.ApplicationUI;

public class Home {
	public WebDriver driver;
	ApplicationUI apps = new ApplicationUI();

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProduct() {
		return driver.findElement(apps.product);
	}

	public WebElement getSearch() {
		return driver.findElement(apps.Search);
	}

	public WebElement getButton() {
		return driver.findElement(apps.button);
	}

	public WebElement getPowder() {
		return driver.findElement(apps.Powder);
	}

	public WebElement getWash() {
		return driver.findElement(apps.wash);
	}

	public WebElement getLaundary() {
		return driver.findElement(apps.Laundry);
	}
	

}
