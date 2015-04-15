package com.ensimtest.config;

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
}
