package com.saranya.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saranya.selenium.AbstractComponents.AbstractComponent;

public class PageObjectsLandingPage extends AbstractComponent{
// page object shouldn't hold any data. data must come from test class.
	WebDriver driver;
	public PageObjectsLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver); // this statement is telling that pass the driver which is getting from test class to parent
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// this is same syntax as driver.findElement(By.id("userEmil"));
	//this is pagefactory model of finding elements.
	//This findby will be using the driver which is initialized in the constructor PageObjectsLandingPage. One time initialization only
	// why this initialization happen only in constructor. Because, before touch anything in the class constructor is the first thing to
	//execute. So any initialization code can be include in the constructor
	@FindBy(id="userEmail") 
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	// there are some actions we are performing in the webelements like send keys, click. 
	// We can use Actions here to perform all these by creating a method.
	
	public ProductCatelogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		return new ProductCatelogue(driver);
		 
	
	}
	public String getErrorMessage() {
		waitForWebElementAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client"); 
	}
	
	

}
