package testsPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class SearchTest extends BaseTest {

	@Test(dataProvider = "stocks")
	public void tc_12_searchStock1(String ticker) {
		HomePage hp = new HomePage(driver);
		hp.search(ticker);
		hp.validationStockSearch();
	}

	@Test(dataProvider = "commodity")
	public void tc_13_searchFuture1(String future) {
		HomePage hp = new HomePage(driver);
		hp.searchFutures(future);
	}

	@DataProvider
	public Object[][] stocks() {
		Object[][] myData = { { "tqqq" }, { "aapl" }, { "spy" }, };
		return myData;
	}

	@DataProvider
	public Object[][] commodity() {
		Object[][] myData = { { "oil" }, { "coffee" }, { "wheat" }, };
		return myData;
	}
}
