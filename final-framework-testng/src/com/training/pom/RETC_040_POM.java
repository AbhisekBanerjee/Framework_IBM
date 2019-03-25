package com.training.pom;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_040_POM {
	String s1 = null;// this will be used to capture catagoryName and later will
	// be used to create dynamic xpath
	private WebDriver driver;

	public RETC_040_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locator and method of user name
	@FindBy(xpath = "//input[@id='user_login']")
	private WebElement we_USRNM;

	public void setUSRNM(String str) {
		this.we_USRNM.clear();
		this.we_USRNM.sendKeys(str);
	}

	// locator and method of password
	@FindBy(xpath = "//input[@id='user_pass']")
	private WebElement we_PWD;

	public void setPWD(String str) {
		this.we_PWD.clear();
		this.we_PWD.sendKeys(str);
	}

	// locator and method of submit
	@FindBy(xpath = "//input[@value='Sign In']")
	private WebElement we_Sbmt;

	public void clkSBMT() {
		this.we_Sbmt.click();
	}

	// Locators and method of Post
	@FindBy(linkText = "Posts")
	private WebElement PostsLink;

	public void clickPostsLink() {
		this.PostsLink.click();
		List<WebElement> al;
		al = driver.findElements(By.xpath("//li[contains(text(),'Posts')]/following-sibling::*"));
		int count = 0;
		count = al.size();
		for (int i = 0; i < count; i++) {
			System.out.println(al.get(i).getText());
		}
		// assert.assertEquals
	}

	// Locators and method of Category
	@FindBy(linkText = "Categories")
	private WebElement CategoriesLink;

	public void clickCategoriesLink() {
		this.CategoriesLink.click();
	}

	// Locators and method of CategoryName
	@FindBy(id = "tag-name")
	private WebElement catgName;

	public void enterCategoryName(String catgName) {
		this.s1 = catgName;
		this.catgName.clear();
		this.catgName.sendKeys(catgName);
	}

	// Locators and method of CategorySlug
	@FindBy(id = "tag-slug")
	private WebElement catgSlug;

	public void enterCategorySlug(String ctgslug) {
		this.catgSlug.clear();
		this.catgSlug.sendKeys(ctgslug);
	}

	// Locators and method of CategoryDescription
	@FindBy(id = "tag-description")
	private WebElement catgDescrp;

	public void enterCategoryDescrptn(String ctgdesc) {
		this.catgDescrp.clear();
		this.catgDescrp.sendKeys(ctgdesc);
	}

	// Locators and method of AddNewButton
	@FindBy(id = "submit")
	private WebElement addnewcatgBtn;

	public void clickAddNewCategoryBtn() {
		this.addnewcatgBtn.click();
		driver.navigate().refresh(); // to see the update
	}

	// Locators and method of AllPosts
	@FindBy(linkText = "All Posts")
	private WebElement AllPostsLink;

	public void clickAllPostsLink() {
		this.AllPostsLink.click();
	}

	// Locators and method of AddNewPost
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/a")
	private WebElement addnewPostBtn;

	public void clickAddNewButton() {
		this.addnewPostBtn.click();
	}

	// Locators and method of AddNewPost
	@FindBy(id = "title-prompt-text")
	private WebElement PostTitleBox;

	public void enterPostTitle(String title) {
		// this.PostTitleBox.sendKeys(title);
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(PostTitleBox);
		actions1.click();
		actions1.sendKeys(title);
		actions1.build().perform();
	}

	// Locators and method of ContentBox
	@FindBy(id = "content")
	private WebElement PostContentBox;

	public void enterPostContent(String contnt) {
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(PostContentBox);
		actions2.click();
		actions2.sendKeys(contnt);
		actions2.build().perform();
	}

	// Locators and method of checkbox
	// label[text()=' Test_039_CatName']/input
	// ul[@id='categorychecklist']/li/label/input
	@FindBy(xpath = "//label[text()=' Test_039_CatName']/input") // xpath to be
																	// given
																	// depending
																	// on the
																	// name of
																	// the
																	// category
																	// created
	private WebElement categoryCheckBox;

	public void clickCatgChkBox() {
		this.categoryCheckBox.click();
	}

	// Locators and method of publish
	@FindBy(id = "publish")
	// @FindBy(xpath = "//input[@id='publish' and @name='publish' and
	// @type='submit' and @value='Publish']")
	private WebElement PublishBtn;

	public void clickPublishButton() {
		Actions act = new Actions(driver);
		act.moveToElement(this.PublishBtn).build().perform();
		act.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// this.PublishBtn.click();
	}

	// Locators and method of publish
	@FindBy(xpath = "//span[@id='post-status-display']")
	private WebElement SuccessMsg;

	public String getSuccessMsg() {
		System.out.println(this.SuccessMsg.getText());
		return this.SuccessMsg.getText();
	}

	// Locators and method of View Post Link
	@FindBy(linkText = "View post")
	private WebElement ViewPostLink;

	public void clickViewPostLink() {
		this.ViewPostLink.click();
	}

	// Locators and method of View Post Message
	@FindBy(id = "not-found") // Error 404 is coming
	private WebElement ViewPostMsg;

	public Boolean getViewPostMsg() {
		return this.ViewPostMsg.isDisplayed();
	}
}
