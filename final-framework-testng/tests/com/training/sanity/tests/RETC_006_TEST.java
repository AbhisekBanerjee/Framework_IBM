package com.training.sanity.tests;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_006_POM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_006_TEST {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	private RETC_006_POM ullPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	Actions act;
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		ullPOM = new RETC_006_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		act = new Actions(driver);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}

	@Test(priority = 0)
	public void clickLoginRegister() throws Throwable {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		ullPOM.clickLoginLink();
		screenShot.captureScreenShot("RETC_006");

		ullPOM.sendUserName("abhidasa");
		screenShot.captureScreenShot("RETC_006");
		ullPOM.sendPassword("real@1234");
		screenShot.captureScreenShot("RETC_006");
		ullPOM.clickLoginBtn();
		screenShot.captureScreenShot("RETC_006");
		
		//act.contextClick().build().perform();
		Thread.sleep(5000);
		//ullPOM.clickDrpDwn();
		ullPOM.clickLogOutBtn();
		screenShot.captureScreenShot("RETC_006");
		WebElement we = null;
		we = driver
				.findElement(By.xpath("/html[1]/body[1]/div[1]/div[4]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]"));
		boolean condition = we.isDisplayed();
		assertTrue(condition);
		screenShot.captureScreenShot("RETC_006");
	}
}
