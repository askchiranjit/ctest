package com.ensimtest.resource;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.testng.annotations.DataProvider;

import com.ensimtest.resource.TestConfigHandler;

public class TestDataProvider {

	@DataProvider(name = "TestData")
	public static Object[][] fetchData(Method m)
	{
		XLSFileReader xr=new XLSFileReader("resources\\testdata\\"+m.getDeclaringClass().getSimpleName()+".xlsx");
		TestConfigHandler tu=new TestConfigHandler();
		return tu.getData(xr, m.getName());

		

	}

}
