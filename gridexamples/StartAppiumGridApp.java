package com.gridexamples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class StartAppiumGridApp {
	
public AndroidDriver<AndroidElement> driver;
    
    public static String firstDeviceName = "emulator-5554";
    public static String secondDeviceName ="emulator-5556";
    
    @BeforeClass
    
    public void StartTest(String port, String device_id) throws InterruptedException, MalformedURLException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        
        if(device_id.equalsIgnoreCase(firstDeviceName))
        {
            System.out.println("The Device ID is" +device_id);
            System.out.println(port + "-" +System.currentTimeMillis());
            System.out.println(device_id+"-"+System.currentTimeMillis());
            
            //Starting the device
            caps.setCapability("deviceName", firstDeviceName);
            caps.setCapability("udid", firstDeviceName);
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9.0");
            
            //String the app
            
            caps.setCapability("appPackage", "io.appium.android.apis");
            caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
            
        }
        
        else if (device_id.equalsIgnoreCase(secondDeviceName))
        {
            System.out.println("The Device ID is" +device_id);
            System.out.println(port + "-" +System.currentTimeMillis());
            System.out.println(device_id+"-"+System.currentTimeMillis());
            
            //Starting the device
            caps.setCapability("deviceName", secondDeviceName);
            caps.setCapability("udid", secondDeviceName);
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9.0");
            
            //String the app
            
            caps.setCapability("appPackage", "io.appium.android.apis");
            caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
            
        }
        
        driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);
        
        Thread.sleep(3000);
        
    }
    
    @Test
    
    public void OpenApp()
    {
        System.out.println("Starting the API Demo's App");
    }


        
 

}
