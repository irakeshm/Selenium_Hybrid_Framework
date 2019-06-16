/* Author: Rakesh Mishra
 * Class: HomePageTestCase.Java
 * Info: Test Cases Related to Home Page Functionality
*/

package com.amazon.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amazon.test.pages.AmazonElectronicsCategoryPage;
import com.amazon.test.pages.AmazonHeadphonesListPage;
import com.amazon.test.pages.AmazonHomePage;
import com.amazon.test.root.AmazonTestRoot;

public class HomePageTestCase extends AmazonTestRoot {
	AmazonHomePage homePage;
	AmazonElectronicsCategoryPage electronicsPage;
	AmazonHeadphonesListPage headPhoneListPage;
	
	public HomePageTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage=new AmazonHomePage(); 
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
