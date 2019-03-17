package page;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;
import testcases.Secondtestcase4;

public class BaseClass extends ExcelDataProvider{
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest logger;
	public static ExcelDataProvider excel;
	public ConfigDataProvider config;
	public static FileOutputStream fout;
	

	@BeforeSuite
	public void setupTestSuite() 
	{
		System.out.println("Before Suite is Getting Executed");

		reports = new ExtentReports(System.getProperty("user.dir") + "/Report/Report.html");
		
        excel=new ExcelDataProvider();
        
        config=new ConfigDataProvider();

		System.out.println("Report Setup is Done");
	}

	@BeforeClass
	public void startApplication() {

		System.out.println("Before Class is Getting Executed");

		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse Workspace\\Chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(config.getApplicationURL());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Application Started");
	}

	@AfterClass
	public void closeAppication() throws FileNotFoundException {
		driver.quit();
		System.out.println("After Class Executed");
		
		fout=new FileOutputStream(src);
		
		int status=Secondtestcase4.status.size();
		
		for(int i=0;i<status;i++) {
			
			excel.setDatatoExcel("login",i , Secondtestcase4.status.get(i), 2);
			
		}
		
	}

	@AfterMethod
	public void tearDownTest(ITestResult result) {
		int current_status = result.getStatus();

		if (current_status == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Completed Successfully");
			Secondtestcase4.status.add("Pass");
		} else if (current_status == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Failed- Kindly check the logs");
			logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
			Secondtestcase4.status.add("Fail");
		} else if (current_status == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Skipped- Kindly check the logs");
			Secondtestcase4.status.add("Skip");

		}

		reports.endTest(logger);

		System.out.println("After Method Executed");
	}

	@AfterSuite
	public void tearDowntestSuite() {
	
		reports.flush();
		excel.writeExcel();

		System.out.println("Test Suite Executed-After Suite Executed");
	}

}
