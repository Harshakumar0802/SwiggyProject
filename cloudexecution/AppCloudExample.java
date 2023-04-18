package com.cloudexecution;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class AppCloudExample {
	
	public static void main(String args[]) throws InterruptedException, MalformedURLException
    {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        
        //set the BS access details
        
        caps.setCapability("browserstack.user", "harshithkumar_uICSn1");
        caps.setCapability("browserstack.key", "h5Tj6kLZoxLbC64offBa");
        
        //Set the URL location for the apk file to laucnhed
        
        caps.setCapability("app", "bs://0e9619dc9e4a37e06c91351ce6e151c9cce44f69");
        
        //Specitying the device and os version for launching the app
        
        caps.setCapability("device", "Google Pixel 3a");
        caps.setCapability("os_Version", "9.0");
        
//set browserstack other capabitlies
        
        caps.setCapability("project", "Appium_Decemberbatch");
        caps.setCapability("build", "Build1");
        caps.setCapability("name", "First_Test");
        
        //Initialize the remote webdriver
        
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>
        
            (new URL("http://hub.browserstack.com/wd/hub"),caps);
        
        
        //Defeine the automation scitpts over here
        
        Thread.sleep(2000);
        
        AndroidElement views = driver.findElementsById("android:id/text1").get(10);
        views.click();
        
        MobileElement seekbar = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                +"new UiSelector().description(\"Seek Bar\"));"));
        
        Thread.sleep(2000);
        
        seekbar.click();
        
        AndroidElement SeekBarSection = driver.findElementById("io.appium.android.apis:id/seek");
        
        
        //To get the location of the start point x axis
        
        int StartX = SeekBarSection.getLocation().getX();
        
        int StartY = SeekBarSection.getLocation().getY();
        
        int EndX = SeekBarSection.getSize().getWidth();
        
        int SeekDirectionMedium = (int) (EndX*0.6);
        int SeekDirectionEnd = (int) (EndX*0.9);
        
        TouchAction a1 = new TouchAction(driver);
        
        a1.press(PointOption.point(StartX, StartY)).moveTo(PointOption.point(SeekDirectionMedium,StartY)).release().perform();
        
        Thread.sleep(2000);
        
        String ProgressValue = driver.findElementById("io.appium.android.apis:id/progress").getText();
        String TrackingValue = driver.findElementById("io.appium.android.apis:id/tracking").getText();
        
        
        System.out.println(ProgressValue);
        System.out.println(TrackingValue);
        
        a1.press(PointOption.point(StartX, StartY)).moveTo(PointOption.point(SeekDirectionEnd,StartY)).release().perform();

    
        Thread.sleep(2000);
        
        String ProgressValueEnd = driver.findElementById("io.appium.android.apis:id/progress").getText();
        String TrackingValueEnd = driver.findElementById("io.appium.android.apis:id/tracking").getText();
        
        
        System.out.println(ProgressValueEnd);
        System.out.println(TrackingValueEnd);


   	
       
        
        
    }

}
