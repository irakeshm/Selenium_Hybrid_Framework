/* Author: Rakesh Mishra
 * Class: AmazonElectronicsCategoryPage.Java
 * Info: OR and Method for Electronics Category Page
*/
package com.amazon.test.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonElectronicsCategoryPage extends AmazonTestRoot{
	
	@FindBy(xpath="//span[contains(text(),'HEADPHONES')]")
	WebElement headPhonelink;
	
	
	public AmazonElectronicsCategoryPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public AmazonHeadphonesListPage navigateToHeadphoneListPage()
	{		
		headPhonelink.click();
		return new AmazonHeadphonesListPage();
	}
}
