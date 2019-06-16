/* Author: Rakesh Mishra
 * Class: AmazonTestRoot.Java
 * Info: Base class in the main class which take care of Browser setup, 
 * loading configuration file and other reusable methods like screenshot, 
 * handling sync issues and defining waits.
*/
package com.amazon.test.root;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.test.utilities.Constants;

public class AmazonTestRoot {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	
	public AmazonTestRoot()
	{
		try 
		{
			prop = new Properties();
			FileInputStream configFile = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/amazon/test/configuration/config.properties");
			prop.load(configFile);
		} 
		catch (FileNotFoundException ex) 
		{
			ex.printStackTrace();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*
	 * initializing the WebDriver, as per Browser selected and Navigating to the Base URL.
	*/
	public static void initialization(){
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/BrowserDrivers/chromedriver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/BrowserDrivers/geckodriver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}	
		else if(browser.equals("safari"))
		{
			System.setProperty("webdriver.safari.driver", System.getProperty("user.dir")+"/BrowserDrivers/safaridriver/safaridriver.exe");	
			driver = new SafariDriver(); 
		}	
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"/BrowserDrivers/IEdriver/IEdriver.exe");	
			driver = new InternetExplorerDriver(); 
		}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);		
		driver.get(prop.getProperty("baseurl"));		
	}

}
