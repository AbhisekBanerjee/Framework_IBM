package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_068_POM {

	private WebDriver driver;

	public RETC_068_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "APARTMENTS")
	private WebElement Apartmentslink;

	@FindBy(xpath = "//*[@id=\"wrapper\"]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/a/div[2]/span")
	private WebElement DuisVitaeLink;

	@FindBy(id = "amount")
	private WebElement SalePrice;

	@FindBy(id = "downpayment")
	private WebElement DwnPymnt;

	@FindBy(id = "years")
	private WebElement LoanTrm;

	@FindBy(id = "interest")
	private WebElement IntRate;

	@FindBy(xpath = "//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button")
	private WebElement CalculateBtn;

	public void clickOnApartmentsLink() {
		this.Apartmentslink.click();
	}

	public void clickOnDuisVitaeLink() {
		this.DuisVitaeLink.click();
	}

	public void sendSalePrice(String Amount) {
		this.SalePrice.clear();
		this.SalePrice.sendKeys(Amount);
	}

	public void sendDownPayment(String downpymnt) {
		this.SalePrice.clear();
		this.SalePrice.sendKeys(downpymnt);
	}

	public void sendLoanTerm(String Years) {
		this.LoanTrm.clear();
		this.LoanTrm.sendKeys(Years);
	}

	public void sendInterestRate(String irate) {
		this.IntRate.clear();
		this.IntRate.sendKeys(irate);
	}

	public void clickOnCalculateButton() {
		this.CalculateBtn.click();
	}

}
