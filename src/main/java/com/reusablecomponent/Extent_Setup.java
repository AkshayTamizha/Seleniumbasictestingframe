package com.reusablecomponent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Setup {
	
	public static  ExtentReports setup_ExtentReport() {
		
		SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY HH-MM");
		
		Date date= new Date();
		
	String actualdate=format.format(date);
		
		String reportpath = System.getProperty("user.dir")+
				"/Reports/ExecutionReport_"+actualdate+".html";
		
		ExtentSparkReporter sparkreport = new ExtentSparkReporter(reportpath);
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(sparkreport);
		
		
		sparkreport.config().setDocumentTitle("document title");
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("reportName");
		
		return extent;
		
		
	}

}
