package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_038_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_038_TEST {

	private static Properties properties;
	private WebDriver driver;
	private String baseUrl;
	private ScreenShot screenShot;
	private RETC_038_POM pomOBJ;
	String prntTab;

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
		pomOBJ = new RETC_038_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		prntTab = driver.getWindowHandle();
	}

	@AfterMethod
	public void tkScrnSht() {
		 screenShot.captureScreenShot("RETC_038");
	}

	@Test(priority = 1)
	public void clickOnVilla() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.clkOnVila();
	}

	@Test(priority = 2)
	public void clickOnSearchIcon() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.enterText("Nullam hendrerit apartment");
	}

	@Test(priority = 3)
	public void clkOnLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkonLnk();

	}

	@Test(priority = 4, dependsOnMethods = "clkOnLnk")
	public void backToParentWin() {
		pomOBJ.toggleTab(prntTab, new ArrayList<String>(driver.getWindowHandles()));
	}

	@Test(priority = 5)
	public void clkOnDrpLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkOnDrpLine();

	}

	@Test(priority = 6, dependsOnMethods = "clkOnDrpLnk")
	public void enterDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.entrName("Name_RETC038");
		pomOBJ.entrEmail("RETC038@gmail.com");
		pomOBJ.entSUB("SUB_RETC038");
		pomOBJ.entMSG("MSG_RETC038");
		String s = pomOBJ.clKSND();
		assertEquals(s, "There was an error trying to send your message. Please try again later.");
	}

}
