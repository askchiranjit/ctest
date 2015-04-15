package com.ensimtest.resource;

import java.lang.reflect.Method;
import java.util.HashMap;
import org.testng.annotations.DataProvider;

import com.ensimtest.resource.TestConfigHandler;

public class TestDataProvider {

	@DataProvider(name = "TestData")
	public static Object[][] fetchData(Method m)
	{
		Xls_Reader xr=new Xls_Reader("resources\\testdata\\"+m.getDeclaringClass().getSimpleName()+".xlsx");
		TestConfigHandler tu=new TestConfigHandler();
		return tu.getData(xr, m.getName());

		

	}

}
