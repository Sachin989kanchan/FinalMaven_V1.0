package com.Utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	
    ExtentHtmlReporter htmlReporter;
    ExtentReports report; 
    ExtentTest test;
    @BeforeTest
    public void onStart(ITestContext testContext)
    {
    	String timestamp=new SimpleDateFormat("DD.MM.YYYY"+"HH.MM.SS").format(new Date());
    	String repname="Kanchan-"+timestamp+".html";

    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repname);
    	htmlReporter = new ExtentHtmlReporter(repname);
    	
    	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
    	report = new ExtentReports();

    	report.attachReporter(htmlReporter);
    	
    	
    	report.setSystemInfo("Host Name","Local Host");
    	report.setSystemInfo("Environment","QA");
    	report.setSystemInfo("User Name","Sachin Kanchan");
    	
    	htmlReporter.config().setDocumentTitle("Intenet Banking project");
    	htmlReporter.config().setReportName("Functional TestReport");
    	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    	htmlReporter.config().setTheme(Theme.DARK);
    }
    public void onTestSuccess(ITestResult tr)
    {
    	test=report.createTest(tr.getName());//create new entry in the report
    	test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    }
    public void onTestFailure(ITestResult tr)
    {
    	test=report.createTest(tr.getName());
    	test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); 
    	String screenshotpath=System.getProperty("user.dir")+"\\screenshot\\"+tr.getName()+".png";
    	
    	File f=new File(screenshotpath);
    	if(f.exists())
    	{
    		try {
    			test.fail("Screenshot is below "+test.addScreenCaptureFromPath(screenshotpath));
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    	
    }
    public void onTestSkipped(ITestResult tr)
    {
    	test=report.createTest(tr.getName());
    	test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }
    public void onFinish(ITestContext testContext)
    {
    	report.flush();
    }
}









