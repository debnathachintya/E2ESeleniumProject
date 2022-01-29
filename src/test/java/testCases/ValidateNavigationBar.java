package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import listeners.TestNGListeners;
import pageObjects.LandingPage;

@Listeners(TestNGListeners.class)

public class ValidateNavigationBar extends BaseTest {
	public static Logger log = LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
	}
	
	@Test
	public void pageNavigationBar() throws Exception {
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is Displayed");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed");
	}
}