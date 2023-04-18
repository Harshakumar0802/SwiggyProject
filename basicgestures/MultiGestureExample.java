package com.basicgestures;

import java.net.URL;

import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class MultiGestureExample {
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
     
   //Step 1 tap of teh search bar
     
     //X - 290, Y - 150
     
     TouchAction singleTap = new TouchAction(driver);
     
     Thread.sleep(2000);
     
     singleTap.tap(PointOption.point(965, 132)).perform();
     
     Thread.sleep(2000);
     
     singleTap.tap(PointOption.point(290, 150)).perform();
     
     Thread.sleep(3000);
     
     AndroidElement SearchBox = driver.findElementById("com.google.android.apps.maps:id/search_omnibox_edit_text");
     
     SearchBox.sendKeys("Bangalore");
     
     //x 592 Y 1088
     
     Thread.sleep(3000);

     singleTap.tap(PointOption.point(592, 1088)).perform();
     Thread.sleep(9000);
     
     // First finger 296, 688  646, 509
     
     TouchAction firstfinger = new TouchAction(driver)
     .press(PointOption.point(296, 688)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
     .moveTo(PointOption.point(646, 509));
     
     
     //Second finger 188 1372 129 1739
     
     TouchAction secondfinger = new TouchAction(driver)
             .press(PointOption.point(188, 1372)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
             .moveTo(PointOption.point(129, 1739));
     
     //Combine the two touch options
     
     MultiTouchAction mt = new MultiTouchAction(driver);
     
     Thread.sleep(4000);
     
     mt.add(firstfinger).add(secondfinger).perform();

    }

}
