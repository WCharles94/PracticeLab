package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Config file failed to load " + e.getMessage());
		}

	}

	public String getApplicationURL() {
		return pro.getProperty("url");
	}
	
	
	public String getDataFromConfig(String key) {
		return pro.getProperty(key);
	}

}
