package com.insurance_calaculation_motorcycle;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.testbase.TestBase1;

public class Error_Testt_Motorcycle extends TestBase1 {

	@Test(enabled = false)
	public void errormessage_payload() throws Exception {

		// verifyerrormessage
		// open browser and navigate to url-- before method
		// click on motor cycle --will be on home page

		homepage.clickOnmotorcyle();

		vehicledata.enterrCylinderCapcity("33333");

		test.log(Status.PASS, "cylindercapacity is filled with date:33333");

		// enter cycle capacity value
		// verrify error message

		String actualerrormessageoncyclindecapacity = vehicledata.getErrormessageoncyclindecapacity();
		String errormessageoncylindercapacity = "Must be a number between 1 and 2000";

		Assert.assertEquals(actualerrormessageoncyclindecapacity, errormessageoncylindercapacity,
				"Error message is not expected on cylinde capacity");

	}

	@Test(enabled=false)
	public void errormessage_payload2() throws Exception {

		// verifyerrormessage
		// open browser and navigate to url-- before method
		// click on motor cycle --will be on home page

		homepage.clickOnmotorcyle();

		vehicledata.enterrCylinderCapcity("33333");

		test.log(Status.PASS, "cylindercapacity is filled with date:33333");

		// enter cycle capacity value
		// verrify error message

		String actualerrormessageoncyclindecapacity = vehicledata.getErrormessageoncyclindecapacity();
		String errormessageoncylindercapacity = "Must be a number between 1 and 3000";

		Assert.assertEquals(actualerrormessageoncyclindecapacity, errormessageoncylindercapacity,
				"Error message is not expected on cylinde capacity");

	}
	
	@Test(enabled=true)
	public void verify_ModelDropDownOption() {
		//click on motorcycle link
		
		homepage.clickOnmotorcyle();
		//get dropdown content-actual value
		
		List<String> actualvalue= vehicledata.get_Dropdownoption_Model();
		//by adding acttualvalue in test report to get informative content
		
		 test.log(Status.INFO, "actual dd content for model dd is:" + actualvalue);
		//expected value
		
		List<String> expectedValues = Arrays.asList("– please select –", "Scooter", "Three-Wheeler","Moped","Motorcycle");
		 test.log(Status.INFO, "actual dd content for model dd is:" + expectedValues);
		//compare assert
		
		Assert.assertEquals(actualvalue, expectedValues, "error in dropdown options compare at modeloptions");
	}
	
	

}
