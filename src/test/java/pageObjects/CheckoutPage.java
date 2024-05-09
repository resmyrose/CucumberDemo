package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private By cartBag = By.cssSelector("img[alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.xpath("//button[@class = 'promoBtn']");
	private By placeOrder = By.xpath("//button[contains(text(), 'Place Order')]");
	
	public WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver =  driver;
	}
	
	public void checkoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean varifyPromotion() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public Boolean varifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	

}
