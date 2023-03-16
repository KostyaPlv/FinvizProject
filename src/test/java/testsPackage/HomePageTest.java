package testsPackage;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import dev.failsafe.internal.util.Assert;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest {

	@Test(description = "Canvas of stocks by sectors")
	public void tc_01_stockCanvasButton() {
		HomePage hp = new HomePage(driver);
		hp.canvasBtn();
		String expected = "Standard and Poor's 500 index stocks categorized by sectors and industries. Size represents market cap.";
		String actual = hp.validationCanvas();
		assertEquals(actual, expected);
		driver.navigate().back();
	}

	@Test(description = "Bottom link in Headlines column")
	public void tc_02_lastArticleLink() {
		HomePage hp = new HomePage(driver);
		hp.articleBtn();
	}

	@Test(description = "Help tag functionality")
	public void tc_03_helpButton() {
		HomePage hp = new HomePage(driver);
		hp.helpBtn();
		String expected = "What Is Stock Screener?";
		String actual = hp.validationHelp();
		assertEquals(actual, expected);
	}
}
