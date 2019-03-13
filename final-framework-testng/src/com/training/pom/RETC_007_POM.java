package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_007_POM {
	private WebDriver driver;
	Actions act;

	public RETC_007_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "APARTMENTS")
	private WebElement aprtmnt;

	public void mouseHoverOnAprtmnt() {
		act = new Actions(driver);
		act.moveToElement(this.aprtmnt).build().perform();
	}

	@FindBy(xpath = "//div[@id='wpmm-megamenu']//div[@class='wpmm-post post-3765']//a[@title='prestige'][contains(text(),'prestige')]")
	private WebElement lnk;

	public void clickOnLink() {
		mouseHoverOnAprtmnt();
		act.moveToElement(this.lnk).click().perform();
	}

	@FindBy(name = "your-name")
	private WebElement name;

	public void setName(String str) {
		this.name.clear();
		this.name.sendKeys(str);
	}

	@FindBy(name = "your-email")
	private WebElement email;

	public void setEmail(String str) {
		this.email.clear();
		this.email.sendKeys(str);
	}

	@FindBy(name = "your-subject")
	private WebElement sub;

	public void setSub(String str) {
		this.sub.clear();
		this.sub.sendKeys(str);
	}

	@FindBy(xpath = "//textarea[@name='your-message']")
	private WebElement msg;

	public void setMsg(String str) {
		this.msg.clear();
		this.msg.sendKeys(str);
	}
	
	@FindBy(xpath = "//input[@value='Send']")
	private WebElement snd;

	public void clkSnd() {
		this.snd.click();
	}
}
