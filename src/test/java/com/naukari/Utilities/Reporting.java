package com.naukari.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Reporting implements ITestListener {
	static String timeStamp= new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
	static String RepName = "Test-Report-"+timeStamp+".html";
	
	public static ExtentReports extent = ExtentManager.createInstance("D:\\Testing\\eclipse-workspace\\NaukariSite\\HtmlReport\\"+RepName);
	private static ThreadLocal<ExtentTest> Test = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> Method = new ThreadLocal<ExtentTest>();
    
    
	public void onTestStart(ITestResult result) {
		ExtentTest child = Test.get().createNode(result.getMethod().getMethodName());
		Method.set(child);
	}

	public void onTestSuccess(ITestResult result) {
		Method.get().pass(result.getMethod().getMethodName()+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	Method.get().fail(result.getMethod().getMethodName()+" is Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		Method.get().skip(result.getMethod().getMethodName()+" is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentTest parent = extent.createTest(context.getName());
		Test.set(parent);
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}


