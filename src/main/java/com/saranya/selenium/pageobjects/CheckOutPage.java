package com.saranya.selenium.pageobjects;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.saranya.selenium.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {


	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement  country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement  selectCountry;

	@FindBy(css=".action__submit")
	WebElement  submit;
	By results =By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		
		a.sendKeys(country,countryName).build().perform();
		
		waitForElementAppear(results);
		selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
	return new ConfirmationPage(driver);
	}
	
}
