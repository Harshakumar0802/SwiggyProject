package com.basicgestures;

import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SingleActionGesutures {
	
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
        
        caps.setCapability("appPackage", "com.google.android.apps.maps");
        caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
        
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
        
     //x - 965 Y - 132
        
        //To performache touch interaction we use TouchAction class
        
        TouchAction a1 = new TouchAction(driver);
        
        a1.tap(PointOption.point(965, 132)).perform();
        
        AndroidElement HamMenu = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Menu\"]/android.widget.ImageView");
        
//        HamMenu.click();
        
        Thread.sleep(2000);
        
        // x 988 , y 580
        
//        a1.tap(PointOption.point(988,580)).perform();

//tap and long press
        
        
        a1.tap(PointOption.point(676,651)).perform();
        
        a1.longPress(PointOption.point(475, 1797)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).release().perform();

      

        
        
    }


	

}
