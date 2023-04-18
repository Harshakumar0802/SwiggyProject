package com.screenshotsexample;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@Listeners({ScreenshotUtility.class})


public class ScreenshotAppiumExample {
	
	public static AndroidDriver<AndroidElement> driver;
	
	@Test
    public void LaunchApp() throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        
        //Pass the Device details to launch the application
        
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("noRest", "true");
        
        //We have to provide the app details
        
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        Thread.sleep(4000);
        
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
        
        Thread.sleep(4000);
        
        AndroidElement views = driver.findElementsById("android:id/text1").get(10);
        Thread.sleep(4000);
        views.click();
        Thread.sleep(4000);
        
//        takescreenshotFromMobile();
        
    }

	public void takescreenshotFromMobile()
    {
        
        
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(srcFile, new File("./Screenshots/Image.png"));
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }




}
