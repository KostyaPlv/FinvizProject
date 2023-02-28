package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css = ".nav-link.sign-in")
	private WebElement loginTab;

	@FindBy(css = "[name='email']")
	private WebElement emailField;

	@FindBy(css = "[name='password']")
	private WebElement passwordField;
	
	@FindBy(css = "#error")
	private WebElement errorLoginResult;

	@FindBy(css = ".button.is-primary.is-large")
	private WebElement loginBtn;
	
	@FindBy(css = ".nav-link.sign-in.account-btn.is-account")
	private WebElement loginResult;

	@FindBy(css = ".center-text a")
	private WebElement forgotPass;
	
	@FindBy(css = ".error")
	private WebElement forgotPassResult;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String user, String password) {
		click(loginTab);
		fillText(emailField, user);
		sleep(2000);
		fillText(passwordField, password);
		sleep(2000);
		click(loginBtn);
	}

	public void forgotPassword() {
		click(forgotPass);
		sleep(2000);
	}
	
	public String forgotPasswordValidation() {
		return getText(forgotPassResult);
	}
	
	public String loginValidation() {
		return getText(loginResult);
	}
	
	public String errorLoginValidation() {
		return getText(errorLoginResult);
	}
}
