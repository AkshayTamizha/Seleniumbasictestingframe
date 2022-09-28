package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase1;

public class Home_Page_Object extends TestBase1 {
	//onlypageobjects + respective methods
	
	
	
	//WebElement link_Automobile= driver.findElement(By.xpath("")); //without page factory
	
	//WebElement link_MotorCycle= driver.findElement(By.xpath(""));
	
@FindBy(id="nav_automobile") //pageFactoryModel
WebElement link_Automobile;

@FindBy(id="nav_truck")
WebElement link_truck;

@FindBy(xpath="//a[@id='nav_motorcycle'][1]")
public WebElement link_motorcycle;

@FindBy(id=" nav_camper")
WebElement link_camper;

//consutrcuto = to use initelement to interconntect weblements and driver
public Home_Page_Object() {
	
	PageFactory.initElements(driver, this);
	
	
}
	//for click on homepage motorcycle 
public void clickOnmotorcyle() {
	
	
	link_motorcycle.click();
}













}
