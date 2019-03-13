package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.training.generics.GenericMethods;

public class AppartmentPOM {
	private WebDriver driver;
	 
	 

	public AppartmentPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Apartments')]")
	private WebElement apprtmnt;

	public void clickApptmnt() {
		this.apprtmnt.click();
	}

	@FindBy(id = "keyword_search")
	private WebElement aptmnt_AddTxt;

	public void enterAddress(String str) {
		this.aptmnt_AddTxt.clear();
		this.aptmnt_AddTxt.sendKeys(str);
		this.aptmnt_AddTxt.sendKeys(Keys.TAB);
	}

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/a[1]")
	private WebElement prptType;

	public void setPrptDrpdwn(String str) {
		//Actions act = new Actions(driver);
		//act.moveToElement(prptType).build().perform();
		this.prptType.click();
		//Select comb = new Select(this.prptType);
		//comb.

	}
}
