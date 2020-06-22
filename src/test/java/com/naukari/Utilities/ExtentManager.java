package com.naukari.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
	public class ExtentManager {
		private static ExtentReports extent;
		  public static ExtentReports getInstance() {
		    	if (extent == null)
		    		createInstance("test-output/extent.html");
		    	
		        return extent;
		    }
		    
		public static ExtentReports createInstance(String fileName) {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
			htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.DARK);
	        htmlReporter.config().setDocumentTitle("Login Test HTML Report");
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("Login Test");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
			return extent;
			
		}
	}
