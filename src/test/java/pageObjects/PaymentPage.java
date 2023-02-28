package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	@FindBy(css = "#cardNumber")
	WebElement cardNum;

	@FindBy(css = "#cardExpiry")
	WebElement valid;

	@FindBy(css = "#cardCvc")
	WebElement cvc;

	@FindBy(css = "#billingName")
	WebElement cardName;

	@FindBy(css = "#billingAddressLine1")
	WebElement addres;

	@FindBy(css = "#billingLocality")
	WebElement city;

	@FindBy(css = "#billingCountry")
	WebElement country;

	@FindBy(css = ".SubmitButton.SubmitButton--complete")
	WebElement subBtn;
	
	@FindBy(css = ".FieldError.Text.Text-color--red.Text-fontSize--13 span")
	private WebElement subBtnResult;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void cardInfo(String num, String date, String cv, String name, String opt, String adrs, String cty) {
		fillText(cardNum, num);
		fillText(valid, date);
		fillText(cvc, cv);
		fillText(cardName, name);
		select(country, opt);
		fillText(addres, adrs);
		fillText(city, cty);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		click(subBtn);
	}
	
	public String validatioPayment() {
		return getText(subBtnResult);
	}
}
