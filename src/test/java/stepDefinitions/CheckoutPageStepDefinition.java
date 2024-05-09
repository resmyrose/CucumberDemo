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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage() ;
	}
	
	@Then("Varify if user has the ability to apply promo code and place the order ")
	public void varify_if_use_has_the_ability_to_apply_promo_code_and_place_the_order () {
		
		Assert.assertTrue(checkoutPage.varifyPromotion());
		Assert.assertTrue(checkoutPage.varifyPlaceOrder());
	}
	
	@Then("^User proceeds to checkout and validate (.+) items in the checkout page$")
	public void user_proceeds_to_checkout_and_validate_items_in_the_checkout_page(String items) throws InterruptedException {
		checkoutPage.checkoutItems();
		Thread.sleep(2000);
	}
	
	
}
