package com.jch.rac.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;

public class CustomListener extends CaptureScreenShot implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
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
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
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
