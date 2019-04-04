package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_006_POM {
	private WebDriver driver;
	Actions act;
	
	public RETC_006_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//driver.manage().timeouts().implicitlyWait(arg0, arg1)
		
	}
	
	
	@FindBy(xpath = "//ul[@id='responsive']//a[@class='sign-in']") // finding
	// login
	// link
	private WebElement login_link;

	@FindBy(id = "user_login") // finding user name.
	private WebElement userName;

	@FindBy(id = "user_pass") // finding password.
	private WebElement password;

	@FindBy(xpath = "//input[@value='Sign In']") // finding submit
	private WebElement submt;

	/*@FindBy(xpath = "//div[@class='user-name']") // findding dropdwn
	private WebElement drpdwn;
	*/

	@FindBy(xpath = "//ul[@class='my-account-nav']//a[contains(text(),'Log Out')]") // finding logout.
	private WebElement lgOut;

	public void clickLoginLink() {// click on login link.
		this.login_link.click();
	}

	public void sendUserName(String userName) {// passing user name
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {// passing password.
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {// click on submit.
		this.submt.click();
	}

	/*public void clickDrpDwn() {	
		act= new Actions(driver);
		act.moveToElement(this.drpdwn).build().perform();
		act.click();
	}*/

	public void clickLogOutBtn() {// click on submit.
		this.lgOut.click();
	}

}
