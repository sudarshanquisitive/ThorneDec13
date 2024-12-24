package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ThorneAut.BaseClass.GmailRead;
import com.ThorneAut.BaseClass.TestBase;
import com.ThorneAut.Reports.ExtentReportSetup;
import com.aventstack.extentreports.Status;


public class SignupPage extends TestBase {

	@FindBy(xpath="//button[text()='Register']")
	WebElement RegisterBtn;

	@FindBy(xpath="//div[text()='Welcome to Thorne Lab']")
	WebElement WelcomeThorneHeaderTitle;

	@FindBy(xpath="//h4[text()='Register for an account']")
	WebElement RegisterFormTitle;

	@FindBy(xpath="//input[@id='fname']")
	WebElement FirstName;

	@FindBy(xpath="//input[@id='lname']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	@FindBy(xpath="//input[@id='emailAgain']")
	WebElement EmailAgain;
	@FindBy(xpath="//input[@name='phone']")
	WebElement Phone;
	@FindBy(xpath="//input[@name='dob']")
	WebElement DateOfBirth;

	@FindBy(xpath="//input[@id='male']")
	WebElement GenderMale;

	@FindBy(xpath="//input[@id='asian']")
	WebElement SelectPrimaryRaceAsian;

	@FindBy(xpath="//input[@id='hispanic']")
	WebElement SelectPrimaryEthnicity;

	@FindBy(xpath="//select[@name='education']")
	WebElement SelectEducation;

	@FindBy(xpath="//input[@id='left']")
	WebElement LeftHanded;

	@FindBy(xpath="//select[@name='residence']")
	WebElement SelectCountry;

	@FindBy(xpath="//input[@id='address']")
	WebElement Address;

	@FindBy(xpath="//input[@id='address2']")
	WebElement Address2;
	@FindBy(xpath="//input[@id='city']")
	WebElement City;

	@FindBy(xpath="//select[@name='state']")
	WebElement SelectState;
	@FindBy(xpath="//input[@id='zip']")
	WebElement Zip;
	@FindBy(xpath="//label[text()='English']")
	WebElement PreferredLanguage;	
	@FindBy(xpath="//label[text()='Friend']")
	WebElement HowHearAboutUs;
	@FindBy(xpath="//input[@id='privacy']")
	WebElement PrivacyPolicy;
	@FindBy(xpath="//input[@id='terms']")
	WebElement TermsOfService;

	@FindBy(xpath="//button[text()='Submit']")
	WebElement SubmitBtn;

	@FindBy(xpath="//p[text()='Success! Check your email for login instructions.']")
	WebElement SignupSucessMsg;

	@FindBy(xpath="//button[text()='Continue to Login']")
	WebElement ContinueToLoginBtn;

	@FindBy(xpath="//img[@class='companyLogo']")
	WebElement ThorneLogo;

	@FindBy(xpath="//h1[text()='Sign in']")
	WebElement SignInHeaderTitle;

	@FindBy(xpath="//input[@id='email']")
	WebElement EmailLogin;
	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordLogin;

	@FindBy(xpath="//button[@id='next']")
	WebElement SignInBtnToLogin;

	@FindBy(xpath="//p[text()='Your password has expired, please change to a new password.']")
	WebElement ChangePwdPageTitle;

	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement NewPassword;
	@FindBy(xpath="//input[@id='reenterPassword']")
	WebElement ConfirmNewPassword;

	@FindBy(xpath="//button[@id='continue']")
	WebElement SubmitBtnInChangePwd;

	@FindBy(xpath="//button[text()='Begin Pre-Visit Assessments']")
	WebElement HomePage;

	@FindBy(xpath="//p[text()='Edit Profile']")
	WebElement EditProfile;

	@FindBy(xpath="//button[text()='Save Changes']")
	WebElement SaveChangesBtn;

	@FindBy(xpath="//button[text()='Cancel']")
	WebElement CancelBtn;

	@FindBy(xpath="//p[text()='Log Out']")
	WebElement Logout;
	
	@FindBy(xpath="//p[text()='Patient Pre-Screening']")
	WebElement PatientPreScreeningPageTitle;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement SignInBtn;
	
	@FindBy(xpath="//p[text()='Your password is incorrect']")
	WebElement PasswordAlertMsg;
	
	public static String email = "john13"+TestBase.dynamickey+"@gmail.com";
	public static String password = "Thornehealth@123#";
	public static String emailG = "menlohyd2b@gmail.com";
	
	public static String newPassword = "Test@123";
	public static String firstName = "John";
	public static String firstNameNew = "JohnOne";
	public static String emailE = "john132312153439@gmail.com";
	public static String passwordInvalid = "testing";

	public SignupPage()
	{
		PageFactory.initElements(driver, this);

	}

	public void ClickOnRegisterBtn() {
		RegisterBtn.click();
	}

	public boolean VerifyWelcomeThorneHeaderTitle() {
		return WelcomeThorneHeaderTitle.isDisplayed();
	}

	public boolean VerifyRegisterFormTitle() {
		return RegisterFormTitle.isDisplayed();
	}

	public void ClickOnGenderMale() {
		GenderMale.click();
	}
	public void ClickOnSelectPrimaryRaceAsian() {
		SelectPrimaryRaceAsian.click();

	}

	public void ClickOnSelectPrimaryEthnicity() {
		SelectPrimaryEthnicity.click();
	}

	public void ClickOnLeftHanded() {
		LeftHanded.click();
	}

	public void ClickOnPreferredLanguage() {
		PreferredLanguage.click();
	}

	public void ClickOnHowHearAboutUs() {
		HowHearAboutUs.click();
	}

	public void ClickOnPrivacyPolicy() {
		PrivacyPolicy.click();
	}
	public void ClickOnTermsOfService() {
		TermsOfService.click();
	}
	public void ClickOnSubmitBtn() {
		SubmitBtn.click();
	}

	public void SignupUser() throws InterruptedException {

		FirstName.click();
		FirstName.clear();
		FirstName.sendKeys(firstName);
		LastName.click();
		LastName.clear();
		LastName.sendKeys("Petrick");
		if (property.getProperty("ReadGmail").equals("Yes")) {
			System.out.println("Email is "+emailG);
			Email.click();
			Email.clear();
			Email.sendKeys(emailG);
			EmailAgain.click();
			EmailAgain.clear();
			EmailAgain.sendKeys(emailG);
		} else {
			System.out.println("Email is "+email);
			Email.click();
			Email.clear();
			Email.sendKeys(email);
			EmailAgain.click();
			EmailAgain.clear();
			EmailAgain.sendKeys(email);
		}

		Phone.click();
		Phone.clear();
		Phone.sendKeys("4357878787");
		DateOfBirth.click();
		DateOfBirth.clear();
		DateOfBirth.sendKeys("01/27/1988");
		ClickOnGenderMale();
		ClickOnSelectPrimaryRaceAsian();
		ClickOnSelectPrimaryEthnicity();
		Select drpEducation = new Select(driver.findElement(By.xpath("//select[@name='education']")));
		drpEducation.selectByValue("GED");
		ClickOnLeftHanded();
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='residence']")));
		drpCountry.selectByVisibleText("United States");
		Thread.sleep(3000);
		Address.click();
		Address.clear();
		Address.sendKeys("23DD");
		Address2.click();
		Address2.clear();
		Address2.sendKeys("Hill Park");
		City.click();
		City.clear();
		City.sendKeys("Chicago");
		Select drpState = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		drpState.selectByVisibleText("Texas");
		Zip.click();
		Zip.clear();
		Zip.sendKeys("21232");
		ClickOnPreferredLanguage();
		ClickOnHowHearAboutUs();
		ClickOnPrivacyPolicy();
		ClickOnTermsOfService();
		Thread.sleep(5000);
		ClickOnSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(VerifyPatientPreScreeningPageTitle(), "Patient Pre Screening Page is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Patient Pre Screening Page is displayed.");
		Log.info("Patient Pre Screening Page is displayed.");
		//click on submit in PatientPreScreening page
		ClickOnSubmitBtn();
		Thread.sleep(5000);
		Assert.assertTrue(VerifySignupSucessMsg(), "Signup Failure");
		ExtentReportSetup.extentTest.log(Status.INFO, "Signup Success");
		Log.info("Signup Success");
		ClickOnContinueToLoginBtn();
		Thread.sleep(10000);

	}

	
	public void SignupUserError() throws InterruptedException {

		FirstName.click();
		FirstName.clear();
		FirstName.sendKeys(firstName);
		LastName.click();
		LastName.clear();
		LastName.sendKeys("Petrick");
		System.out.println("Email is "+emailE);
		Email.click();
		Email.clear();
		Email.sendKeys(emailE);
		EmailAgain.click();
		EmailAgain.clear();
		EmailAgain.sendKeys(emailE);
		Phone.click();
		Phone.clear();
		Phone.sendKeys("4357878787");
		DateOfBirth.click();
		DateOfBirth.clear();
		DateOfBirth.sendKeys("01/27/1988");
		ClickOnGenderMale();
		ClickOnSelectPrimaryRaceAsian();
		ClickOnSelectPrimaryEthnicity();
		Select drpEducation = new Select(driver.findElement(By.xpath("//select[@name='education']")));
		drpEducation.selectByValue("GED");
		ClickOnLeftHanded();
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@name='residence']")));
		drpCountry.selectByVisibleText("United States");
		Thread.sleep(3000);
		Address.click();
		Address.clear();
		Address.sendKeys("23DD");
		Address2.click();
		Address2.clear();
		Address2.sendKeys("Hill Park");
		City.click();
		City.clear();
		City.sendKeys("Chicago");
		Select drpState = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		drpState.selectByVisibleText("Texas");
		Zip.click();
		Zip.clear();
		Zip.sendKeys("21232");
		ClickOnPreferredLanguage();
		ClickOnHowHearAboutUs();
		ClickOnPrivacyPolicy();
		ClickOnTermsOfService();
		Thread.sleep(5000);
		ClickOnSubmitBtn();
	}
	
	public boolean VerifySignupSucessMsg() {
		return SignupSucessMsg.isDisplayed();
	}
	public void ClickOnContinueToLoginBtn() {
		ContinueToLoginBtn.click();
	}

	public boolean VerifyThorneLogo() {
		return ThorneLogo.isDisplayed();
	}

	public boolean VerifySignInHeaderTitle() {
		return SignInHeaderTitle.isDisplayed();
	}


	public void Login() throws InterruptedException {

		if (property.getProperty("ReadGmail").equals("Yes")) {
			System.out.println("Pwd is "+GmailRead.PwdinEmail);
			EmailLogin.click();
			EmailLogin.clear();
			EmailLogin.sendKeys(emailG);
			Thread.sleep(3000);
			PasswordLogin.click();
			PasswordLogin.clear();
			PasswordLogin.sendKeys(GmailRead.PwdinEmail);
		} else {
			System.out.println("Pwd is "+password);
			EmailLogin.click();
			EmailLogin.clear();
			EmailLogin.sendKeys(email);
			Thread.sleep(3000);
			PasswordLogin.click();
			PasswordLogin.clear();
			PasswordLogin.sendKeys(password);
		}
		SignInBtnToLogin();
		Thread.sleep(5000);
	}

	public void SignInBtnToLogin() {
		SignInBtnToLogin.click();
	}
	public boolean VerifyChangePwdPageTitle() {
		return ChangePwdPageTitle.isDisplayed();
	}

	public void ChangePassword() throws InterruptedException {
		Assert.assertTrue(VerifyChangePwdPageTitle(), "Change password page is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Change password page is displayed.");
		Log.info("Change password page is displayed.");
		if (property.getProperty("ReadGmail").equals("Yes")) {
			Password.click();
			Password.clear();
			Password.sendKeys(GmailRead.PwdinEmail);
		} else {
			Password.click();
			Password.clear();
			Password.sendKeys(password);
		}
		NewPassword.click();
		NewPassword.clear();
		NewPassword.sendKeys(newPassword);
		ConfirmNewPassword.click();
		ConfirmNewPassword.clear();
		ConfirmNewPassword.sendKeys(newPassword);
		Thread.sleep(5000);
		ClickOnSubmitBtnInChangePwd();
		Thread.sleep(5000);

	}

	public void ClickOnSubmitBtnInChangePwd() {
		SubmitBtnInChangePwd.click();
	}
	public boolean VerifyHomePage() {
		return HomePage.isDisplayed();
	}

	public void ClickOnEmailInHomePage() {
		if (property.getProperty("ReadGmail").equals("Yes")) {
			WebElement emailInHome = driver.findElement(By.xpath("//p[text()='"+emailG+"']"));
			emailInHome.click();
		} else {
			WebElement emailInHome = driver.findElement(By.xpath("//p[text()='"+email+"']"));
			emailInHome.click();
		}
	}

	public boolean VerifyEditProfile() {
		return EditProfile.isDisplayed();
	}

	public boolean VerifyDataInEditProfile() {
		String FirstNameData = FirstName.getAttribute("value");
		System.out.println("First name in edit profile is "+ FirstNameData);
		return FirstNameData.equals(firstName);
	}

	public void ClickOnSaveChangesBtn() {
		SaveChangesBtn.click();
	}

	public void EditProfile() throws InterruptedException {
		Thread.sleep(5000);
		ClickOnEmailInHomePage();
		Thread.sleep(5000);
		Assert.assertTrue(VerifyEditProfile(), "Edit Profile modal popup is not displayed.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Edit Profile modal popup is displayed.");
		Log.info("Edit Profile modal popup is displayed.");
		Assert.assertTrue(VerifyDataInEditProfile(), "Updated data is not displayed in Edit Profile modal popup.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Updated data is displayed in Edit Profile modal popup.");
		Log.info("Updated data is displayed in Edit Profile modal popup.");
		FirstName.click();
		FirstName.clear();
		FirstName.sendKeys(firstNameNew);
		Thread.sleep(3000);
		ClickOnSaveChangesBtn();
		Thread.sleep(3000);
		ClickOnEmailInHomePage();
		Thread.sleep(5000);
		Assert.assertTrue(VerifyUpdatedDataAfterEditProfile(), "Updated First name data is not displayed in Edit Profile modal popup.");
		ExtentReportSetup.extentTest.log(Status.INFO, "Updated First name data is displayed in Edit Profile modal popup.");
		Log.info("Updated First name data is displayed in Edit Profile modal popup.");

	}
	public boolean VerifyUpdatedDataAfterEditProfile() {
		String FirstNameData = FirstName.getAttribute("value");
		System.out.println("After update the First name in edit profile the updated data is "+ FirstNameData);
		return FirstNameData.equals(firstNameNew);
	}

	public void ClickOnCancelBtn() {
		CancelBtn.click();
	}

	public void ClickOnLogout() throws InterruptedException {
		Thread.sleep(5000);	
		Logout.click();
	}

	public void CheckEmail() {
		if (property.getProperty("ReadGmail").equals("Yes")) {
			GmailRead.Email();
		}
	}
	
	public boolean VerifyPatientPreScreeningPageTitle() {
		return PatientPreScreeningPageTitle.isDisplayed();
	}
	
	public void ClickOnSignInBtn() {
		SignInBtn.click();
	}
	
	public void LoginInvalidPwd() throws InterruptedException {
		System.out.println("Invalid Pwd is "+passwordInvalid);
		EmailLogin.click();
		EmailLogin.clear();
		EmailLogin.sendKeys(emailE);
		Thread.sleep(3000);
		PasswordLogin.click();
		PasswordLogin.clear();
		PasswordLogin.sendKeys(passwordInvalid);
		SignInBtnToLogin();
		Thread.sleep(5000);
	}
	
	public boolean VerifyPwdErrorMessage() {
		return PasswordAlertMsg.isDisplayed();
	}
	public boolean VerifySignupError() {
		return SignupSucessMsg.isDisplayed();
	}
}
