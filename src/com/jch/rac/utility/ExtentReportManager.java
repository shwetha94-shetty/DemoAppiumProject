package com.jch.rac.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	
	public static ExtentReports getExtentReportInstance() {
			htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/AndroidTestReport.html");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("Operation System", "10.0");
			extent.setSystemInfo("Device", "Android");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Shwetha BG");
			htmlReporter.config().setDocumentTitle("Android Automation Testing Report");
			htmlReporter.config().setReportName("Shwetha BG");
			htmlReporter.config().setTheme(Theme.DARK);
			
			return extent;
	}
}
