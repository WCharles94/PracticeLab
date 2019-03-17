package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//a[@class='logout']") WebElement signOut;
	
	
	public void clickOnSignIn() {
		signIn.click();

	}

	public void verifyHomePageLanding() {
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Store"));

	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}

}
