/* Author: Rakesh Mishra
 * Class: SearchandAdditemTestCase.Java
 * Info: Test Cases Related to Search, Add to Cart, Update Cart functionality
*/

package com.amazon.test.testcases;
import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
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
	Logger log = Logger.getLogger(SearchandAdditemTestCase.class);

	public static Dictionary productName = new Hashtable();
	
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
	public void serachandAddItemtoCart(String SearchProductName, String quantity) 
	{
		try {
			log.info("serachandAddItemtoCart Test Started!");
			electronicsPage = homePage.navigateToHeadphonePage();
			log.info("Navigation to the Headphone Page");
			headPhoneListPage = electronicsPage.navigateToHeadphoneListPage();
			itemPage = headPhoneListPage.selectDesiredHeadPhoneFromSearchList(1);
			log.info("Selected Required Item From the Result Set");
			String firstItem = itemPage.addItemtoCart(1);
			productName.put("headPhone", firstItem);
			log.info("Added First Item to the Cart." + productName.get("headPhone").toString());
			searchResultPage = homePage.serachItemByName(SearchProductName);
			log.info("Search for the Next Product.");
			itemPage = searchResultPage.selectDesiredItemFromSearchResult(2);
			String secondItem = itemPage.addItemtoCart((int) Float.parseFloat(quantity));
			productName.put("macBook", secondItem);
			log.info("Added Second Item to the Cart." + productName.get("macBook").toString());
			cartPage = homePage.navigateToCart();
			log.info("Navigated to the Cart Page.");
			cartPage.deleteItemsFromCart(productName.get("headPhone").toString());
			cartPage.updateQuantityinCart(productName.get("macBook").toString(), 1);
			log.info("Updated the Cart Items.");
			shippingAddressPage = cartPage.clickonCheckoutOption();
			log.info("End of the serachandAddItemtoCart Test");
		} catch (Exception e) {
			log.error("Exception Occured in Login Test "+e.getMessage());
			Assert.fail();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
