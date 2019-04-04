package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_066_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_066_TEST {

	private WebDriver driver;
	private String baseUrl;
	private RETC_066_POM retc66pom;
	private static Properties properties;
	private String actualColorCode;
	private String expectedColorCodeInRGB = "rgb(255,236,235)";

	// fetch the data from the specified excel sheet
	@Test(dataProvider = "excel-inputs-negative-TC66", dataProviderClass = LoginDataProviders.class)
	public void InvalidExcelInputInEnquiryTest(String Name, String Email, String Subject, String Message) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit
																			// wait

		retc66pom.clickOnApartmentsLink();
		retc66pom.clickOnDuisVitaeLink();
		retc66pom.sendEnquiryName(Name);
		retc66pom.sendEnquiryEmail(Email);
		retc66pom.sendEnquirySubject(Subject);
		retc66pom.sendEnquiryMessage(Message);
		retc66pom.clickOnSendButton();

		// Get value of Css property background_color of Email Textbox which
		// will be returned in RGB format.
		actualColorCode = driver.findElement(By.name("your-email")).getCssValue("background");
		System.out.println("Color code in RGB" + actualColorCode);

		assertEquals(actualColorCode, expectedColorCodeInRGB);

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
		retc66pom = new RETC_066_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
