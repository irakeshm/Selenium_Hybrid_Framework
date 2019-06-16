package com.amazon.test.pages;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.amazon.test.root.AmazonTestRoot;

public class AmazonHomePage extends AmazonTestRoot{
	
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

}
