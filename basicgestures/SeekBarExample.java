package com.basicgestures;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class SeekBarExample {
	
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
     
     driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
     
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
