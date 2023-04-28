package com.saranya.selenium.pageobjects;

import java.util.List;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saranya.selenium.AbstractComponents.AbstractComponent;

public class ProductCatelogue extends AbstractComponent {

	private static final String String = null;

	WebDriver driver;

	public ProductCatelogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	
	
	By productsBy = By.cssSelector(".mb-3");
	By addtoCart =By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProducts() {

		waitForElementAppear(productsBy);

		return products;
	}

	public WebElement getProductByName(String productname) {

		WebElement prod = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productname) throws InterruptedException {
		
		WebElement prod = getProductByName(productname);
		prod.findElement(addtoCart).click();	
		waitForElementAppear(toastMessage);
		Thread.sleep(1000);
		//waitForElementToDisappear(spinner);
		
	}
	
	
}
