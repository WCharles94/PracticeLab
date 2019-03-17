package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BaseClassHybrid;
import page.ProductSelection;
import utility.CustomLogger;

public class ThirdTestCase extends BaseClassHybrid {

	ProductSelection product;
	
	@Test
	public void selectProduct() throws InterruptedException {

		logger = reports.startTest("Select Product Scenario",
				"This test will verify whether user is able to select product from Portal");
		
		product=PageFactory.initElements(driver, ProductSelection.class);
		
		product.pickTShirtsNew();
		
		CustomLogger.logInfo(logger, "Product is Selected from Portal");
		

	}

}
