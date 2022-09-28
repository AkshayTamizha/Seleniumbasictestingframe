package com.reusablecomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class Common_Methods {
	
	//common method to dropdown value
	public void selectDropdownOption(WebElement element, String valueTobeSelected) throws Exception {
		
		Select ss = new Select(element);
		try {
		ss.selectByVisibleText(valueTobeSelected);
		} catch(Exception e) {
			throw new Exception("value is not present in dropdown for WebElement:"+element+"Value to be selected is:"+valueTobeSelected);
		}
	}
	
	public void select_Radio_Button(List<WebElement> element, String valueTobeSelected){
		
		for(WebElement ref:element) {
			if(ref.getText().equalsIgnoreCase(valueTobeSelected)) {
				ref.click();
				break;
			}
				
		}
	}
	//selecting check box
public void select_CheckBox(List<WebElement> element, String check){
	
	String[] checkArray = check.split(",");
		for(String str: checkArray) {
		for(WebElement ele: element) {
			if(ele.getText().equalsIgnoreCase(str)) {
				ele.click();
			}
		}
		}
}
	
	//get dropdown option for list of string for compare
	public List<String> getDropdown_OptionasList(WebElement element) {
		
Select os = new Select(element);
		
		List<WebElement> List_WebElement_Model = os.getOptions();
		List<String> actualcontent= new ArrayList<String>();
		
		for(WebElement reference :List_WebElement_Model) {
			
			actualcontent.add(reference.getText());
			
		}
		
		return actualcontent;
		
	}

}
