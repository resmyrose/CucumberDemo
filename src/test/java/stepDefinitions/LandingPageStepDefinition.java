package stepDefinitions;

import java.io.IOException;
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
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on the GreenCart landing page")
	public void user_is_on_the_green_cart_landing_page() {
		//verifying the page title  
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}  
	
	
	@When("^User search with the shortname (.+) and extract the actual product name$")
	public void user_search_with_the_shortname_and_extract_the_actual_product_name(String shortName) throws InterruptedException {
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		
		landingPage.searchItem(shortName);
	    Thread.sleep(2000);
	    testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println("Product "+ landingPageProductName +" is extracted");
	    
	}
	
	
	@When("Added {string} items of the selected product to the cart")
	public void added_items_of_the_selected_product_to_the_cart(String qty){
		landingPage.incrementQty(Integer.parseInt(qty));
		landingPage.addToCart();
		
	}
}
