package com.ensimtest.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ensimtest.base.Driver;

public class Browser {
	
	private DriverSettings driverSetting;
	private final int timeToWait = 30;
	private final String defaultBrowser = "firefox";
	
	public Browser()
	{
		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(defaultBrowser, timeToWait);
	}
	
	public Browser(String browserName)
	{
		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeToWait);
	}
	
	public Browser(String browserName, int timeUnitInSecond)
	{
		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeUnitInSecond);
	}
	
	public void closeBrowser()
	{
		driverSetting.closeDriver();
	}

	/**
	 * Go to the URL mentioned
	 * @param URL : String containing URL of the location
	 */
	public void navigateTo(String URL)
	{
		Driver.driver.get(URL);
	}
	
	/**
	 * Read the URL of the current page
	 * @return : String URL
	 */
	public String getCurrntUrl()
	{
		return Driver.driver.getCurrentUrl();
	}
	
	/**
	 * DON'T USE IT NOW. THIS METHOD IS NOT IMPLEMENTED COMPLETELY.
	 * ------------------------------------------------------------
	 * Takes Screen-shot of the current page.
	 */
	public void takeScreenShot()
	{
		File scrFile = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(scrFile, new File("\\screenshot.png"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
