package com.jch.rac.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.jch.rac.configuration.BaseSetUp;

public class CaptureScreenShot extends BaseSetUp{
	public static void getScreenShotOfFailureTest(String testMethodName) {
		try {
			TakesScreenshot image = (TakesScreenshot)driver;
			File sourceImage = image.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceImage, new File("./ScreenShots/"+"failedshot_"+testMethodName+".jpg"));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static byte[] getScreenShotForAllure() {
		try {
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		}
		catch(Exception e) {
			return null; 
		}
	}
}
