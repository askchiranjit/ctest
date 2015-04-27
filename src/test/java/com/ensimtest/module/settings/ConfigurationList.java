package com.ensimtest.module.settings;

import com.ensimtest.base.ElementType;
import com.ensimtest.config.Element;

public class ConfigurationList extends Element
{
	public Element getConfigurationOptionLnk(ConfigurationType type)
	{
		String data = "//a[contains(text(),'" + type.toString().replace('_', ' ') + "')]";
		setElement(ElementType.Xpath, data);
		return this;
	}
}
