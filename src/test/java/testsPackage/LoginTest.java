package testsPackage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.FrgPassPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

	@Test(description = "Login with wrong credentials",dataProvider = "getData")
	public void tc_04_wrongLoginTest(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.login(user, password);
		String expected = "The email address or password is incorrect.";
		String actual = lp.errorLoginValidation();
		assertEquals(actual, expected);
	}

	@Test(description = "Password recovery Link")
	public void tc_05_frgtPasswordLink() {
		LoginPage lp = new LoginPage(driver);
		FrgPassPage fp = new FrgPassPage(driver);
		lp.forgotPassword();
		fp.forgot("123@gmail.com");
		sleep(1000);
		String expected = "Email was not found. Please try again.";
		String actual = lp.forgotPasswordValidation();
		assertEquals(actual, expected);
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test(description = "Login with correct credentials")
	public void tc_06_correctLoginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.login("desirekot@gmail.com", "$dhMCA@7SRhkx9^u");
		String expected = "desirekot";
		String actual = lp.loginValidation();
		assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "admin@gmail.com", "123456" }, { "user@yandex.ru", "password123" },
				{ "fuji@san.jp", "osaka123" }};
		return myData;
	}
}
