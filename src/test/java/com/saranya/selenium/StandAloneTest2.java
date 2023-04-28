//package com.saranya.selenium;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.saranya.selenium.pageobjects.PageObjectsLandingPage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class StandAloneTest2 {
//
//	public static void main(String[] args) throws InterruptedException {
//		
//		String productname="ZARA COAT 3";
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://rahulshettyacademy.com/client");
//		driver.manage().window().maximize();
//		driver.findElement(By.id("userEmail")).sendKeys("saranya.14894@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Saranya1402@pasam");
//		driver.findElement(By.id("login")).click();
//		
//		
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));  
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		
//	WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//		// the above wait and below wait statements functionality is same. But above statement taking some time to execute.
//		//So for better performance used below wait statement.
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productname));
//		Assert.assertTrue(match);
//		driver.findElement(By.cssSelector(".totalRow button")).click();
//		Actions a = new Actions(driver);
//		
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//		
//	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ta-results")));
//		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//		driver.findElement(By.cssSelector(".action__submit")).click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".toast-container")));
//		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[normalize-space()='Sign Out']")).click();
//		Thread.sleep(1000);
//		driver.close();
//		
//		
//	}
//
//}
