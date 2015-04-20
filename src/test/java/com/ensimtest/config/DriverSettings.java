package com.ensimtest.config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.ensimtest.base.Driver;

public class DriverSettings
{
	/**
	 * Default browser set-up. It will open firefox with
	 * 30 seconds of implicit time-out.
	 */
	public void setUpDriver()
	{
		setUpDriver("firefox", 30);
	}
	
	/**
	 * Overloaded browser setup with browser name and time-out being
	 * sent as parameter
	 * @param browserName : name of the browser (like: firefox, ie, chrome) case insensitive
	 * @param timeUnitInSecond : Timeout second for implicit time-out
	 */
	public void setUpDriver(String browserName, int timeUnitInSecond)
	{
		DesiredCapabilities cap = null;
		switch(browserName.trim().toLowerCase())
		{
		case "firefox" : 
			cap = DesiredCapabilities.firefox();
			Driver.driver = new FirefoxDriver(cap);
			break;
		case "ie" :
			System.setProperty("webdriver.ie.driver", "resources\\thirdparty\\IEDriverServer.exe");
			cap = DesiredCapabilities.internetExplorer();
			Driver.driver = new InternetExplorerDriver(cap);
			break;
		case "chrome" : 
			System.setProperty("webdriver.ie.driver", "resources\\thirdparty\\chromedriver.exe");
			cap = DesiredCapabilities.chrome();
			Driver.driver = new InternetExplorerDriver(cap);
			break;
		default : 
			cap = DesiredCapabilities.firefox();
			break;
		}
		setWait(timeUnitInSecond);
		setBrowserAtMaxSize();
	}
	
	/**
	 * Sets the implicit time out as parameter
	 * @param timeUnitInSecond : Timeout second for implicit time-out
	 */
	protected void setWait(int timeUnitInSecond)
	{
		Driver.driver.manage().timeouts().implicitlyWait(timeUnitInSecond, TimeUnit.SECONDS);
	}
	
	/**
	 * Sets the browser at maximum size of the screen
	 */
	protected void setBrowserAtMaxSize()
	{
		Driver.driver.manage().window().maximize();
	}
	
	/**
	 * Closes the driver, deletes all cookies
	 */
	public void closeDriver()
	{
		Driver.driver.manage().deleteAllCookies();
		Driver.driver.close();
		Driver.driver.quit();
	}
}
