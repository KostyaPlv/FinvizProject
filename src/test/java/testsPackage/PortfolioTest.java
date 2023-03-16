package testsPackage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PortfolioPage;

public class PortfolioTest extends BaseTest {

	@Test(description = "Creating new portfolio")
	public void tc_07_createNewPortfolio() {
		PortfolioPage pop = new PortfolioPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.login("desirekot@gmail.com", "$dhMCA@7SRhkx9^u");
		hp.portfolioBtn();
		pop.portName("Best Stocks");
		pop.fillForm1("tqqq", "Buy", "200", "");
		pop.todayPriceBtn();
	}

	@Test(description = "Fill current price button")
	public void tc_08_fillLine2() {
		PortfolioPage pop = new PortfolioPage(driver);
		pop.fillForm2("teva", "Short Sell", "10-22-2014", "10", "300");
	}

	@Test(description = "Add more rows button")
	public void tc_09_addRowsButton() {
		PortfolioPage pop = new PortfolioPage(driver);
		pop.moreRowsBtn();
	}

	@Test(description = "Save the portfolio button")
	public void tc_10_saveButton() {
		PortfolioPage pop = new PortfolioPage(driver);
		pop.saveChangesBtn();
		sleep(1000);
		String expected = "Portfolio";
		String actual = pop.validationCreate();
		assertEquals(actual, expected);
	}

	@Test(description = "Delete the portfolio button")
	public void tc_11_deleteButton() {
		PortfolioPage pop = new PortfolioPage(driver);
		pop.deletePortfolioBtn();
	}
}
