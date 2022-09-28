package com.testbase;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pageobjects.Enter_Insurant_Data;
import com.pageobjects.Enter_Product_dataobject;
import com.pageobjects.Enter_Vehicle_DataPage;
import com.pageobjects.Home_Page_Object;
import com.pageobjects.Select_pricePageObject;
import com.reusablecomponent.Common_Methods;

import net.bytebuddy.asm.Advice.Enter;

public class Objects_Repo {
	
	public static WebDriver driver;
	
	public static ExtentTest test;
	
	public static ExtentReports extent ;
	
	public static Home_Page_Object homepage;
	
	public static Enter_Vehicle_DataPage vehicledata;
	
	public static Enter_Insurant_Data insData;
	
	public static Enter_Product_dataobject prodData;
	
	public static Select_pricePageObject priceoption;
	
	public Common_Methods cm = new Common_Methods(); 
	
	

}
