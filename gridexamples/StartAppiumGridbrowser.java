package com.gridexamples;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class StartAppiumGridbrowser {
	

public AndroidDriver<WebElement> driver;
    
    public static String firstDeviceName = "emulator-5554";
    public static String secondDeviceName ="emulator-5556";
    
    @Test
    @Parameters({"port","deviceID"})
    public void StartTest(String port, String device_id) throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        
        if(device_id.equalsIgnoreCase(firstDeviceName))
        {
            System.out.println("The Device ID is" +device_id);
            System.out.println(port + "-" +System.currentTimeMillis());
            System.out.println(device_id+"-"+System.currentTimeMillis());
            
            //Starting the device
            caps.setCapability("browserName", "chrome");
            caps.setCapability("deviceName", firstDeviceName);
            caps.setCapability("udid", firstDeviceName);
            caps.setCapability("platformName", "Android");
            caps.setCapability("platformVersion", "9.0");
        }
            
            //String the app
            
        /*    caps.setCapability("appPackage", "com.android.calculator2");*/
            else if (device_id.equalsIgnoreCase(secondDeviceName))
            {
                System.out.println("The Device ID is" +device_id);
                System.out.println(port + "-" +System.currentTimeMillis());
                System.out.println(device_id+"-"+System.currentTimeMillis());
                
                //Starting the device
                caps.setCapability("browserName", "chrome");
                caps.setCapability("deviceName", secondDeviceName);
                caps.setCapability("udid", secondDeviceName);
                caps.setCapability("platformName", "Android");
                caps.setCapability("platformVersion", "9.0");
                
                //String the app
                
            /*    caps.setCapability("appPackage", "com.android.calculator2");
                caps.setCapability("appActivity", "com.android.calculator2.Calculator");*/
            
                
            }
            
            driver = new AndroidDriver(new URL("http://localhost:4444/wd/hub"),caps);
            
            Thread.sleep(5000);
            
            driver.get("https://www.google.com/");
            
            WebElement SearchBox = driver.findElement(By.name("q1212"));
            
            
            SearchBox.isDisplayed();
            SearchBox.sendKeys("SimpliLearn");    



        }

        }


