package com.jch.rac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class LoginPage {
	
	static By mobileNoTab = By.xpath("//android.widget.TextView[@text='Mobile No.']");
	static By IndianCountryCode = By.id("com.jch_hitachi.aircloudglobal:id/text_view_country_number_code_login");
	static By mobileNumberTextField = By.id("com.jch_hitachi.aircloudglobal:id/edit_text_mobile_number");
	static By passwordTextField = By.id("com.jch_hitachi.aircloudglobal:id/edit_text_enter_passwordd");
	static By loginButton = By.id("com.jch_hitachi.aircloudglobal:id/button_login");
	static By emailTab= By.id("com.jch_hitachi.aircloudglobal:id/text_view_email_forgot_password");
	static By emailAddressTextField = By.id("com.jch_hitachi.aircloudglobal:id/edit_text_enter_email");
	
	@Step("Verify Login page")
	public static void verifyLoginPage(AppiumDriver<MobileElement> pdriver) {
		WebDriverWait wait = new WebDriverWait(pdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNoTab));
		Assert.assertEquals(pdriver.findElement(mobileNoTab).getText(), "Mobile No.");
	}

	@Step("Verify India country code")
	public static void verifyIndiaCountryCode(AppiumDriver<MobileElement> pdriver) throws InterruptedException {
		String IndiaCode = pdriver.findElement(IndianCountryCode).getText();
		if(IndiaCode == "+91") {
			System.out.println("India country code is selected");
		}
	}
	
	@Step("Enter Mobile number: {1}")
	public static void enterMobileNumber(AppiumDriver<MobileElement> pdriver, String mobileNumber) {
		pdriver.findElement(mobileNumberTextField).sendKeys(mobileNumber);
	}
	
	@Step("Enter Password")
	public static void enterPassword(AppiumDriver<MobileElement> pdriver, String Password) { 
		pdriver.findElement(passwordTextField).sendKeys(Password);
	}
	
	@Step("Tap Login button")
	public static void tapLoginButton(AppiumDriver<MobileElement> pdriver) { 
		Boolean loginButtonStatus = pdriver.findElement(loginButton).isEnabled();
		if(loginButtonStatus== true) {
			pdriver.findElement(loginButton).click();
		}
	}
	
	@Step("Tap Email tab")
	public static void tapEmailTab(AppiumDriver<MobileElement> pdriver) {
		pdriver.findElement(emailTab).click();
	}
	
	@Step("Enter Email address:{1}")
	public static void enterEmailAddress(AppiumDriver<MobileElement> pdriver, String emailAddress) {
		WebDriverWait wait = new WebDriverWait(pdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressTextField));
		pdriver.findElement(emailAddressTextField).sendKeys(emailAddress);
	}
}