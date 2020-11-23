package com.jch.rac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class IntroductionPage {
	static Boolean introStatus = null;

	static By introductionScreenTitle = By.xpath("//android.widget.TextView[@text='airCloud Home']");
	static By continueButton = By.xpath("//android.widget.Button[@text='Continue']");
	static By skipButton = By.xpath("//android.widget.TextView[@text='Skip']");
	static By getStartedButton = By.xpath("//android.widget.Button[@text='Get Started']");

	@Step("Check the Introduction Screen is displayed")
	public static Boolean checkIntroScreenDisplayed(AppiumDriver<MobileElement> pdriver) {
		try {
			introStatus = pdriver.findElement(introductionScreenTitle).isDisplayed();
			System.out.println("Introduction Screen is displayed");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Step("Verify the Introduction Screen")
	public static void verifyIntroductionScreen(AppiumDriver<MobileElement> pdriver) {
		WebDriverWait wait = new WebDriverWait(pdriver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(introductionScreenTitle));
		Assert.assertEquals(pdriver.findElement(introductionScreenTitle).getText(), "airCloud Home");
	}

	@Step("Navigate from Screen 1 to Screen 2")
	public static void screenOneAndTwo(AppiumDriver<MobileElement> pdriver) {
		WebDriverWait wait = new WebDriverWait(pdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		pdriver.findElement(continueButton).click();
	}

	@Step("Navigate from Screen 2 to Screen 3")
	public static void screenThree(AppiumDriver<MobileElement> pdriver) {
		WebDriverWait wait = new WebDriverWait(pdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getStartedButton));
		pdriver.findElement(getStartedButton).click();
	}
}