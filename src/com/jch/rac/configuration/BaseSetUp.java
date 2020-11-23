package com.jch.rac.configuration;

import java.net.MalformedURLException; import java.net.URL; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities; 
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import
io.appium.java_client.AppiumDriver; import
io.appium.java_client.MobileElement; import
io.appium.java_client.android.AndroidDriver;
public class BaseSetUp { 
	public static AppiumDriver<MobileElement> driver;

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