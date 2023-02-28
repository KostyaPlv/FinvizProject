package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrgPassPage extends BasePage {

	@FindBy(css = "[name='email']")
	private WebElement forgotEmailField;

	@FindBy(css = ".button.is-primary.is-large")
	private WebElement submitBtn;

	public FrgPassPage(WebDriver driver) {
		super(driver);
	}

	public void forgot(String email) {
		fillText(forgotEmailField, email);
		click(submitBtn);
	}
}
