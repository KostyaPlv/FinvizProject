package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriptionPage extends BasePage {

	@FindBy(css = "#js-elite-button-monthly")
	private WebElement mntBtn;

	@FindBy(css = "#js-elite-stripe-button")
	private WebElement payBtn;

	public SubscriptionPage(WebDriver driver) {
		super(driver);
	}

	public void sub() {
		click(mntBtn);
		sleep(1000);
		click(payBtn);
	}
}
