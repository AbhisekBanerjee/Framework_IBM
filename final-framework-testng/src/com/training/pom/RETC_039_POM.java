package com.training.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_039_POM {

	private WebDriver driver; 

	public RETC_039_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//locator and method of user name

	@FindBy(xpath="//input[@id='user_login']")
	private WebElement we_USRNM;

	public void setUSRNM(String str){
		this.we_USRNM.clear();
		this.we_USRNM.sendKeys(str);
	}

	//locator and method of password

	@FindBy(xpath="//input[@id='user_pass']")
	private WebElement we_PWD;

	public void setPWD(String str){
		this.we_PWD.clear();
		this.we_PWD.sendKeys(str);
	}
	
	//locator and method of submit

		@FindBy(xpath="//input[@value='Sign In']")
		private WebElement we_Sbmt;

		public void clkSBMT(){
			this.we_Sbmt.click();
		}

	//Locators and method of Post

	@FindBy(linkText="Posts")
	private WebElement PostsLink;
	
	public void clickPostsLink() {
		this.PostsLink.click();
		List<WebElement> al ;
		al= driver.findElements(By.xpath("//li[@id='menu-posts']"));
		int count=0;
		count=al.size();
		System.out.println(""+count);
	}

	@FindBy(linkText="Categories")
	private WebElement CategoriesLink; 

	@FindBy(linkText="All Posts")
	private WebElement AllPostsLink;

	@FindBy(id="tag-name")
	private WebElement catgName;

	@FindBy(id="tag-slug")
	private WebElement catgSlug; 

	@FindBy(id="tag-description")
	private WebElement catgDescrp;

	@FindBy(id="submit")
	private WebElement addnewcatgBtn;
	// now refresh the page to see the update

	@FindBy(xpath="//*[@id=\"wpbody-content\"]/div[3]/a")
	private WebElement addnewPostBtn;

	@FindBy(id="title-prompt-text")
	private WebElement PostTitleBox;

	@FindBy(id="content")
	private WebElement PostContentBox;

	@FindBy(xpath="//*[@id=\"in-category-656\"]")   // xpath to given depending on the name of the category created
	private WebElement categoryCheckBox;

	@FindBy(id="publish")
	private WebElement PublishBtn;

	@FindBy(id="message")
	private WebElement SuccessMsg;      // Post published. View post

	//Methods

	

	public void clickCategoriesLink() {
		this.CategoriesLink.click();
	}

	public void enterCategoryName(String ctgname) {
		this.catgName.clear();
		this.catgName.sendKeys(ctgname);
	}

	public void enterCategorySlug(String ctgslug) {
		this.catgSlug.clear();
		this.catgSlug.sendKeys(ctgslug);
	}

	public void enterCategoryDescrptn(String ctgdesc) {
		this.catgDescrp.clear();
		this.catgDescrp.sendKeys(ctgdesc);
	}

	public void ClickAddNewCategoryBtn() {
		this.addnewcatgBtn.click();
		driver.navigate().refresh();  // to see the update
	}

	public void clickAllPostsLink() {
		this.AllPostsLink.click();
	}

	public void clickAddNewButton() {
		this.addnewPostBtn.click();
	}

	public void enterPostTitle(String title) {

		//this.PostTitleBox.sendKeys(title);

		Actions actions1 = new Actions(driver);
		actions1.moveToElement(PostTitleBox);
		actions1.click();
		actions1.sendKeys(title);
		actions1.build().perform();
	}

	public void enterPostContent(String contnt) {
		//this.PostContentBox.click();
		//this.PostContentBox.sendKeys(contnt);

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(PostContentBox);
		actions2.click();
		actions2.sendKeys(contnt);
		actions2.build().perform();

	}

	public void ClickCatgChkBox() {
		this.categoryCheckBox.click();
	}

	public void ClickPublishButton() {
		this.PublishBtn.click();
	}

	public String getSuccessMsg() {
		return this.SuccessMsg.getText();
	}

}
