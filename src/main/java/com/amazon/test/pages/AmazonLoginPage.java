
/* Author: Rakesh Mishra
 * Class: AmazonLoginPage.Java
 * Info: OR and Method for Login Page and Logout Function, with Validation Methods
*/
package com.amazon.test.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.test.root.AmazonTestRoot;

public class AmazonLoginPage extends AmazonTestRoot{
	
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="ap_password")
	WebElement UserPassword;
	
	@FindBy(id="signInSubmit")
	WebElement signIn;
	
	@FindBy(xpath="//form[@name='signIn']")
	WebElement signInForm;
	
	public AmazonLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public AmazonHomePage loginAmazonAccount(String emailId, String password)
	{
		email.sendKeys(emailId);
		UserPassword.sendKeys(password);
		signIn.click();
		
		return new AmazonHomePage();
	}
	
	public boolean existenceofSigninForm()
	{
		return signInForm.isDisplayed();
	}
}
