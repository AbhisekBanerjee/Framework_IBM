package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.pom.RETC_068_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_068_TEST {

	private WebDriver driver;
	private String baseUrl;
	private RETC_068_POM retc68pom;
	private static Properties properties;

	// fetch the data from the specified excel sheet
	@Test(dataProvider = "excel-inputs-positive-TC68", dataProviderClass = LoginDataProviders.class)
	public void ValidExcelInputMortgageeTest(String Amt, String Dwnpy, String term, String rate)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit
																			// wait

		retc68pom.clickOnApartmentsLink();
		retc68pom.clickOnDuisVitaeLink();
		retc68pom.sendSalePrice(Amt);
		retc68pom.sendDownPayment(Dwnpy);
		retc68pom.sendLoanTerm(term);
		retc68pom.sendInterestRate(rate);
		retc68pom.clickOnCalculateButton();
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.xpath("//*[@id=\"widget_mortgage_calc_properties-4\"]/form/div[5]/div"))
				.isDisplayed());

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
		retc68pom = new RETC_068_POM(driver);
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
