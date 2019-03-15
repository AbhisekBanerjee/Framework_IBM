package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RETC_037_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_037_TEST {

	private static Properties properties;
	private WebDriver driver;
	private String baseUrl;
	private ScreenShot screenShot;
	private RETC_037_POM pomOBJ;
	String parent_Window;

	@BeforeSuite
	public void bfrSuit() throws Throwable {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeTest
	public void bftTest() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		pomOBJ = new RETC_037_POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		parent_Window = driver.getWindowHandle();
		
	}

	@AfterMethod
	public void tkScrnSht() {
		screenShot.captureScreenShot("RETC_037");
	}

	@Test(priority = 1)
	public void clickOnPlots() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.clkOnPlot();
	}

	@Test(priority = 2)
	public void entrTxtBxAndClkOnSrch() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.entrTxt("Nullam hendrerit apartment");
		pomOBJ.clkSrchBtn();
	}

	@Test(priority = 3)
	public void enterValueTextBox() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.enterText("Nullam hendrerit apartment");

	}

	@Test(priority = 4)
	public void clkOnLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkonLnk();

	}

	@Test(priority = 5)
	public void backToParentWin() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		for (String s : tabs) {
			if (!s.equals(parent_Window)) {
				driver.switchTo().window(parent_Window);
			}

		}

	}

	@Test(priority = 6)
	public void clkOnDrpLnk() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait

		pomOBJ.clkOnDrpLine();

	}

	@Test(priority = 7)
	public void enterDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES); // implicit
		// wait
		pomOBJ.entrName("Name_RETC037");
		pomOBJ.entrEmail("RETC037@gmail.com");
		pomOBJ.entSUB("SUB_RETC037");
		pomOBJ.entMSG("MSG_RETC037");
		String s = pomOBJ.clKSND();
		assertEquals(s, "There was an error trying to send your message. Please try again later.");
		// assertEquals(s, "There was an error trying to send your message.
		// Please try again later.");
	}

}
