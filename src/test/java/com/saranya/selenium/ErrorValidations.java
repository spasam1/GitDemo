package com.saranya.selenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saranya.selenium.TestComponents.BaseTest;
import com.saranya.selenium.pageobjects.CartPageObject;
import com.saranya.selenium.pageobjects.ProductCatelogue;

public class ErrorValidations extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingpage.loginApplication("saranya.14294@gmail.com", "Saranya15885@pasam");

		//// div[@aria-label='Incorrect email or password.']
		// X path
		// css path : ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		

	}
	
	@Test
	
	public void ProductErrorValidation() throws InterruptedException {
		String productname="ZARA COAT 3";
		ProductCatelogue productCatelogue = landingpage.loginApplication("babu@gmail.com", "Saranya1402@pasam");
		List<WebElement> products = productCatelogue.getProducts();//driver.findElements(By.cssSelector(".mb-3"))
		productCatelogue.addProductToCart(productname);
		CartPageObject cartpageobject = productCatelogue.goToCartPage();
		Boolean match = cartpageobject.verifyDisplayProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
		System.out.println("Learning GitHub.");
		
		System.out.println("Learning GitHub changes in GitDemo in git repo will automatically come to Gitstuff after push and pull");
		
		System.out.println("Push to GitHub");
		
		System.out.println("Pulled the code from GitHub by Gitstuff and making changes");
		System.out.println("Pushed the code to GitHub by GitStuff");
	}

}
