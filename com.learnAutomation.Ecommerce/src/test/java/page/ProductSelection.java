package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utility.Utility;
import utility.Validation;

public class ProductSelection 
{
	WebDriver driver;

	public ProductSelection(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[3]/a")
	WebElement tShirt;

	@FindBy(xpath = "//span[contains(text(),'Quick view')]")
	WebElement tShirtMouseHover;

	@FindBy(xpath = ".//*[@id='add_to_cart']/button")
	WebElement addToCart;

	@FindBy(xpath = ".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
	WebElement proceedCheckout;

	@FindBy(xpath = "(//span[@class='ajax_cart_quantity'])[1]")
	WebElement count;

	@SuppressWarnings("deprecation")
	public void pickTShirts() throws InterruptedException {

		tShirt.click();

		Thread.sleep(3000);

		Actions act = new Actions(driver);

		act.moveToElement(tShirtMouseHover).pause(2000).click().build().perform();

		Thread.sleep(10000);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")));

		addToCart.click();

		driver.switchTo().defaultContent();

		Thread.sleep(3000);

		proceedCheckout.click();

		Thread.sleep(3000);

		String productCount = count.getAttribute("innerHTML");

		System.out.println("Total product added is " + productCount);
	}
	
	@SuppressWarnings("deprecation")
	public void pickTShirtsNew()   {

		
		Utility.waitForWebElement(driver, tShirt, 10).click();
		
		Actions act = new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[1]/div"))).perform();

		act.moveToElement(tShirtMouseHover).pause(2000).click().build().perform();

		Utility.waitForFrameAndSwitch(driver, driver.findElement(By.xpath("//iframe[contains(@id,'fancybox-frame')]")), 20);
		
		Utility.waitForWebElement(driver, addToCart, 20).click();
		
		driver.switchTo().defaultContent();

		Utility.waitForWebElement(driver, proceedCheckout, 20).click();

		String productCount = Utility.waitForWebElement(driver, count, 20).getAttribute("innerHTML");

		Validation.validate(productCount, "1");
		
	}

}
