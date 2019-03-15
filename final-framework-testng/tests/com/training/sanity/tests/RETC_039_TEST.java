package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_039_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_039_TEST {


	private static Properties properties;
	private WebDriver driver;
	private String adminUrl;
	private ScreenShot screenShot;
	private RETC_039_POM pomOBJ;
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
		pomOBJ = new RETC_039_POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		driver.get(adminUrl);
		//prntTab = driver.getWindowHandle();
		pomOBJ.setUSRNM("admin");
		pomOBJ.setPWD("admin@123");
		pomOBJ.clkSBMT();
		
		pomOBJ.clickPostsLink();
	}
	
	
	
	

	@Test
	public void f() {
	}
}
