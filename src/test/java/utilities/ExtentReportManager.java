

package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener
{
	public ExtentSparkReporter sparkReporter;//class which will populate UI of the report
	public ExtentReports extent;//populate common info on the report such as the browser info, date and what is the suite executed, date and time of execution etc
	public ExtentTest test;//creating test cases entries in the report and update status of the test methods
	String repName;

    
	public void onStart(ITestContext testContext) 
	{
		/*
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currenttimestamp=df.format(dt);
		*/
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//timestamp
		repName="test-Report-"+timestamp+".html";
		sparkReporter =new ExtentSparkReporter("/Users/arnab/Desktop/Programming_Projects/VSCodeProjects/practice_automation_test/test_output/"+repName);//specify location of the report
		sparkReporter.config().setDocumentTitle("Login Functional test suite");
		sparkReporter.config().setReportName("Login Functional test cases execution results");
		sparkReporter.config().setTheme(Theme.DARK);


		extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application Name", "ParaBank WebApp");
			extent.setSystemInfo("Computer name", "MacBook Air");
			extent.setSystemInfo("Environment","Test");
			extent.setSystemInfo("Tester name", System.getProperty("user.name"));

            
			String os=testContext.getCurrentXmlTest().getParameter("os");//give the os dynamically and captures the parameter from the xml being run
			extent.setSystemInfo("OS", os);
			String browser=testContext.getCurrentXmlTest().getParameter("browser");//give the os dynamically and captures the parameter from the xml being run
			extent.setSystemInfo("Browser Name", browser);
			List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();

			if(!includedGroups.isEmpty())
				{
					extent.setSystemInfo("Groups", includedGroups.toString());
				}
	}

	/* 
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getMethod().getDescription());
    }
	*/
   
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());//creating new test with the test case name
		//test.assignCategory(result.getMethod().getGroups());//to display groups in report
		test.log(Status.PASS, result.getName()+"successfully executed");//adding test method with the pass result
		String imgPath = null;
		try 
		{
			imgPath = BaseClass.captureScreen(result.getName());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
                test.addScreenCaptureFromPath(imgPath);
        
	}

    
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getTestClass().getName());//creating new test with the test case name
		//test.assignCategory(result.getMethod().getGroups());//to display groups in report
		test.log(Status.FAIL, result.getName()+"has failed");//adding test method with the fail result
		test.log(Status.FAIL, result.getThrowable().getMessage());
		String imgPath = null;
		try 
		{
			imgPath = BaseClass.captureScreen(result.getName());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
        
                test.addScreenCaptureFromPath(imgPath);
        
	}

   
	public void onTestSkipped(ITestResult result) 
	{
		test = extent.createTest(result.getTestClass().getName());
        if (result.getMethod().getGroups() != null) 
        {
            test.assignCategory(result.getMethod().getGroups());
        }
        test.log(Status.SKIP, result.getName() + " got skipped");
        if (result.getThrowable() != null) 
        {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
	}

    
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.WARNING, result.getName() + " failed but is within success percentage");
    }

    
	public void onFinish(ITestContext testContext) 
	{
		extent.flush();//mandatorily to generate the report.
		/*String pathOfExtentReport = System.getProperty("user.dir")+"/reports/"+repName;
		File extentReport = new File(pathOfExtentReport);
		try 
		{
		Desktop.getDesktop().browse(extentReport.toURI());//open the report at runtime
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		*/
 
	}
}
