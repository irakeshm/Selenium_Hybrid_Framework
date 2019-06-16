package com.amazon.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.test.pages.AmazonAddShippingAddressPage;
import com.amazon.test.pages.AmazonElectronicsCategoryPage;
import com.amazon.test.pages.AmazonHeadphonesListPage;
import com.amazon.test.pages.AmazonHomePage;
import com.amazon.test.pages.AmazonSearchItemPage;
import com.amazon.test.pages.AmazonSearchResultPage;
import com.amazon.test.pages.AmazonViewCartPage;
import com.amazon.test.root.AmazonTestRoot;
import com.amazon.test.utilities.TestUtility;

public class SearchandAdditemTestCase extends AmazonTestRoot {
	AmazonHomePage homePage;
	String sheetName = "SearchProduct";
	AmazonSearchResultPage searchResultPage;
	AmazonSearchItemPage itemPage;
	AmazonElectronicsCategoryPage electronicsPage;
	AmazonHeadphonesListPage headPhoneListPage;
	AmazonViewCartPage cartPage;
	AmazonAddShippingAddressPage shippingAddressPage;
	
	
	public SearchandAdditemTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage=new AmazonHomePage(); 
	}
	
	@DataProvider
	public Object[][] getAmazonTestData(){
		Object data[][] = TestUtility.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="getAmazonTestData")
	public void serachandAddItemtoCart(String SearchProductName, String quantity) throws InterruptedException
	{
		electronicsPage=homePage.navigateToHeadphonePage();
		headPhoneListPage=electronicsPage.navigateToHeadphoneListPage();
		itemPage=headPhoneListPage.selectDesiredHeadPhoneFromSearchList(1);
		itemPage.addItemtoCart(1);
		
		searchResultPage=homePage.serachItemByName(SearchProductName);
		itemPage=searchResultPage.selectDesiredItemFromSearchResult(2);		
		itemPage.addItemtoCart((int)Float.parseFloat(quantity));
		
		cartPage=homePage.navigateToCart();
		cartPage.deleteItemsFromCart("Bose QuietComfort 35 II Wireless ");
		cartPage.updateQuantityinCart("Macbook", 1);
		shippingAddressPage=cartPage.clickonCheckoutOption();		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
