package com.jch.rac.utility;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.jch.rac.configuration.BaseSetUp;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

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
	
	public static String getScreenShotForExtent(String screenShotName) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String destination = System.getProperty("./ScreenShots/"+"failedshot_"+screenShotName+".jpg");
		ImageIO.write(screenshot.getImage(), "JPG", new File(destination));
		return destination;
	}
}
