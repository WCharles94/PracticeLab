package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BaseClass;
import page.HomePage;
import page.LoginPage;
import utility.CustomLogger;

import com.relevantcodes.extentreports.LogStatus;

import freemarker.core.CustomAttribute;

public class FirstTestCase4 extends BaseClass {

	LoginPage login;
	HomePage home;
	
	@Test
	public void verifyValidUser() {

		logger = reports.startTest("Home Page Verification", "This test will verify the valid user login");

		home = PageFactory.initElements(driver, HomePage.class);

		login = PageFactory.initElements(driver, LoginPage.class);

		home.clickOnSignIn();

		CustomLogger.logInfo(logger, "Sign in Completed");
	
		home.verifyHomePageLanding();

		CustomLogger.logPass(logger, "Home Page verified");

	}
	
	@Test(dependsOnMethods="verifyValidUser")
	public void verifyLogin()
	{
		
		logger = reports.startTest("Login Page Verification", "This test will verify the valid user login");
		
		String user=excel.getStringData("Login",0,0);
		
		String pass=excel.getStringData("Login",0,1);
		
		login.loginToApplication(user,pass);

		login.verifyLogin();

		CustomLogger.logPass(logger, "Login Verified");
	
	}

}
