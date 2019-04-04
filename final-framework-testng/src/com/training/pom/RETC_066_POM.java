package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_066_POM {

private WebDriver driver; 
	
	public RETC_066_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="APARTMENTS")
	private WebElement Apartmentslink;
	
	@FindBy(xpath="//*[@id=\"wrapper\"]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/a/div[2]/span")
	private WebElement DuisVitaeLink; 
	
	@FindBy(name="your-name")
	private WebElement EnqName;
	
	@FindBy(name="your-email")
	private WebElement EnqEmail;
	
	@FindBy(name="your-subject")
	private WebElement EnqSubject;
	
	@FindBy(name="your-message")
	private WebElement EnqMessage;
	
	@FindBy(xpath="//input[@type='submit' and @value='Send']")
	private WebElement SendBtn;
	
	public void clickOnApartmentsLink() {
		this.Apartmentslink.click();
	}
	
	public void clickOnDuisVitaeLink() {
		this.DuisVitaeLink.click();
	}
	
	public void sendEnquiryName(String eName) {
		this.EnqName.clear();
		this.EnqName.sendKeys(eName);
	}
	
	public void sendEnquiryEmail(String eMail) {
		this.EnqEmail.clear();
		this.EnqEmail.sendKeys(eMail);
	}
	
	public void sendEnquirySubject(String eSubject) {
		this.EnqSubject.clear();
		this.EnqSubject.sendKeys(eSubject);
	}
	
	public void sendEnquiryMessage(String eMessage) {
		this.EnqMessage.clear();
		this.EnqMessage.sendKeys(eMessage);
	}
	
	public void clickOnSendButton() {
		this.SendBtn.click();
	}
}
