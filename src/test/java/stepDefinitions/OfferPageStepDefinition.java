package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {


	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	/* Here we are implementing the following principles:
	 * single responsibility principle
	 * loosely coupled (by creating separate page definitions for each page)
	 * factory design pattern (create separate class for creating objects)
	 */
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup1) {
		this.testContextSetup = testContextSetup1;
	}
		
	@Then("^User search with the same shortname (.+) in the offers page$")
	public void user_search_with_the_same_shortname_in_the_offers_page(String shortName) throws InterruptedException {
	    
		switchToOfferPage();
		//OfferPage offerPage = new OfferPage(testContextSetup.driver);
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
	    Thread.sleep(2000);
	    offerPageProductName = offerPage.getProductName();
	    
	}
	
	public void switchToOfferPage() {
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
	    testContextSetup.genericUtils.switchWindowToChild();
	}
	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
}
