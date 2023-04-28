package com.saranya.selenium.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.saranya.selenium.pageobjects.PageObjectsLandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public PageObjectsLandingPage landingpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\saranya\\selenium\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox 
		}
		
		else if(browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumWebdriver\\EdgeDriver\\edgedriver_win64\\C:\\SeleniumWebdriver\\EdgeDriver\\edgedriver_win64.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		}
	@BeforeMethod
		public PageObjectsLandingPage launchApplication() throws IOException {
			
			driver = initializeDriver();
			landingpage = new PageObjectsLandingPage(driver);
			landingpage.goTo();
			return landingpage;
		}
	@AfterMethod
	 	public void tearDown() {
		
		driver.close();
	}

}
