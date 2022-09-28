package com.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pageobjects.Enter_Insurant_Data;
import com.pageobjects.Enter_Product_dataobject;
import com.pageobjects.Enter_Vehicle_DataPage;
import com.pageobjects.Home_Page_Object;
import com.pageobjects.Select_pricePageObject;
import com.reusablecomponent.Properties_Operation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase1 extends Objects_Repo{
	
	
	
	public void launchBrowserAnd_Navigate() throws Exception {
		//read property file and get browser and url
		//launch browser
		//navigate
	String browser = Properties_Operation.getPropertyValueByKey("browser");
	String  url = Properties_Operation.getPropertyValueByKey("url");
		if(browser.equalsIgnoreCase("chrome")) {
     WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		}

		else if(browser.equalsIgnoreCase("firefox")) {
     WebDriverManager.firefoxdriver().setup();
		
		 driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}

	@BeforeMethod
	public  void setupMethod() throws Exception {
		launchBrowserAnd_Navigate();
		homepage = new Home_Page_Object();
		vehicledata = new Enter_Vehicle_DataPage();
		
		insData = new Enter_Insurant_Data();
		prodData= new Enter_Product_dataobject();
		
		 priceoption = new Select_pricePageObject();
	}
	

	@AfterMethod
	public void cleanup() {
		driver.quit(); //close the browser
	}
	
	
	
	
	
	
	
	
	
}
