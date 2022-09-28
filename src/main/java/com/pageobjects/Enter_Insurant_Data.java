package com.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase1;

public class Enter_Insurant_Data extends TestBase1 {
	
	@FindBy(id="firstname")
	WebElement txt_firstname;
	
	@FindBy(id="lastname")
    WebElement txt_lastname;
	
	@FindBy(id="birthdate")
    WebElement txt_birthdate;
	
	
	//radio button gender 
	
	@FindBy(xpath="//input[@name='Gender']//parent::label")
	List<WebElement> rdo_gender;
	
	
	
	@FindBy(id="country")
    WebElement dd_country;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="occupation")
	WebElement dd_occupation;
	
	
	@FindBy(xpath="//input[@name='Hobbies']//parent::label")
	List<WebElement> chk_hobbies;
	
	@FindBy(id="Website")
    WebElement txt_Website;
	
	@FindBy(id="open")
    WebElement btn_open;
	
	@FindBy(id="nextenterproductdata")
	WebElement btn_nextenterproductdata;
	
	public Enter_Insurant_Data () {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterInsuranceData(HashMap<String,String> testData) throws Exception {
		
		txt_firstname.sendKeys(testData.get("Insurant_Firstname"));
		txt_lastname.sendKeys(testData.get("Insurant_Lastname"));
		txt_birthdate.sendKeys(testData.get("Insurant_DateofBirth"));
		cm.select_Radio_Button(rdo_gender,testData.get("Inusrant_Gender"));
		cm.selectDropdownOption(dd_country, testData.get("Insurant_Country"));
		zipcode.sendKeys(testData.get("Insurant_Zipcode"));
		cm.selectDropdownOption(dd_occupation, testData.get("Insurant_Occupation"));
		cm.select_CheckBox(chk_hobbies, testData.get("Insurant_Hobby"));
		
	}
	
	
	public void clickOnNxtBtn() {
		btn_nextenterproductdata.click();
	}
	
}
