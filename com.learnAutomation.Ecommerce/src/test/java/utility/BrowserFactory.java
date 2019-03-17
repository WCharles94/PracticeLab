package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver startBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();

			//options.addArguments("--start-fullscreen");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("credentials_enable_service", false);
			map.put("profile.password_manager_enabled", false);

			options.setExperimentalOption("prefs", map);

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			cap.setCapability(ChromeOptions.CAPABILITY, options);

			System.setProperty("webdriver.chrome.driver","E:\\Eclipse Workspace\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new FirefoxDriver(cap);
			
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);


		} else if (browser.equalsIgnoreCase("IE")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			driver = new InternetExplorerDriver(cap);
			
			driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

		} else if (browser.equalsIgnoreCase("")) {
			System.out.println("Browser Not supported");
		}

		return driver;
	}

}
