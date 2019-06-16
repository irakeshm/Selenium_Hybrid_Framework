
/* Author: Rakesh Mishra
 * Class: AmazonSearchItemPage.Java
 * Info: Search Item Page, Which has item details. This class have methods and OR for Searched Page
*/

package com.amazon.test.pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.amazon.test.root.AmazonTestRoot;

public class AmazonSearchItemPage extends AmazonTestRoot{
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCartButton;
	
	@FindBy(name="quantity")
	WebElement quanityDropDown;
	
	@FindBy(xpath="//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading']")
	WebElement successMessagelable;
	
	@FindBy(xpath="//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][contains(text(),'Added to Cart')]")
	WebElement successMessagelableonFloatWindow;
	
	@FindBy(id="productTitle")
	WebElement productName;
	
	@FindBy(id="attach-desktop-sideSheet")
	WebElement addtoCartSuccessWindow;
	
	@FindBy(id="attach-close_sideSheet-link")
	WebElement addtoCartSuccessWindowCloseButton;
		
	public AmazonSearchItemPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String addItemtoCart(int quantity)
	{		
		String productNameonPage=productName.getText();
		Select selectQuantity = new Select(quanityDropDown);
		selectQuantity.selectByValue(Integer.toString(quantity));
		addToCartButton.click();
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		try 
		{
		if(addtoCartSuccessWindow.isDisplayed())
		{
			WebElement element = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.visibilityOf(addtoCartSuccessWindow));
			addtoCartSuccessWindowCloseButton.click();
		}		
		}
		catch(NoSuchElementException ex)
		{
			return productNameonPage;
		}
		return productNameonPage;	
	}
	
	public String itemAddtoCartSuccessMessage()
	{
		return successMessagelable.getText();
	}
	
	public void closeSuccessMessageWindow()
	{
		
	}
	

}
