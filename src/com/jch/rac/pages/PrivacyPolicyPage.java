package com.jch.rac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class PrivacyPolicyPage {
	
	static By privacyScreen = By.id("com.jch_hitachi.aircloudglobal:id/text_view_privacy_policy");
	static By iAgreeButton = By.id("com.jch_hitachi.aircloudglobal:id/button_i_agree_privacy_policy");
	
	@Step("Check Privacy Policy Screen is displayed")
	public static Boolean checkPrivacyPolicyScreenDisplayed(AppiumDriver<MobileElement> pdriver) {
		try{
			Boolean privacyFlag = pdriver.findElement(privacyScreen).isDisplayed();
			System.out.println("Privacy Policy pop-up is displayed");
			return privacyFlag;
		}catch(NoSuchElementException e) {
			return false;
		}
	}

	@Step("Accept the Privacy Policy")
	public static void iAgreePrivacy(AppiumDriver<MobileElement> pdriver) {
		try {
			pdriver.findElement(iAgreeButton).click();
		}catch(NoSuchElementException e) {
			System.out.print("Privacy Policy pop-up is not displayed. Please continue to login to your App or create account");
		}
	}
}