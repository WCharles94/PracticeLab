package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BaseClass;
import page.HomePage;
import page.LoginPage;

import com.relevantcodes.extentreports.LogStatus;

public class FirstTestCase2 extends BaseClass {

	@Test
	public void verifyValidUser() {

		logger = reports.startTest("Login Check", "This test will verify the valid user login");

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		home.clickOnSignIn();

		logger.log(LogStatus.INFO, "Sign in Completed");

		home.verifyHomePageLanding();

		logger.log(LogStatus.PASS, "Home Page verified");

		login.loginToApplication("wcharlesivory@gmail.com", "Asdf1234");

		login.verifyLogin();

		logger.log(LogStatus.PASS, "Login Verified");

	}

}
