package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

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
	Double rndm = Math.random();
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
		// prntTab = driver.getWindowHandle();
		pomOBJ.setUSRNM("admin");
		pomOBJ.setPWD("admin@123");
		pomOBJ.clkSBMT();

	}

	@Test(priority = 1)
	public void clkOnPosts() {
		pomOBJ.clickPostsLink();
	}

	@Test(priority = 2)
	public void clkOnCategory() {
		pomOBJ.clickCategoriesLink();
	}

	@Test(priority = 3)
	public void enterCredential() {
		pomOBJ.enterCategoryName("Test_039_CatName" + rndm);
		pomOBJ.enterCategorySlug("Test_039_CatSlug" + rndm);
		pomOBJ.enterCategoryDescrptn("Test_039_CatDesc" + rndm);
		pomOBJ.clickAddNewCategoryBtn();
		clkOnPosts();// calling prior method.
	}

	@Test(priority = 4)
	public void clkOnAllPosts() {
		pomOBJ.clickAllPostsLink();
	}

	@Test(priority = 5)
	public void clkOnAddNewBtn() {
		pomOBJ.clickAddNewButton();
	}

	@Test(priority = 6)
	public void actionInAddNewPost() {
		pomOBJ.enterPostTitle("Test_039_NewPost" + rndm);
		
		pomOBJ.enterPostContent("Test_039_Content" + rndm);
	}

	@Test(priority = 7)
	public void clkOnChkBox() {
		pomOBJ.clickCatgChkBox();

	}

	@Test(priority = 8)
	public void clkOnPublish() throws InterruptedException {
		
		Thread.sleep(10000);
		pomOBJ.clickPublishButton();
		pomOBJ.getSuccessMsg();
		// assertEquals(pomOBJ.getSuccessMsg(), "Published");

	}

}
