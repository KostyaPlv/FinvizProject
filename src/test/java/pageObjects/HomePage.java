package pageObjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(css = "#search input")
	private WebElement searchBar;

	@FindBy(css = ".ticker")
	private List<WebElement> futuresSrch;
	
	@FindBy(css = ".fullview-ticker")
	private WebElement searchBarResult;

	@FindBy(css = "#search input")
	private WebElement submit;

	@FindBy(css = ".nav-link.is-elite")
	private WebElement eliteTab;

	@FindBy(css = ".nav-link.is-help")
	private WebElement helpTab;
	
	@FindBy(css = ".help-title")
	private WebElement helpTabResult;

	@FindBy(css = ".header-container tbody tr td:nth-child(6) a")
	private WebElement portfolioTab;

	@FindBy(css = "#canvas-wrapper")
	private WebElement stkCanvas;
	
	@FindBy(css = ".leading-tight.text-2xs")
	private WebElement stkCanvasResult;

	@FindBy(css = ".nn-home:nth-child(6) td a")
	private WebElement lstArticle;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void search(String ticker) {
		fillText(searchBar, ticker);
		submit(submit);
	}

	public void searchFutures(String ticker) {
		fillText(searchBar, ticker);
		sleep(1000);
		List<WebElement> list = futuresSrch;
		for (WebElement el : list) {
			if (el.getText().toLowerCase().contains("@")) {
				el.click();
				break;
			}
		}
	}

	public void eliteBtn() {
		click(eliteTab);
	}

	public void helpBtn() {
		click(helpTab);
	}

	public void portfolioBtn() {
		click(portfolioTab);
	}

	public void canvasBtn() {
		click(stkCanvas);
	}

	public void articleBtn() {
		click(lstArticle);
	}
	
	public String validationCanvas() {
		return getText(stkCanvasResult);
	}
	
	public String validationHelp() {
		return getText(helpTabResult);
	}
	
    public void validationStockSearch() {
        String result = searchBarResult.getText();
    }
}
