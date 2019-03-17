package utility;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomLogger {

	public static void logInfo(ExtentTest logger, String msg) {
		logger.log(LogStatus.INFO, msg);
		System.out.println(msg);
	}

	public static void logPass(ExtentTest logger, String msg) {
		logger.log(LogStatus.PASS, msg);
		System.out.println(msg);
	}

	public static void logFail(ExtentTest logger, String msg) {
		logger.log(LogStatus.FAIL, msg);
		System.out.println(msg);
	}

	public static void logSkip(ExtentTest logger, String msg) {
		logger.log(LogStatus.SKIP, msg);
		System.out.println(msg);
	}

}
