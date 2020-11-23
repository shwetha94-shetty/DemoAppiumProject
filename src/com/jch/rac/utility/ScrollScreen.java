package com.jch.rac.utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ScrollScreen {
	
	public static void scrollTopToBottom(AppiumDriver<MobileElement> driver, String parentElement, String childElement, String childtext) throws InterruptedException{
		try{
			driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().className(\""+parentElement+"\")).getChildByText("
				+ "new UiSelector().className(\""+childElement+"\"), \""+childtext+"\")"));
		}
		catch(Exception e) {
		}
	}
}
