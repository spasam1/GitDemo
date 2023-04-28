package com.saranya.selenium.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saranya.selenium.pageobjects.CartPageObject;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	public void waitForElementAppear(By findby) {
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby)); 

	}
	
	public void waitForWebElementAppear(WebElement findby) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findby)); 

		}
		
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPageObject goToCartPage() {
		cartHeader.click();
		return new CartPageObject(driver);
	
	}
}
