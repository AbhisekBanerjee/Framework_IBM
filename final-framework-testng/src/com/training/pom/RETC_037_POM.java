package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_037_POM {
	private WebDriver driver;
	String str = "";
	Actions act;

	public RETC_037_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "PLOTS") // find villa by xpath
	private WebElement we_Plots;

	public void clkOnPlot() {
		this.we_Plots.click();

	}

	@FindBy(xpath = "//input[contains(@id,'search')]") // find search box by
	// xpath
	private WebElement we_SrchBx;

	public void entrTxt(String str) {
		this.we_SrchBx.clear();
		this.we_SrchBx.sendKeys(str);
		this.we_SrchBx.sendKeys(Keys.TAB);
	}

	@FindBy(xpath = "//div[@class='fs-content']//div[3]//div[1]/button") // find
	// search
	// button
	// by
	// xpath
	private WebElement we_SrchBtn;

	public void clkSrchBtn() {
		we_SrchBtn.click();
	}

	@FindBy(xpath = "//div[@id='ajaxsearchlite2']//input[@placeholder='Search here for Properties..']") // find_SearchTextBOxField

	private WebElement we_Text;

	public void enterText(String str) {

		this.we_Text.clear();
		this.str = str;
		this.we_Text.sendKeys(str);

	}
	
	@FindBy(xpath = "//span[@class='overlap']/ancestor::a") // find LINK by
	// xpath
	private WebElement we_searchlink;

	public void clkonLnk() {
		String s = this.we_searchlink.getText();
		WebElement web = this.driver.findElement(By.linkText(s));
		web.click();

	}
	@FindBy(xpath = "//a[contains(@href,'/contact/')]") // find drop us a line
	// by xpath
	private WebElement we_DrpLine;

	public void clkOnDrpLine() {
		String s = this.we_DrpLine.getText();
		WebElement web = this.driver.findElement(By.linkText(s));
		web.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Your Name']") // find txt box

	private WebElement we_TxtBx;

	public void entrName(String name) {
		this.we_TxtBx.clear();
		this.we_TxtBx.sendKeys(name);
	}

	@FindBy(xpath = "//input[@placeholder='Email Address']") // find mail box

	private WebElement we_eMlBx;

	public void entrEmail(String eMail) {
		this.we_eMlBx.clear();
		this.we_eMlBx.sendKeys(eMail);
	}

	@FindBy(xpath = "//input[@placeholder='Subject']") // find mail box

	private WebElement we_Sub;

	public void entSUB(String sUB) {
		this.we_Sub.clear();
		this.we_Sub.sendKeys(sUB);
	}

	@FindBy(xpath = "//textarea[@placeholder='Message']") // find mail box

	private WebElement we_Msg;

	public void entMSG(String msg) {
		this.we_Msg.clear();
		this.we_Msg.sendKeys(msg);
	}

	@FindBy(xpath = "//input[@value='Send']") // find mail box

	private WebElement we_Snd;

	public String clKSND() {

		this.we_Snd.click();
		String s= driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")).getText();
		return s;
	}

}
