package com.jch.rac.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;
import com.jch.rac.configuration.BaseSetUp;
import com.jch.rac.pages.LoginPage;
import com.jch.rac.utility.CustomListener;
import com.jch.rac.utility.ReadingPropertiesFile;
import io.qameta.allure.Description;

@Listeners(CustomListener.class)
public class LoginTest extends BaseSetUp{

	@Test(priority=4, description = "Valid Login with valid email address and password.")
	@Description("Login to the Application with valid email address and password.")
	public void userLoginWithEmailAddress() throws InterruptedException, IOException {				
		LoginPage.tapEmailTab(driver);
		LoginPage.enterEmailAddress(driver, ReadingPropertiesFile.singlePropertiesUtils("EmailAddress"));
		LoginPage.enterPassword(driver, ReadingPropertiesFile.singlePropertiesUtils("EPassword"));
		LoginPage.tapLoginButton(driver);	
	}
	
	@Test(priority=5)
	public void failure() {
		Assert.assertEquals(false, true);
	}
}
