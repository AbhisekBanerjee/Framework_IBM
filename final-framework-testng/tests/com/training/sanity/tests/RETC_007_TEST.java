package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_007_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_007_TEST {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	private RETC_007_POM pomOBJ;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);


	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pomOBJ = new RETC_007_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		Actions act = new Actions(driver);
		//act.mo
	}

	@Test(priority=1)
	public void mouseHovertoAprt() {
		
		pomOBJ.mouseHoverOnAprtmnt();
		pomOBJ.clickOnLink();
		pomOBJ.setName("Abhisek");
		pomOBJ.setEmail("xyz@gmail.com");
		pomOBJ.setSub("Test");
		pomOBJ.setMsg("Test Message");
		pomOBJ.clkSnd();
	}
}
