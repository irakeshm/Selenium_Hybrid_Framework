/* Author: Rakesh Mishra
 * Class: AmazonElectronicsCategoryPage.Java
 * Info: OR and Method for Cart Page
*/
package com.amazon.test.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonViewCartPage extends AmazonTestRoot{
	
	@FindBy(xpath="//div[@class='sc-list-body sc-java-remote-feature']//child::div[contains(@class,'a-row a-spacing-base a-spacing-top-base')]")
	WebElement itemListinCart;
	
	@FindBy(name="proceedToCheckout")
	WebElement checkOutButton;
	
	
	public AmazonViewCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deleteItemsFromCart(String itemNametoDelete)
	{
		List<WebElement> itemName=itemListinCart.findElements(By.xpath("//child::span[contains(@class, 'a-size-medium sc-product-title a-text-bold')]"));
		int itemindex=0;
		for(int index=0;index<itemName.size();index++)
		{
			if(itemName.get(index).getText().contains(itemNametoDelete))
			{
				itemindex=index;
				break;
			}
		}		
		itemListinCart.findElements(By.xpath("//input[contains(@name,'delete')]")).get(itemindex).click();
	
	}
	public AmazonAddShippingAddressPage clickonCheckoutOption()
	{
		checkOutButton.click();
		return new AmazonAddShippingAddressPage();		
	}
	
	public void updateQuantityinCart(String itemNameforUpdate, int updatedQuantity)
	{
		List<WebElement> itemName=itemListinCart.findElements(By.xpath("//child::span[contains(@class, 'a-size-medium sc-product-title a-text-bold')]"));
		int itemindex=0;
		for(int index=0;index<itemName.size();index++)
		{
			if(itemName.get(index).getText().contains(itemNameforUpdate))
			{
				itemindex=index;
				break;
			}
		}		
		Select quanitydropDown= new Select(itemListinCart.findElements(By.xpath("//select[@name='quantity']")).get(itemindex));
		quanitydropDown.selectByValue(Integer.toString(updatedQuantity));
	}
	
	
}
