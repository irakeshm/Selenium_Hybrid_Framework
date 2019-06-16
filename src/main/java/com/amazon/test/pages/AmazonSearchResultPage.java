/* Author: Rakesh Mishra
 * Class: AmazonSearchResultPage.Java
 * Info: OR and Method for Serach Result Page
*/

package com.amazon.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonSearchResultPage extends AmazonTestRoot{
	
	@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']")
	WebElement searchResultList;
	
	public AmazonSearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AmazonSearchItemPage selectDesiredItemFromSearchResult(int index)
	{
		WebElement indexedHeadPhoneItem=searchResultList.findElement(By.xpath("./child::div["+index+"]")).findElement(By.xpath(".//child::a"));
		indexedHeadPhoneItem.click();	
		return new AmazonSearchItemPage();
	}

}
