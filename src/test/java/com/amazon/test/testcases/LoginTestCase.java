package com.amazon.test.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.test.pages.AmazonHomePage;
import com.amazon.test.pages.AmazonLoginPage;
import com.amazon.test.root.AmazonTestRoot;

public class LoginTestCase extends AmazonTestRoot {
	AmazonLoginPage loginPage;
	AmazonHomePage homePage;
	
	public LoginTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage=new AmazonLoginPage();
		homePage=new AmazonHomePage(); 
				
	}
	
	@Test
	public void loginToAmazonAccount()
	{
		homePage.navigateToLoginPage();
		homePage=loginPage.loginAmazonAccount(prop.getProperty("useremail"), prop.getProperty("password"));
	}
	
	@Test
	public void logoutFromAmazonAccount()
	{
		loginPage=homePage.navigateToLoginPage();
		homePage=loginPage.loginAmazonAccount(prop.getProperty("useremail"), prop.getProperty("password"));
		loginPage=homePage.signOutAmazonAccount();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
