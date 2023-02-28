package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PortfolioPage extends BasePage {
	@FindBy(css = "[name='portfolio_name']")
	private WebElement portfolioName;

	@FindBy(css = "[name='ticker0']")
	private WebElement tickerField1;

	@FindBy(css = "[name='ticker1']")
	private WebElement tickerField2;

	@FindBy(css = "[name='transaction0']")
	private WebElement transactionSelect1;

	@FindBy(css = "[name='transaction1']")
	private WebElement transactionSelect2;

	@FindBy(css = "[name='shares0']")
	private WebElement sharesField1;

	@FindBy(css = "[name='shares1']")
	private WebElement sharesField2;

	@FindBy(css = "[name='price0']")
	private WebElement priceField1;

	@FindBy(css = "[name='price1']")
	private WebElement priceField2;

	@FindBy(css = "[name='date1']")
	private WebElement date2;

	@FindBy(css = "[onclick='FormGetLastPrice(0);return false;']")
	private WebElement tdyPriceBtn;

	@FindBy(css = "#addrows_button")
	private WebElement addRowsBtn;

	@FindBy(css = "[value='Save Changes']")
	private WebElement saveBtn;
	
	@FindBy(css = ".chart")
	private WebElement saveBtnResult;

	@FindBy(css = ".portfolio-links a:nth-child(3)")
	private WebElement deleteBtn;

	public PortfolioPage(WebDriver driver) {
		super(driver);
	}

	public void fillForm1(String ticker, String opt, String shares, String price) {
		fillText(tickerField1, ticker);
		select(transactionSelect1, opt);
		fillText(sharesField1, shares);
		fillText(priceField1, price);
	}

	public void fillForm2(String ticker, String opt, String date, String shares, String price) {
		fillText(tickerField2, ticker);
		select(transactionSelect2, opt);
		fillText(date2, date);
		fillText(sharesField2, shares);
		fillText(priceField2, price);
	}

	public void portName(String text) {
		fillText(portfolioName, text);
	}

	public void todayPriceBtn() {
		click(tdyPriceBtn);
	}

	public void moreRowsBtn() {
		click(addRowsBtn);
	}

	public void saveChangesBtn() {
		click(saveBtn);
	}

	public void deletePortfolioBtn() {
		click(deleteBtn);
		alertOk();
	}
	
	public String validationCreate() {
		return getText(saveBtnResult);
	}
}
