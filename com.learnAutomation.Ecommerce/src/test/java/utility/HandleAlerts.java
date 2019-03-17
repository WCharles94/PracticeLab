package utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {

	public static void acceptAlert(WebDriver driver,int time) {

		WebDriverWait wait=new WebDriverWait(driver, time);
		
		Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		
		alt.accept();
	}
	
	public static void dismissAlert(WebDriver driver,int time) {

	WebDriverWait wait=new WebDriverWait(driver, time);
		
		Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		
		alt.dismiss();
	}
	
	public static String getTextFromAlert(WebDriver driver,int time) {

		WebDriverWait wait=new WebDriverWait(driver, time);
		
		Alert alt=wait.until(ExpectedConditions.alertIsPresent());
		
		String text=alt.getText();
		
		return text;
	

	
	}

	
	
}
