package com.saranya.selenium.pageobjects;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saranya.selenium.AbstractComponents.AbstractComponent;

public class CartPageObject extends AbstractComponent {


	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List <WebElement> productsTitle;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	
	public Boolean verifyDisplayProducts(String productName) {
		Boolean match = productsTitle.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	
	public CheckOutPage goToCheckOut() {
		checkOut.click();
		return  new CheckOutPage(driver);
		 
	}

	
	
	
}
