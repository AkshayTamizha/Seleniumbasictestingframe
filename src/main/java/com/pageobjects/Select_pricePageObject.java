package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase1;

public class Select_pricePageObject extends TestBase1 {
	
	@FindBy(id="nextsendquote")
	WebElement btn_nxt;
	
	
	public Select_pricePageObject() {
		
		PageFactory.initElements(driver, this);
	}
	
	//to get price option on selected options / plan
	public String getpriceSelectedOption(String plan) {
		
		String dataxpath="//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']//span[@id='selectsilver_price']";
		
		return  driver.findElement(By.xpath(dataxpath)).getText();
		
	}

	//input[@name='Select Option']
	
	public void selectOption(String plan) {
		
		String optionxpath= "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
		driver.findElement(By.xpath(optionxpath)).click();
		
	}
	public void clickonNxt_Btn() {
		btn_nxt.click();
	}
	
	
}
