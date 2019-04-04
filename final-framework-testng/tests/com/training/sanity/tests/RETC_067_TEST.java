package com.training.sanity.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RETC_010_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_067_TEST {
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private RETC_010_POM pomOBJ;

	
	boolean f1,f2;
	
	@BeforeSuite
	public void bfrSuit() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void bftTest() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pomOBJ = new RETC_010_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		//Actions act = new Actions(driver);
	}
	
	@Test(priority = 1)
	public void clickOnNewLaunch() {
		f1=pomOBJ.mouseHoverOnNwLnch();
		f2=pomOBJ.clickOnLink();
	}
	@Test(priority=2, dataProvider="db-inputs",dataProviderClass= LoginDataProviders.class)
	public void enterCredential(String name,String email,String sub,String mes){
		pomOBJ.setName(name);
		pomOBJ.setEmail(email);
		pomOBJ.setSub(sub);
		pomOBJ.setMsg(mes);
		pomOBJ.clkSnd();
	}
}
