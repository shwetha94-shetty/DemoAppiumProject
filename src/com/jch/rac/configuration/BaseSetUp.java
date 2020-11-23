package com.jch.rac.configuration;

import java.io.IOException;
import java.net.MalformedURLException; 
import java.net.URL; 

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jch.rac.utility.CaptureScreenShot;
import com.jch.rac.utility.ExtentReport;

import io.appium.java_client.AppiumDriver; 
import io.appium.java_client.MobileElement; 
import io.appium.java_client.android.AndroidDriver;

public class BaseSetUp { 
	public static AppiumDriver<MobileElement> driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeSuite 
	public static void androidPhoneConfiguration() {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "My Phone");
		capability.setCapability("udid", "aa179bf0");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "10.0");
		capability.setCapability("appPackage", "com.jch_hitachi.aircloudglobal");
		capability.setCapability("appActivity", "com.jch.racWiFi.userManagement.view.viewImpl.UserManagementActivity");
		capability.setCapability("noReset", true);
 
		//Instantiate Appium driver 
		try { 
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capability); 
		} 
		catch(MalformedURLException e) {
			System.out.println(e.getMessage()); 
			driver.findElement(By.xpath("//android.widget.TextView[@text='Alert']"));
			System.out.println(driver.findElementById("com.jch_hitachi.aircloudglobal:id/text_view_confirm_dialog_sub_title").getText());
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	}
	
	@BeforeTest
	public void extentConfig() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/AndroidTestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("Operation System", "10.0");
		reports.setSystemInfo("Device", "Android");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("User Name", "Shwetha BG");
		htmlReporter.config().setDocumentTitle("Android Automation Testing Report");
		htmlReporter.config().setReportName("Shwetha BG");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = CaptureScreenShot.getScreenShotForExtent(result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test FAILED: ",  ExtentColor.RED));
			test.fail(result.getThrowable());
			test.fail("Snapshot below: "+test.addScreenCaptureFromPath(screenShotPath));
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test PASSED", ExtentColor.GREEN));
		}else {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test SKIPPED", ExtentColor.ORANGE));
		}
		reports.flush();
	}

	@AfterSuite 
	public static void tearDown() { 
		try { 
			driver.closeApp(); 
		}
		catch(Exception e) { 
			System.out.println(e.getMessage()); 
		} 
	} 
}