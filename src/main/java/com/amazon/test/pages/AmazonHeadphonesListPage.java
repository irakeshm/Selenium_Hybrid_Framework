/* Author: Rakesh Mishra
 * Class: AmazonHeadphonesListPage.Java
 * Info: OR and Method for Electronics Category Page> HeadPhone Lits Page
*/

package com.amazon.test.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonHeadphonesListPage extends AmazonTestRoot{
	
	@FindBy(xpath="//div[@class='s-result-list s-search-results sg-row']")
	WebElement headphoneSearchResultList;
	
	public AmazonHeadphonesListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AmazonSearchItemPage selectDesiredHeadPhoneFromSearchList(int index)
	{
		WebElement indexedHeadPhoneItem=headphoneSearchResultList.findElement(By.xpath("./child::div["+index+"]")).findElement(By.xpath(".//child::a"));
		indexedHeadPhoneItem.click();	
		return new AmazonSearchItemPage();
	}
	
	
	

}
