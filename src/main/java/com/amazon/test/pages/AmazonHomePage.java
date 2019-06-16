package com.amazon.test.pages;

import org.openqa.selenium.support.PageFactory;

import com.amazon.test.root.AmazonTestRoot;

public class AmazonHomePage extends AmazonTestRoot{
	
	
	
	
	
	
	public AmazonHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

}
