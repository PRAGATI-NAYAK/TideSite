package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.AntiBacterial;
import pageobjects.Home;
import testrunner.TideApplication;
import utility.ExtentReportsClass;
import utility.ReadPropertyFile;

public class StepDefinitions extends TideApplication {
	WebDriver driver;
	
	@Given("^start chrome browser$")
	public void start_chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
	}

	@And("^navigates to the site \"([^\"]*)\"$")
	public void navigates_to_the_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@When("^enters \"([^\"]*)\" in search box and clicks on search$")
	public void enters_in_search_box_and_clicks_on_search(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Home home = new Home(driver);
		home.getSearch().sendKeys(arg1);
		home.getButton().click();
	}

	@Then("^it should find any product name having \"([^\"]*)\"$")
	public void it_should_find_any_product_name_having(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		AntiBacterial ab = new AntiBacterial(driver);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 300);
		ExtentReportsClass er = new ExtentReportsClass(driver);
		WebElement bacterial = ab.getAnti();
		WebElement preview=ab.getPreview();
		wait.until(ExpectedConditions.visibilityOf(preview));
		er.start("Antibacterial Page");
		if (bacterial.getText().equalsIgnoreCase(arg1))
			log.info("Yes there is an Antibacterial Product");
		er.end();
	}

	}


  

  

