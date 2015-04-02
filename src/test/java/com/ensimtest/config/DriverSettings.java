package com.ensimtest.config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.ensimtest.base.Driver;

public class DriverSettings
{
	public void setUpDriver()
	{
		setUpDriver("firefox", 30);
	}
	
	
	public void setUpDriver(String browserName, int timeUnitInSecond)
	{
		System.out.println(System.getProperty("user.dir"));
		
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
	
	protected void setWait(int timeUnitInSecond)
	{
		Driver.driver.manage().timeouts().implicitlyWait(timeUnitInSecond, TimeUnit.SECONDS);
	}
	
	protected void setBrowserAtMaxSize()
	{
		Driver.driver.manage().window().maximize();
	}
	
	public void closeDriver()
	{
		Driver.driver.manage().deleteAllCookies();
		Driver.driver.close();
		Driver.driver.quit();
		
	}
}
