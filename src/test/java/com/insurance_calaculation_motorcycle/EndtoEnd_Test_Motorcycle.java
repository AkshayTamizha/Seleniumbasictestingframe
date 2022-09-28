package com.insurance_calaculation_motorcycle;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.reusablecomponent.Excel_Operations;
import com.testbase.TestBase1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EndtoEnd_Test_Motorcycle extends TestBase1 {
	
	Excel_Operations excel = new Excel_Operations("InsurancePremium");
	
	@Test(dataProvider="vehData")
	public void insurance_Calculate(Object obj1) throws Exception{
		
		HashMap<String,String> testData= (HashMap<String,String>)obj1;
		
		test.log(Status.INFO, "Test Data used for execution is:"+testData);
		
		
		  homepage.clickOnmotorcyle(); 
		  vehicledata.enter_VechicleData(testData);
		  vehicledata.clickOnNextbtn();
		  insData.enterInsuranceData(testData);
		  insData.clickOnNxtBtn();
		  prodData.enter_ProductData(testData);
		  prodData.clickOnNextButton();
		  
		  
		  
		  
		  Assert.assertEquals(priceoption.getpriceSelectedOption("Gold"), testData.get("priceValidation_Gold"),"pricing for gold plan is not matching");
		  Assert.assertEquals(priceoption.getpriceSelectedOption("Silver"), testData.get("priceValidation_Silver"),"pricing for silver plan is not matching");
		  Assert.assertEquals(priceoption.getpriceSelectedOption("Platinum"), testData.get("priceValidation_Platinum"),"pricing for platinum plan is not matching");
		  Assert.assertEquals(priceoption.getpriceSelectedOption("Ultimate"), testData.get("priceValidation_Ultimate"),"pricing for Ultimate plan is not matching");
		  
		  
		  priceoption.selectOption(testData.get("select_Option")); 
		  priceoption.clickonNxt_Btn();
	}	
	
	
	//Data provider---> return object array
	@DataProvider(name= "vehData")
	public Object[][] testDataSupplier() throws Exception {
		
		Object[][] obj = new Object [excel.getRowCount()][1]; // we have 30 column we can add it hash map
		for(int i=1;i<=excel.getRowCount();i++) {
		HashMap<String,String> testdata=excel.getTestDataInMap(i);
		obj[i-1][0] = testdata;
		}
		return obj;
		
	}
	
	
	
	
	
	
	
	
}