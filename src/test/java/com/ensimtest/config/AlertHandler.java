package com.ensimtest.config;

import com.ensimtest.base.Driver;

public class AlertHandler
{
	public void acceptAlert()
	{
		Driver.driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		Driver.driver.switchTo().alert().dismiss();
	}
	
	public String getTextInAlert()
	{
		return Driver.driver.switchTo().alert().getText();
	}
}
