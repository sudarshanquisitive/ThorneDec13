package com.ThorneAut.BaseClass;
import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	public static WebDriver driver;
	public static Properties property;
	public static ChromeOptions chromeOptions;
	public static Logger Log;
	public static String URL;

	public TestBase()
	{
		Log = Logger.getLogger(this.getClass());
		try 
		{
			property = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/ThorneAut/Configuration/Configuration.properties");
			property.load(inputStream);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void setLog4j() throws AWTException
	{

		setDateForLog4j();
		System.out.println("Before test");

	}

	public void initialization() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		String URL= property.getProperty("appURL").trim();
		System.out.println("URL is "+URL);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void endReport() throws AWTException 
	{

	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() throws Exception
	{
		driver.quit();
		//		try{
		//		    driver.quit();
		//		   }catch (Exception e){
		//		      System.out.println("Nothing to do with it");
		//		      }
		Log.info("Browser Terminated");
		Log.info("-----------------------------------------------");
		Log.info("Closing"); 

	}

	// Set Date For Log4J.
	public static void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_MMddyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./resources/log4j.properties");
	}


}
