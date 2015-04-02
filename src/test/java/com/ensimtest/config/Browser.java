package com.ensimtest.config;

import com.ensimtest.base.Driver;

public class Browser {

	public void GoTo(String URL)
	{
		
		//
		Driver.driver.get(URL);
	}
}
