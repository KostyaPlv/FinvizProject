package testsPackage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.SubscriptionPage;

public class SubscriptionTest extends BaseTest {

	@Test(description = "Subscribe for a monthly plan")
	public void tc_14_buyMonthlyPlan() {
		SubscriptionPage sp = new SubscriptionPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.login("desirekot@gmail.com", "$dhMCA@7SRhkx9^u");
		hp.eliteBtn();
		sp.sub();
		PaymentPage pp = new PaymentPage(driver);
		sleep(3000);
		pp.cardInfo("4263982640269299", "0226", "837", "Musk Junior", "Antarctica", "Red st", "White");
		sleep(5000);
		String expected = "Your card was declined. Please contact your issuer.";
		String actual = pp.validatioPayment();
		assertEquals(actual, expected);
	}
}
