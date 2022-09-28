package com.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testbase.TestBase1;

public class Enter_Vehicle_DataPage extends TestBase1 {
	
	@FindBy(id="make")
	WebElement dd_make;
	
	
	@FindBy(xpath="//select[@id='model']")
	WebElement dd_model;
	
	
	@FindBy(id="cylindercapacity")
	 WebElement txt_cylindercapacity;
	
	@FindBy(xpath="//input[@id='cylindercapacity']//following-sibling::span[@class='error']")
	WebElement error_Cylindercapacity;
	
	@FindBy(id="engineperformance")
	WebElement txt_engineperformance;
	
	@FindBy(id="dateofmanufacture")
	WebElement date_DateofManufacture;
	
	@FindBy(id="numberofseatsmotorcycle")
	WebElement dd_numberofseats;
	
	@FindBy(id="listprice")
	WebElement txt_txtprice;
	
	@FindBy(id="annualmileage")
	WebElement txt_annualmileage;
	
	@FindBy(id="nextenterinsurantdata")
	WebElement btn_next;
	
	
	//constructor= to use init element method
	public Enter_Vehicle_DataPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void enterrCylinderCapcity(String Cylindercap) {
		
		txt_cylindercapacity.sendKeys(Cylindercap);
	}

	public String getErrormessageoncyclindecapacity() {
		return error_Cylindercapacity.getText();
	}
	
	public List<String> get_Dropdownoption_Model() {
		
		return cm.getDropdown_OptionasList(dd_model);
		
	}
	
public List<String> get_Dropdownoption_make() {
		
		return cm.getDropdown_OptionasList(dd_make);
	
	
}

public void enter_VechicleData(HashMap<String,String> testData) throws Exception {
	
	cm.selectDropdownOption(dd_make, testData.get("Vehicle_Make"));
	cm.selectDropdownOption(dd_model, testData.get("Vehicle_Model"));
	txt_cylindercapacity.sendKeys(testData.get("Vehicle_CylinderCapcity"));
	txt_engineperformance.sendKeys(testData.get("Vehicle_Eng_Performance"));
date_DateofManufacture.sendKeys(testData.get("Vehicle_Date_Of_Manufacture"));
cm.selectDropdownOption(dd_numberofseats, testData.get("Vehicle_No_of_Seats_Motorcycle"));
txt_txtprice.sendKeys(testData.get("Vehicle_List_Price"));
txt_annualmileage.sendKeys(testData.get("Vehicle_Annual_Mileage"));
}

public void clickOnNextbtn() {
	
	btn_next.click();
}
















}
