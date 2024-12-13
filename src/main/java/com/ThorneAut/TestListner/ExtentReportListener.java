package com.ThorneAut.TestListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ThorneAut.Reports.ExtentReportSetup;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentReportListener extends ExtentReportSetup implements ITestListener


{

	private static String TestcaseName;
	public static String getTestcaseName() {
		return TestcaseName;
	}

	public static void setTestcaseName(String testcaseName) {
		TestcaseName = testcaseName;
	}
	public void onTestStart(ITestResult result) 
	{
		TestcaseName =result.getMethod().getDescription();
		setTestcaseName(TestcaseName);
		extentTest = extent.createTest(result.getMethod().getMethodName());
		extentTest.log(Status.INFO,  MarkupHelper.createLabel("Test is Started ::: " +result.getMethod().getMethodName(),ExtentColor.PURPLE));

	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest.log(Status.PASS,MarkupHelper.createLabel("Test Case Passed ::: " +result.getMethod().getMethodName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed ::: " +result.getMethod().getMethodName(), ExtentColor.RED));
		extentTest.log(Status.FAIL, result.getThrowable());

		try 
		{
			extentTest.addScreenCaptureFromPath(getScreenshot(driver, result.getMethod().getMethodName()));
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{
		extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test Case Skipped ::: " +result.getMethod().getMethodName(), ExtentColor.ORANGE));

		try 
		{
			extentTest.addScreenCaptureFromPath(getScreenshot(driver, result.getMethod().getMethodName()));
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onStart(ITestContext context) 
	{
		extent = ExtentReportSetup.extentReportSetup();
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}


	// Extent Report - 2.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("_MMddyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


}

