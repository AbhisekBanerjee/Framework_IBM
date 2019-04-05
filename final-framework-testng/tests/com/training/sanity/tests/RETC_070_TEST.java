package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.pom.RETC_070_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.ExtntRpt;

public class RETC_070_TEST {

	private WebDriver driver;
	private String adminUrl;
	private RETC_070_POM retc70pom;
	private static Properties properties;

	ExtntRpt rptOb = new ExtntRpt();
	String d = System.getProperty("user.dir");
	String repLoc = d + "\\report\\RETC_070.html";

	ExtentReports reports = new ExtentReports("./report/RETC_070.html", true);
	ExtentTest test = reports.startTest("ReportCard");

	@Test
	public void PublishFeature() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit
		// wait

		// login as admin
		retc70pom.sendUsername("admin");
		test.log(LogStatus.INFO, "Step1", "User Name Entered.");
		// rptOb.getExtntRpt(repLoc, "ReportCard", "Pass", "Step-1", "Test");
		retc70pom.sendPassword("admin@123");
		test.log(LogStatus.INFO, "Step2", "Password Entered.");

		retc70pom.clickSignInBtn();
		test.log(LogStatus.INFO, "Step3", "Click on SignIn Button.");
		// add new feature
		retc70pom.clickOnPropertiesLink();
		test.log(LogStatus.INFO, "Step4", "Click on Properties Link.");
		retc70pom.clickOnFeaturesLink();
		test.log(LogStatus.INFO, "Step5", "Click on Features Link.");
		retc70pom.enterFeatureName("New Launches");
		test.log(LogStatus.INFO, "Step6", "Entered Features Name.");
		retc70pom.enterFeatureSlug("launch");
		test.log(LogStatus.INFO, "Step7", "Entered Slug Name.");
		retc70pom.enterFeatureDescription("New Launches of villas, apartments, flats");
		test.log(LogStatus.INFO, "Step8", "Entered Feature Description.");
		retc70pom.clickOnAddNewFeatureBtn();
		test.log(LogStatus.INFO, "Step9", "Click on AddNewFeature Button.");
		// add new property
		retc70pom.clickOnAddNewLink();
		test.log(LogStatus.INFO, "Step10", "Click on AddNewLink of property.");
		retc70pom.enterPropertyTitle("prestige");
		System.out.println("Property title entered.");
		retc70pom.enterPropertyContent("home town");
		retc70pom.clickPropertyPublishBtn();
		test.log(LogStatus.INFO, "Step11", "Click on Property Publish.");
		System.out.println("Property published!!!!");
		// publish the feature created
		retc70pom.clickCheckBox();
		retc70pom.clickFeaturePublishBtn();
		// logout
		retc70pom.mouseOverHowdyAdmin();
		retc70pom.clickOnLogOut();
		// search the property created
		retc70pom.clickOnRealEstate();
		retc70pom.enterPropertynameInSearchBox("prestige");
		// verify the searched property is displayed
		assertTrue(retc70pom.CheckForSearchedNamePresent());
		reports.endTest(test);

		reports.flush();

	}

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		// launch browser and open user URL
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		retc70pom = new RETC_070_POM(driver);
		adminUrl = properties.getProperty("adminURL");
		// open the browser
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}
}
