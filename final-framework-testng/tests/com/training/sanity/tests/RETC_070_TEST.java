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
import com.training.pom.RETC_070_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_070_TEST {

	private WebDriver driver;
	private String adminUrl;
	private RETC_070_POM retc70pom;
	private static Properties properties;

	@Test
	public void PublishFeature() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit
																			// wait

		// login as admin
		retc70pom.sendUsername("admin");
		retc70pom.sendPassword("admin@123");
		retc70pom.clickSignInBtn();
		// add new feature
		retc70pom.clickOnPropertiesLink();
		retc70pom.clickOnFeaturesLink();
		retc70pom.enterFeatureName("New Launches");
		retc70pom.enterFeatureSlug("launch");
		retc70pom.enterFeatureDescription("New Launches of villas, apartments, flats");
		retc70pom.clickOnAddNewFeatureBtn();
		// add new property
		retc70pom.clickOnAddNewLink();
		retc70pom.enterPropertyTitle("prestige");
		System.out.println("Property title entered.");
		retc70pom.enterPropertyContent("home town");
		retc70pom.clickPropertyPublishBtn();
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
		driver.quit();
	}
}
