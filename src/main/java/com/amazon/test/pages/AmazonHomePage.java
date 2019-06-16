package com.amazon.test.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.amazon.test.root.AmazonTestRoot;

public class AmazonHomePage extends AmazonTestRoot{
	
	public static final String homepageTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	
	@FindBy(id="nav-logo")
	WebElement amazonlogo;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextbox;
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
	WebElement serachSubmitButton;
		
	@FindBy(xpath="//span[contains(text(),'Departments')]")
	WebElement departmentsContextMenu;
	
	@FindBy(xpath="//span[@class='nav-line-2'][contains(text(),'Account & Lists')]")
	WebElement accountContextMenu;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//a[@class='nav-action-button']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[@id='nav-item-signout']")
	WebElement signOutButton;
	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	WebElement electronicsMenuItem;
	
	
	public AmazonHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public AmazonLoginPage navigateToLoginPage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(accountContextMenu).build().perform();
		signInButton.click();
		return new AmazonLoginPage();
	}
	
	public AmazonLoginPage signOutAmazonAccount()
	{
		Actions action = new Actions(driver);
		action.moveToElement(accountContextMenu).build().perform();
		signOutButton.click();
		return new AmazonLoginPage();
	}
	
	public AmazonElectronicsCategoryPage navigateToHeadphonePage()
	{
		Actions action = new Actions(driver);
		action.moveToElement(departmentsContextMenu).build().perform();
		electronicsMenuItem.click();
		return new AmazonElectronicsCategoryPage();
	}
	
	public AmazonSearchResultPage serachItemByName(String itemName)
	{
		searchTextbox.sendKeys(itemName);
		serachSubmitButton.click();
		return new AmazonSearchResultPage();
	}

}
