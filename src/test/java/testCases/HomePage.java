package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import listeners.TestNGListeners;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

@Listeners(TestNGListeners.class)

public class HomePage extends BaseTest {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws Exception {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String email, String password) throws Exception {
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		
		lp.getEmail().sendKeys(email);
		log.info("Entered Email"+email);
		
		lp.getPassword().sendKeys(password);
		log.info("Entered Password"+password);
		
		lp.clickLogin().click();
		
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("qa.com");
		fp.sendMeInstructions().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		
		// 1st data set
		data[0][0] = "restricteduser@qw.com";
		data[0][1] = "password";
		
		// 2nd data set
		data[1][0] = "nonrestricteduser@qw.com";
		data[1][1] = "newpassword";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed");
	}
}