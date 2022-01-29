package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By email = By.cssSelector("#user_email");
	By passWord = By.cssSelector("#user_password");
	By login = By.cssSelector("input[name='commit']");
	By forgotPassword = By.cssSelector(".link-below-button");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(passWord);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
}