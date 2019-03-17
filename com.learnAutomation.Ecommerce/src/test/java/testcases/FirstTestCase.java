package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.BaseClass;
import page.HomePage;
import page.LoginPage;

public class FirstTestCase extends BaseClass
{
	
	@Test
	public void verifyValidUser()
	{
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		home.clickOnSignIn();
		
		home.verifyHomePageLanding();
		
		login.loginToApplication("wcharlesivory@gmail.com","Asdf1234");
		
		login.verifyLogin();
	
	}

}
