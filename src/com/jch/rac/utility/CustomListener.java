package com.jch.rac.utility;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Attachment;

public class CustomListener extends CaptureScreenShot implements ITestListener {
		
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String failedMethodName = result.getMethod().getMethodName();
		System.out.println("Failed Test Cases");
		getScreenShotOfFailureTest(failedMethodName);
			
		System.out.println("Screenshot captured for test case:"+failedMethodName);
		saveScreenShotJPG();
		saveTextLog(failedMethodName+" failed  and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
	
	@Attachment(value="Page screenshot", type="image/jpg")
	public byte[] saveScreenShotJPG() {
		return getScreenShotForAllure();
	}
	
	@Attachment(value="{0}", type="text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
}
