package com.training.sanity.tests;

import static org.testng.Assert.assertFalse;
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

public class RETC_069_TEST {

	private WebDriver driver;
	private String baseUrl;
	private RETC_068_POM retc69pom; // because POM for TC68 & TC69 are same
	private static Properties properties;

	// fetch the data from the specified excel sheet
	@Test(dataProvider = "excel-inputs-negative-TC69", dataProviderClass = LoginDataProviders.class)
	public void ValidExcelInputMortgageeTest(String Amt, String Dwnpy, String term, String rate)
			throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit
																			// wait

		retc69pom.clickOnApartmentsLink();
		retc69pom.clickOnDuisVitaeLink();
		retc69pom.sendSalePrice(Amt);
		retc69pom.sendDownPayment(Dwnpy);
		retc69pom.sendLoanTerm(term);
		retc69pom.sendInterestRate(rate);
		retc69pom.clickOnCalculateButton();
		Thread.sleep(3000);
		assertFalse(driver.findElement(By.xpath("//*[@id=\"widget_mortgage_calc_properties-4\"]/form/div[5]/div"))
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
		retc69pom = new RETC_068_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}
}
