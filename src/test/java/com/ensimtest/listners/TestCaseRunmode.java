package com.ensimtest.listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import com.ensimtest.resource.TestConfigHandler;
import com.ensimtest.resource.XLSFileReader;

public class TestCaseRunmode implements IAnnotationTransformer {

	@SuppressWarnings({ "static-access", "rawtypes" })
	@Override
	public void transform(ITestAnnotation anotationName, Class className, Constructor constructorName,Method methodName)
	{
		TestConfigHandler testConfigHandler=new TestConfigHandler();
		String simpleName=methodName.getDeclaringClass().getSimpleName();
		XLSFileReader xlsReadFile=new XLSFileReader("resources\\testdata\\"+simpleName+".xlsx");
		String simpleMethodName=methodName.getName();
		if(testConfigHandler.isTestCaseRunnable(xlsReadFile,simpleMethodName)==false)
		{
			anotationName.setEnabled(false);
		}
		xlsReadFile=null;
		testConfigHandler=null;
		}
	}


