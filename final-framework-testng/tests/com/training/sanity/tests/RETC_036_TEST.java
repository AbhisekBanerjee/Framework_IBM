package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_036_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_036_TEST {
	private static Properties properties;
	private WebDriver driver;
	private String baseUrl;
	private ScreenShot screenShot;
	private RETC_036_POM pomOBJ;

	WebDriverWait wait;

	@BeforeSuite
	public void bfrSuit() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void bftTest() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pomOBJ = new RETC_036_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		// wait= new WebDriverWait(driver, 5000);
		driver.get(baseUrl);
		// driver.
		// Actions act = new Actions(driver);
	}

	@AfterMethod
	public void tkScrnSht() {
		screenShot.captureScreenShot("RETC_036");
	}

	@Test(priority = 1)
	public void clickOnVilla() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.clkOnVila();

	}

	@Test(priority = 2, dependsOnMethods = "clickOnVilla")
	public void clickOnSearchIcon() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.clkOnSearchIcon();
	}

	@Test(priority = 3, dependsOnMethods = "clickOnSearchIcon")
	public void enterValueTextBox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.enterText("Nullam hendrerit apartment");

	}

	@Test(priority = 4, dependsOnMethods = "enterValueTextBox")
	public void clkOnLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkonLnk();

	}

	@Test(priority = 5, dependsOnMethods = "clkOnLnk")
	public void clkOnDrpLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkOnDrpLine();

	}

	@Test(priority = 6, dependsOnMethods = "clkOnDrpLnk")
	public void enterDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.entrName("Name_RETC036");
		pomOBJ.entrEmail("RETC036@gmail.com");
		pomOBJ.entSUB("SUB_RETC036");
		pomOBJ.entMSG("MSG_RETC036");
		String s =pomOBJ.clKSND();
		assertEquals(s, "There was an error trying to send your message. Please try again later.");

	}
}
