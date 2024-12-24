package com.ThorneAut;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Pages.SignupPage;
import com.ThorneAut.BaseClass.TestBase;
import com.ThorneAut.Reports.ExtentReportSetup;
import com.aventstack.extentreports.Status;

@Listeners(com.ThorneAut.TestListner.ExtentReportListener.class)
public class DemoTC extends TestBase  {

	SignupPage signupPage;
	public DemoTC()
	{
		super();
	}
	@BeforeMethod(alwaysRun=true)
	public void setUp() throws MalformedURLException
	{
		initialization();
		signupPage = new SignupPage();
	}
	@Test(priority=0)
	public void PatientRegisterSuccessfully_TC() throws InterruptedException, IOException {
		Assert.assertTrue(signupPage.VerifyWelcomeThorneHeaderTitle(), "Thorne Welcome page is not displayed");
		ExtentReportSetup.extentTest.log(Status.INFO, "Thorne Welcome page is displayed");
		Log.info("Thorne Welcome page is displayed");
		signupPage.ClickOnRegisterBtn();
		Assert.assertTrue(signupPage.VerifyRegisterFormTitle(), "Register form page is not displayed");
		ExtentReportSetup.extentTest.log(Status.INFO, "Register form page is displayed");
		Log.info("Register form page is displayed");
		signupPage.SignupUser();
		Assert.assertTrue(signupPage.VerifyThorneLogo(), "Thorne logo is not displayed in sign in page.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Thorne logo is displayed in sign in page.");
		Log.info("Thorne logo is displayed in sign in page");
		Assert.assertTrue(signupPage.VerifySignInHeaderTitle(), "Sign in page is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Sign in page is displayed.");
		Log.info("Sign in page is displayed.");
		signupPage.CheckEmail();
		signupPage.Login();		
		signupPage.ChangePassword();
		Assert.assertTrue(signupPage.VerifyHomePage(), "Home page is not displayed after sucessfull sign up.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Home page is displayed after sucessfull sign up");
		Log.info("Home page is displayed after sucessfull sign up");
		signupPage.EditProfile();
		signupPage.ClickOnCancelBtn();
		signupPage.ClickOnLogout();
		Assert.assertTrue(signupPage.VerifyWelcomeThorneHeaderTitle(), "Logout error");
		ExtentReportSetup.extentTest.log(Status.INFO, "Logout successfully");
		Log.info("Logout successfully");
	}

	@Test(priority=1)
	public void TryingToLoginWithInvalidCredentials_TC() throws InterruptedException, IOException {
		Assert.assertTrue(signupPage.VerifyWelcomeThorneHeaderTitle(), "Thorne Welcome page is not displayed");
		ExtentReportSetup.extentTest.log(Status.INFO, "Thorne Welcome page is displayed");
		Log.info("Thorne Welcome page is displayed");
		signupPage.ClickOnSignInBtn();
		Assert.assertTrue(signupPage.VerifySignInHeaderTitle(), "Sign in page is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Sign in page is displayed.");
		Log.info("Sign in page is displayed.");
		signupPage.LoginInvalidPwd();	
		Assert.assertTrue(signupPage.VerifyPwdErrorMessage(), "--- Your password is incorrect ---Error message is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "--- Your password is incorrect ---Error message is displayed.");
		Log.info("--- Your password is incorrect ---Error message is displayed.");
	}

	@Test(priority=2)
	public void RegisteringWithExistingEmailNotAllowed_TC() throws InterruptedException, IOException {
		Assert.assertTrue(signupPage.VerifyWelcomeThorneHeaderTitle(), "Thorne Welcome page is not displayed");
		ExtentReportSetup.extentTest.log(Status.INFO, "Thorne Welcome page is displayed");
		Log.info("Thorne Welcome page is displayed");
		signupPage.ClickOnRegisterBtn();
		Assert.assertTrue(signupPage.VerifyRegisterFormTitle(), "Register form page is not displayed");
		ExtentReportSetup.extentTest.log(Status.INFO, "Register form page is displayed");
		Log.info("Register form page is displayed");
		signupPage.SignupUserError();
		ExtentReportSetup.extentTest.log(Status.INFO, "Signup Error");
		Assert.assertTrue(signupPage.VerifySignupError(), "Signup Error");
		ExtentReportSetup.extentTest.log(Status.INFO, "Signup Error");
		Log.info("Signup Error");
	}
}