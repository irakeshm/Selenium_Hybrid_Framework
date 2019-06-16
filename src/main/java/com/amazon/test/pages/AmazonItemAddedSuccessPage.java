
/* Author: Rakesh Mishra
 * Class: AmazonItemAddedSuccessPage.Java
 * Info: OR and Method for the Page When Item is Added to the Cart and Success Pages Displayed.
*/

package com.amazon.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonItemAddedSuccessPage extends AmazonTestRoot{
	
	@FindBy(xpath="//h1[@class='a-size-medium a-text-bold']")
	WebElement cartSuccessMessage;
	
	public AmazonItemAddedSuccessPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycartSuccessMessage()
	{
		return cartSuccessMessage.getText();
	}

}
