package com.sampleProj.MavenSample;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileTest 
{
	public static AppiumDriver<WebElement> driver;
	public static DesiredCapabilities cap;
	
	@Test
	public void Android_LaunchApp() throws MalformedURLException, InterruptedException {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability("deviceName", "pixelxlo26");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Assert.assertNotNull(driver);
		Thread.sleep(2000);
	}
	
	//@Test
	public void iOS_LaunchApp() throws MalformedURLException, InterruptedException {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "iOS");
		cap.setCapability("deviceName", "iPhone X");
                cap.setCapability("automationName", "XCUITest");
		cap.setCapability("platformVersion", "12.0");
		cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
		driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Assert.assertNotNull(driver);
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void CloseApp() {
		driver.quit();
	}
}
