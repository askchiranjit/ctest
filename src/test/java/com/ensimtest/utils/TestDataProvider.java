package com.ensimtest.utils;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "TestData")
	public static Object[][] fetchData(Method m)
	{
		Xls_Reader xr=new Xls_Reader("resources\\testdata\\"+m.getDeclaringClass().getSimpleName()+".xlsx");
		TestUtils tu=new TestUtils();
		return tu.getData(xr, m.getName());

		

	}

}
