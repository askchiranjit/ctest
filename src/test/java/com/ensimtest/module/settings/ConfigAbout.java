package com.ensimtest.module.settings;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ConfigAbout extends AppData
{
	public class VersionNumber extends Element
	{
		public VersionNumber()
		{
			setElement(readAppData(this));
		}
	}
	VersionNumber versionNumber = new VersionNumber();
	
	public class BuildDate extends Element
	{
		public BuildDate()
		{
			setElement(readAppData(this));
		}
	}
	BuildDate buildDate = new BuildDate();
	
	public class GrailsVersion extends Element
	{
		public GrailsVersion()
		{
			setElement(readAppData(this));
		}
	}
	GrailsVersion grailsVersion = new GrailsVersion();
	
	public class JVMVersion extends Element
	{
		public JVMVersion()
		{
			setElement(readAppData(this));
		}
	}
	JVMVersion jVMVersion = new JVMVersion();
	
	public class DefaultLocale extends Element
	{
		public DefaultLocale()
		{
			setElement(readAppData(this));
		}
	}
	DefaultLocale defaultLocale = new DefaultLocale(); 
}
