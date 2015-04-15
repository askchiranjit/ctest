package com.ensimtest.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import com.ensimtest.resource.TestConfigHandler;
import com.ensimtest.resource.Xls_Reader;

public class TestCaseRunmode implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation anotation_name, Class class_name, Constructor constructor_name,Method methode_name)
	{
		TestConfigHandler tu=new TestConfigHandler();
		String C_name=methode_name.getDeclaringClass().getSimpleName();
		Xls_Reader xr=new Xls_Reader("resources\\testdata\\"+C_name+".xlsx");
		String M_name=methode_name.getName();
		if(tu.isTestCaseRunnable(xr,M_name)==false)
		{
			anotation_name.setEnabled(false);
		}
		xr=null;
		tu=null;
	}

}
