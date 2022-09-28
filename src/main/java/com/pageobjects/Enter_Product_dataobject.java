package com.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase1;

public class Enter_Product_dataobject extends TestBase1 {
	
	
	@FindBy(id="startdate")
  WebElement txt_startdate;
	
	@FindBy(id="insurancesum")
	WebElement dd_insurancesum;
	
	@FindBy(id="damageinsurance")
	WebElement dd_damageinsurance;
	
	//options
	
	@FindBy(xpath="//input[@name='Optional Products[]']//parent::label")
	List <WebElement> clk_Optionalproduct;
	
	
	
	
	@FindBy(id="nextselectpriceoption")
	WebElement btn_nextselectpriceoption;
	
	
	public Enter_Product_dataobject() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enter_ProductData(HashMap<String,String> testData) throws Exception {
		txt_startdate.sendKeys(testData.get("Product_Start_Date"));
	cm.selectDropdownOption(dd_insurancesum, testData.get("Product_Insurancesum"));
	cm.selectDropdownOption(dd_damageinsurance, testData.get("Producy_Damageinsurance"));
	cm.select_CheckBox(clk_Optionalproduct, testData.get("Product_Optionalproduct"));
	
	}
	
	
	public void clickOnNextButton() {
		
		
	btn_nextselectpriceoption.click();
		
		
		
	}
	
	
	
	
	
	
}
