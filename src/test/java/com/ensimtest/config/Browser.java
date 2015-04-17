package com.ensimtest.config;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.ensimtest.base.Driver;

public class Browser {

	public void navigateTo(String URL)
	{
		Driver.driver.get(URL);
	}
	
	public String getCurrntUrl()
	{
		return Driver.driver.getCurrentUrl();
	}
	
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
