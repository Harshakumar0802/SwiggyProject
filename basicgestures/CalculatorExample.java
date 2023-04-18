package com.basicgestures;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CalculatorExample {
	
	public static AndroidDriver<AndroidElement> driver;
	

	
	@BeforeTest
	public void LaunchApp() throws MalformedURLException
	{
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    //Pass the Device details to launch the application
	    
	    caps.setCapability("deviceName", "emulator-5554");
	    caps.setCapability("platformName", "Android");
	    caps.setCapability("platformVersion", "9.0");
	    caps.setCapability("noRest", "true");
	    
	    //We have to provide the app details
	    
	    caps.setCapability("appPackage", "com.android.calculator2");
	    caps.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
	    
	    
	}

	@Test
	public void TestCalcualtor() throws InterruptedException
	{
	    System.out.println("Starting the Automation Test");
	    
	    AndroidElement eight = driver.findElementById("com.android.calculator2:id/digit_8");
	    eight.click();
	    
	    AndroidElement plus = driver.findElementById("com.android.calculator2:id/op_add");
	    plus.click();
	    
	    AndroidElement two = driver.findElementById("com.android.calculator2:id/digit_2");
	    two.click();
	    
	    AndroidElement equalto = driver.findElementById("com.android.calculator2:id/eq");
	    equalto.click();
	    
	    Thread.sleep(3000);
	    
	    AndroidElement result = driver.findElementById("com.android.calculator2:id/result");
	    
	    System.out.println("The result value" +result.getText());
	    
	    if(result.getText().equals(10))
	    {
	        System.out.println("The Addition operation is working fine");
	    }
	    else
	    {
	        System.out.println("Problem with addition");
	    }
	    
//	    Assert.assertEquals(result.getText(),10);
	    
	}


	}

	
	


