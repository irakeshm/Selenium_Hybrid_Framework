package com.amazon.test.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.test.root.AmazonTestRoot;
import com.amazon.test.utilities.TestUtility;

public class AmazonSearchItemPage extends AmazonTestRoot{
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartButton;
	
	@FindBy(name="quantity")
	WebElement quanityDropDown;
	
	@FindBy(xpath="//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading']")
	WebElement successMessagelable;
	
	@FindBy(id="productTitle")
	WebElement productName;
	
	public AmazonSearchItemPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AmazonSearchItemPage addItemtoCart(String quantity)
	{
		Select selectQuantity = new Select(quanityDropDown);
		selectQuantity.selectByValue(quantity);
		quanityDropDown.click();
		TestUtility.amazonCartItemList.add(productName.getText());
		return new AmazonSearchItemPage();		
	}
	
	public String itemAddtoCartSuccessMessage()
	{
		return successMessagelable.getText();
	}

}
