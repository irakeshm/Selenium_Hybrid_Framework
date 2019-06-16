/* Author: Rakesh Mishra
 * Class: LoginTestCase.Java
 * Info: Test Cases Related to Login/Logout Functionality
*/

package com.amazon.test.testcases;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.test.pages.AmazonHomePage;
import com.amazon.test.pages.AmazonLoginPage;
import com.amazon.test.root.AmazonTestRoot;

public class LoginTestCase extends AmazonTestRoot {
	AmazonLoginPage loginPage;
	AmazonHomePage homePage;
	Logger log = Logger.getLogger(LoginTestCase.class);
	
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
		log.info("Login Test Started!");		
		try {
			homePage.navigateToLoginPage();
			log.info("Navigated to the Login Page From Home Page.");
			homePage = loginPage.loginAmazonAccount(prop.getProperty("useremail"), prop.getProperty("password"));
			log.info("Log in to The Amazon Account.");
			Assert.assertTrue(homePage.getLoggedinUserName().contains(prop.getProperty("username")));
			log.info("Verified the Correct User Login.");
			log.info("End of the Login Test");
		} catch (Exception e) {
			
			log.error("Exception Occured in Login Test "+e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
	public void logoutFromAmazonAccount()
	{
		log.info("Login- Logout Test Started!");
		try {
			loginPage = homePage.navigateToLoginPage();
			log.info("Navigated to the Login Page From Home Page.");
			homePage = loginPage.loginAmazonAccount(prop.getProperty("useremail"), prop.getProperty("password"));
			log.info("Log in to The Amazon Account.");
			Assert.assertTrue(homePage.getLoggedinUserName().contains(prop.getProperty("username")));
			log.info("Verified the Correct User Login.");
			loginPage = homePage.signOutAmazonAccount();
			log.info("Log out form the Amazon Account.");
			Assert.assertTrue(loginPage.existenceofSigninForm());
			log.info("Verified Successful Logging out.");
			log.info("End of the Login- Logout Test");
		} catch (Exception e) {
			log.error("Exception Occured in Login- Logout Test "+e.getMessage());
			Assert.fail();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
