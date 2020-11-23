package com.jch.rac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class LanguageSelectionPage {
	static Boolean languageStatus = null;
	static Boolean defaultLanguageStatus = null;
	static String languageModalTitle = null;
	
	static By languageModalHeader = By.xpath("//android.widget.TextView[@text='Select Language']");
	static By defaultEnglish = By.xpath("android.widget.TextView[@resource-id='com.jch_hitachi.aircloudglobal:id/text_view_language_english_item']/following-sibling::android.widget.ImageView[@index='3']");
	static By englishRow = By.xpath("//android.widget.TextView[@text='English']");
	static By selectedTickMarkIcon = By.id("com.jch_hitachi.aircloudglobal:id/image_view_selected_langauge");
	static By applyButton = By.xpath("//android.widget.Button[@text='Apply']");
	
	@Step("Check Language Modal is displayed")
	public static boolean checkLanguageModalIsDisplayed(AppiumDriver<MobileElement> pdriver) {
		try {
			languageStatus = pdriver.findElement(languageModalHeader).isDisplayed();
			System.out.println("Select Language modal is displayed. Please select a language");
			Assert.assertEquals(pdriver.findElement(languageModalHeader).getText(), "Select Language");
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@Step("Select the Language")
	public static void selectLanguage(AppiumDriver<MobileElement> pdriver, String language) {
		defaultLanguageStatus = pdriver.findElement(selectedTickMarkIcon).isDisplayed();
		if(defaultLanguageStatus==true) {
			System.out.println("English language is selected by default");
		}
		else {
			pdriver.findElement(By.xpath("//android.widget.TextView[@text='"+language+"'")).click();
		}
	}

	@Step("Tap on Apply button")
	public static void tapOnApplyButton(AppiumDriver<MobileElement> pdriver) {
		pdriver.findElement(applyButton).click();
	}
}
