package com.jch.rac.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jch.rac.configuration.BaseSetUp;
import com.jch.rac.pages.PrivacyPolicyPage;
import com.jch.rac.utility.CustomListener;
import com.jch.rac.utility.ScrollScreen;
import io.qameta.allure.Description;

@Listeners(CustomListener.class)
public class PrivacyPolicyTest extends BaseSetUp {
	public final static String parentElement = "android.view.ViewGroup";
	public final static String childElement = "android.widget.Button";
	public final static String acceptButtonName = "I Agree";
	public final static String cancelButtonName = "Cancel";
	static Boolean privacyStatus = null;
	
	@Test(priority=3, description = "Accepting the privacy")
	@Description("Accept the privacy policy")
	public void acceptingPrivacy() throws InterruptedException {		
		privacyStatus = PrivacyPolicyPage.checkPrivacyPolicyScreenDisplayed(driver);
		
		if(privacyStatus == true) {
			//MobileElement acceptButton = ScrollScreen.scrollTopToBottom(driver, parentElement, childElement,acceptButtonName); 
			ScrollScreen.scrollTopToBottom(driver, parentElement, childElement,acceptButtonName); 
			//privacyPolicy.iAgreePrivacy(acceptButton);
			PrivacyPolicyPage.iAgreePrivacy(driver);
		}
		else {
			System.out.println("Privacy Policy pop-up is not displayed. Please continue to login to your App or create account");
		}
	}
}
