package com.ensimtest.config;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.ensimtest.base.Driver;

public class Browser {

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
