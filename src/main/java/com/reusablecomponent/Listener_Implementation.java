package com.reusablecomponent;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testbase.Objects_Repo;

public class Listener_Implementation extends Objects_Repo implements ITestListener {

	public void onTestStart(ITestResult result) {
		//start report -create spacce for report
		
	 test=	extent.createTest(result.getMethod().getMethodName());
		
		
	}
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Case:"+ result.getMethod().getMethodName()+" method is passed." );
		
	}
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, "Test Case:"+ result.getMethod().getMethodName()+" method is failed." );
		test.log(Status.FAIL, result.getThrowable());
		
		//take screenshort of failed
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY HH-MM");
		
		Date date= new Date();
		
	String actualdate=format.format(date);
		
		String screenshotpath = System.getProperty("user.dir")+
				"/Reports/Screenshot/"+actualdate+".jpeg";
		
		File Dest = new File(screenshotpath);
		
		try {
			FileUtils.copyFile(src, Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			test.addScreenCaptureFromPath(screenshotpath, "Test case failure Screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		//run report
		extent =Extent_Setup.setup_ExtentReport();
		
	}

	public void onFinish(ITestContext context) {
		//close report
		extent.flush();
	}

}
