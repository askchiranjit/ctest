package com.ensimtest.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ensimtest.base.Driver;
import com.ensimtest.resource.PropertyReader;
import com.ensimtest.utils.TestUtils;

public class Browser {
	
	private DriverSettings driverSetting;
	private int timeToWait = 30;
	private final String defaultBrowser = "firefox";
	private static String baseURL;
	private static String browserName = null;
	
	public Browser()
	{
		PropertyReader pr;
		try
		{
			pr = new PropertyReader();
			baseURL=pr.getURL();
			browserName=pr.getBrowserName();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if(browserName == null)
			browserName = defaultBrowser;

		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeToWait);
	}
	
	public Browser(String browserName)
	{
		driverSetting = new DriverSettings();
		driverSetting.setUpDriver(browserName, timeToWait);
	}
	
	public Browser(String browserName, int timeUnitInSecond)
	{
		driverSetting = new DriverSettings();
		timeToWait = timeUnitInSecond;
		driverSetting.setUpDriver(browserName, timeUnitInSecond);
	}
	
	public void close()
	{
		driverSetting.closeDriver();
	}

	public void navigateTo()
	{
		Driver.driver.get(baseURL);
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
	
	public void setWait(int milisec)
	{
		driverSetting.setWait(milisec);
	}
	
	public void setDefaultWait()
	{
		driverSetting.setWait(timeToWait);
	}
	
	public void waitForElement(Element element, long maxTimeoutMiliSec) throws Exception
	{
		if(maxTimeoutMiliSec<=0)
		{
			throw new Exception("In-correct time out enetered");
		}
		int offsetTime = 100;
		int waitTime = offsetTime - timeToWait;
		long timeSpent = 0;
		do
		{
			try
			{
				if(element.isDisplayed()==true)
				{
					return;
				}
			}
			finally
			{
				;
			}
			TestUtils.delay(waitTime);
			timeSpent = timeSpent + offsetTime;
		}
		while(timeSpent < maxTimeoutMiliSec);
	}
}
