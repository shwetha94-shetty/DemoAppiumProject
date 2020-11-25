package com.jch.rac.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jch.rac.configuration.BaseSetUp;
import com.jch.rac.pages.LanguageSelectionPage;
import com.jch.rac.utility.CustomListener;
import io.qameta.allure.Description;

@Listeners(CustomListener.class)
public class LanguageSelectionTest extends BaseSetUp {
	static Boolean languageModalStatus = null;
	
	@Test(priority=1, description="Select App language")
	@Description("Select the App language.")
	public void selectLanguage() {
		languageModalStatus = LanguageSelectionPage.checkLanguageModalIsDisplayed(driver);
		
		if(languageModalStatus==true) {
			LanguageSelectionPage.selectLanguage(driver, "English");
			LanguageSelectionPage.tapOnApplyButton(driver);
		}
		else {
			System.out.println("Language Selection modal is not displayed.\n Please continue with Introduction screen");
		}
	}
}
