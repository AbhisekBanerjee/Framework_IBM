package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_007_POM;
import com.training.pom.RETC_008_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_008_TEST {

	private WebDriver driver;
	private String baseUrl;
	private RETC_008_POM pomOBJ;
	private static Properties properties;
	private ScreenShot screenShot;
	ExtentReports report;
	ExtentTest test;

	@BeforeSuite
	public void bfrSuit() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void bftTest() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pomOBJ = new RETC_008_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Actions act = new Actions(driver);

		report = new ExtentReports("./report/RETC_008.html");
		test=report.startTest("ReportCard");
	}

	@Test(priority = 1)
	public void clkOnAprtmntTbLnk() {
		boolean flag1=pomOBJ.mouseHoverOnAprtmnt();
		pomOBJ.clickOnLink();
		test.log(LogStatus.INFO, "Step1", "Click On Apartment Tab Link");
	}

	@Test(priority = 2,dependsOnMethods="clkOnAprtmntTbLnk")
	public void mortCalculation() {
		pomOBJ.setPrice("400000");
		pomOBJ.setDwnPmnt("2000");
		pomOBJ.setYr("20");
		pomOBJ.setInterest("7.5");
		pomOBJ.clkSndBtn();
		//assertEquals(pomOBJ.getdatafrmTXT(), "3061.26 Rs");
	}
}
