package com.ThorneAut;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ThorneAut.BaseClass.TestBase;


@Listeners(com.ThorneAut.TestListner.ExtentReportListener.class)
public class DemoTC extends TestBase  {
	
	public DemoTC()
	{
		super();
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() throws MalformedURLException
	{
		initialization();
	}
	@Test(enabled = true, priority =1)
	public void VerifySignupTC() throws InterruptedException {
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("@type,'submit'")).click();
		if(driver.findElement(By.xpath("//div[text()='Welcome to Thorne Lab']")).isDisplayed()){
			System.out.println("***********URL is opened - TC Pass******************");	
		}else {
			System.out.println("***********URL is not opened - TC Fail******************");
		}	
	}
	
}
