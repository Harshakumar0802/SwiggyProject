package com.screenshotsexample;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotUtility implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		 System.out.println("**starting the test case**");
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSuccess(result);
        
        System.out.println("**Test Case Success**");
        try {
//            takescreenshotFromMobile(result,"pass");
        	
        	takescreenshotFromMobileWeb(result,"pass");
        	
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

	@Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailure(result);
        try {
            takescreenshotFromMobile(result,"fail");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	public void takescreenshotFromMobile(ITestResult result, String status)
    {
        
        String destPassDir = "./Screenshots/PassedScreenshots";
        String destFailDir = "./Screenshots/FailedScreenshots";
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY hh mm ssaaa");
        
        String filename = dateFormat.format(new Date());
        
        File srcFile = ((TakesScreenshot)ScreenshotAppiumExample.driver).getScreenshotAs(OutputType.FILE);
        
        try {
            
            if(status.equalsIgnoreCase("pass")) {
            FileUtils.copyFile(srcFile, new File("./Screenshots/PassedScreenshots/"+filename+"_Image.png"));
            }
            else if(status.equalsIgnoreCase("fail")) {
                FileUtils.copyFile(srcFile, new File("./Screenshots/FailedScreenshots/"+filename+"_Image.png"));
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

	public void takescreenshotFromMobileWeb(ITestResult result, String status)
    {
        
        String destPassDir = "./Screenshots/PassedScreenshots";
        String destFailDir = "./Screenshots/FailedScreenshots";
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY hh mm ssaaa");
        
        String filename = dateFormat.format(new Date());
        
        File srcFile = ((TakesScreenshot)LaunchChromeBrowser.driver).getScreenshotAs(OutputType.FILE);
        
        try {
            
            if(status.equalsIgnoreCase("pass")) {
            FileUtils.copyFile(srcFile, new File("./Screenshots/PassedScreenshots/"+filename+"_Image.png"));
            }
            else if(status.equalsIgnoreCase("fail")) {
                FileUtils.copyFile(srcFile, new File("./Screenshots/FailedScreenshots/"+filename+"_Image.png"));
            }
        }
        
        catch(Exception e)
        {
        	 System.out.println(e);
        }

    }

}
