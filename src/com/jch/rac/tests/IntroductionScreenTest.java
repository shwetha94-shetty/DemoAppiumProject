package com.jch.rac.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jch.rac.configuration.BaseSetUp;
import com.jch.rac.pages.IntroductionPage;
import com.jch.rac.utility.CustomListener;
import io.qameta.allure.Description;

@Listeners(CustomListener.class)
public class IntroductionScreenTest extends BaseSetUp{
	static Boolean introStatus = null;
	
	@Test(priority=2, description="App introduction screens for New Users")
	@Description("Introduction Screen")
	public void navigatingThroughIntroductionScreen() {
		test = reports.createTest("Navigate through Introduction Screen");
		introStatus = IntroductionPage.checkIntroScreenDisplayed(driver);
		
		if(introStatus == true) {
			IntroductionPage.verifyIntroductionScreen(driver);
			IntroductionPage.screenOneAndTwo(driver);
			IntroductionPage.screenOneAndTwo(driver);
			IntroductionPage.screenThree(driver);
		}
		else {
			System.out.println("Introduction Screen is not displayed.\n Please continue with Privacy Policy screen");
		}
	}
}