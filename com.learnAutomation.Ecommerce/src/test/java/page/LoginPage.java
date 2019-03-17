package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = ".//*[@id='email']")
	WebElement userName;

	@FindBy(xpath = ".//*[@id='passwd']")
	WebElement passWord;

	@FindBy(id = "SubmitLogin")
	WebElement loginButton;



	public void loginToApplication(String uname,String pass) {
		userName.sendKeys(uname);
		passWord.sendKeys(pass);
		loginButton.click();
	}

	public void verifyLogin() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
	    WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='logout']")));
	    Assert.assertTrue(element.isDisplayed());
	    
	}

}
