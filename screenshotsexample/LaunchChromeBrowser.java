package com.screenshotsexample;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



@Listeners({ScreenshotUtility.class})


public class LaunchChromeBrowser {

	public static AndroidDriver<WebElement> driver;
	public static ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	public DateFormat dateformat;

	@Test

	public void LaunchChromeBrowser() throws MalformedURLException, InterruptedException
	{
		//    	define the code for creating html report

		String timeStamp = new SimpleDateFormat("dd-MMM-YYYY hh mm ssaaa").format(new Date());

		extent = new ExtentReports();

		spark = new ExtentSparkReporter("./TestReport/"+timeStamp+"AutomationReport.html");
		spark.config().setTheme(Theme.STANDARD);

		extent.attachReporter(spark);



		//To provide the name for the testcase

		logger = extent.createTest("LaunchChromeBrowser");


		DesiredCapabilities caps = new DesiredCapabilities();

		//Pass the Device details to launch the application

		caps.setCapability("deviceName", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "9.0");
		//caps.setCapability("noRest", "true");

		//Here we have to give the capability for the chrome brwoser to be launched

		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");

		driver = new AndroidDriver<WebElement> (new URL("http://localhost:4723/wd/hub"),caps);


		logger.info("Chrome Browser Started Successfully");

		Thread.sleep(3000);

		driver.get("https://www.google.com/");
		Thread.sleep(2000);

		logger.pass("Google webiste has been launched in the chrome browser");

		try {

			WebElement SearchBox = driver.findElement(By.name("q"));

			SearchBox.sendKeys("SimpliLearn");

			logger.pass("Simplilearn Text is succesfully in the the input box");
		}

		catch(Exception e)
		{
			logger.fail("Search box locator is incorrect");
			logger.fail(e);
		}

		Thread.sleep(2000);

		WebElement FirstLink = driver.findElement(By.xpath("//div[@id='tsuid_5']//ul//li[1]"));

		FirstLink.click();

		driver.close();
		logger.pass("Browser closed success");


		extent.flush();




	}


}
