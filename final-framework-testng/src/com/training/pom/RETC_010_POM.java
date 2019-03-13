package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_010_POM {
	private WebDriver driver;
	Actions act;

	public RETC_010_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "NEW LAUNCH")
	private WebElement nwlnch;

	public boolean mouseHoverOnNwLnch() {
		act = new Actions(driver);
		boolean flg = act.moveToElement(this.nwlnch).build().equals(null);
		if (flg == false)
			act.moveToElement(this.nwlnch).build().perform();
		return flg;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/header[1]/div[2]/nav[1]/div[1]/ul[1]/div[1]/div[1]/div[2]/div[2]/a")
	private WebElement lnk;

	public boolean clickOnLink() {
		boolean flg1 = mouseHoverOnNwLnch();
		boolean f2 = true;
		if (flg1 == false)
			f2 = act.moveToElement(this.lnk).build().equals(null);
		act.moveToElement(this.lnk).click().perform();
		return f2;
	}

	@FindBy(xpath = "//input[@name='your-name']")
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
