package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_008_POM {
	private WebDriver driver;
	Actions act;

	public RETC_008_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "APARTMENTS")
	private WebElement aprtmnt;

	public boolean mouseHoverOnAprtmnt() {
		act = new Actions(driver);
		boolean flg = act.moveToElement(this.aprtmnt).build().equals(null);
		if (flg == false)
			act.moveToElement(this.aprtmnt).build().perform();
		return flg;
	}

	@FindBy(xpath = "//div[@id='wpmm-megamenu']//div[@class='wpmm-post post-3765']//a[@title='prestige'][contains(text(),'prestige')]")
	private WebElement lnk;

	public boolean clickOnLink() {
		boolean flg1 = mouseHoverOnAprtmnt();
		boolean f2=true;
		if (flg1 == false)
			f2=act.moveToElement(this.lnk).build().equals(null);
			act.moveToElement(this.lnk).click().perform();
		return f2;
	}

	@FindBy(id = "amount")
	private WebElement amnt;

	public String setPrice(String str) {
		this.amnt.clear();
		this.amnt.sendKeys(str);
		String s1=this.amnt.getAttribute("value");
		return s1;
	}

	@FindBy(id = "downpayment")
	private WebElement dpmnt;

	public void setDwnPmnt(String str) {
		this.dpmnt.clear();
		this.dpmnt.sendKeys(str);
	}

	@FindBy(id = "years")
	private WebElement yr;

	public void setYr(String str) {
		this.yr.clear();
		this.yr.sendKeys(str);
	}

	@FindBy(id = "interest")
	private WebElement intrst;

	public void setInterest(String str) {
		this.intrst.clear();
		this.intrst.sendKeys(str);
	}

	@FindBy(xpath = "//form[1]/button")
	private WebElement btn;

	public void clkSndBtn() {
		this.btn.click();
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[4]/form[1]/div[5]/div[1]/strong[1]")
	private WebElement txtCmp;

	public String getdatafrmTXT() {
		String s2=txtCmp.getText();
		System.out.println(s2);
		return s2;
	}

}
