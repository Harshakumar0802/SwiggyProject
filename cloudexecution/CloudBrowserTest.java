package com.cloudexecution;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CloudBrowserTest {
	
	public static final String username ="harshithkumar_uICSn1";
    public static final String Automation_key ="h5Tj6kLZoxLbC64offBa";
    public static final String URL = "https://" +username+ ":" +Automation_key + "@hub-cloud.browserstack.com/wd/hub";
    
    
    @Test
    
    public void OpenSafariBrowser() throws MalformedURLException
    {
        
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "15");
        caps.setCapability("device", "iPhone 13 Pro");
        caps.setCapability("browser", "Safari");
        caps.setCapability("name", "Safari Automation Test");
        
        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        
        driver.get("https://www.google.com");
        
        driver.quit();
        
    }
    
    
}




