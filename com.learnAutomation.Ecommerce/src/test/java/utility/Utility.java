package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static String getCurrentDateAndTime() {

		Date date = new Date();

		DateFormat ourCustomeFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		String timeStamp = ourCustomeFormat.format(date);

		return timeStamp;
	}

	public static String captureScreenShot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String directory = System.getProperty("user.dir");

		System.out.println(directory);

		String path=directory + "/Screenshots/" + Utility.getCurrentDateAndTime() + ".png";
		
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		
		return path;
	}



	public static void highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	
	public static void syncElement(WebDriver driver,WebElement element,int time)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static WebElement waitForWebElement(WebDriver driver,WebElement element,int time)
	{
		
		syncElement(driver, element, time);
		highLightElement(driver, element);
		
		return element;
		
	}
	
	public static void waitForFrameAndSwitch(WebDriver driver,WebElement element,int time)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		
	}
		

}
