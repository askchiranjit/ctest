package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class Templates34 extends AppData
{

	public class Template extends Element
	{
		public String name,os,minCPU,minRam,minHDD;
		
		
		private Element setElement(Element innerElements[])
		{
			if(innerElements == null)
			{
				return null;
			}
			else
			{
				if(innerElements.length == 0)
				{
					return null;
				}
				else
				{
					return innerElements[0];
				}
			
			}
		}
		
		public Template(Element element)
		{
			ElementSet elementSet=new ElementSet();
			name=setElement(elementSet.getSubElementSet(element, "Xpath", "*//table//tbody//tr//td[2]")).read().trim();
			os=setElement(elementSet.getSubElementSet(element, "Xpath", "*//table//tbody//tr//td[3]")).read().trim();
			minCPU=setElement(elementSet.getSubElementSet(element, "Xpath", "*//table//tbody//tr//td[4]")).read().trim();
			minRam=setElement(elementSet.getSubElementSet(element, "Xpath", "*//table//tbody//tr//td[5]")).read().trim();
			minHDD=setElement(elementSet.getSubElementSet(element, "Xpath", "*//table//tbody//tr//td[6]")).read().trim();
		}
		
	}
	
	public Template[] getTemplates(Browser browser)
	{
		try
		{
		browser.setWait(1);
		ElementSet temPlates=new ElementSet();
		Element template[]=temPlates.getElementSet("Xpath", "//div[contains(@class,'ui-accordion-content-active')]//table[@class='bordered']");
		Template vmtemplate[]=new Template[template.length];
		for(int i=0;i<template.length;i++)
		{
			vmtemplate[i]=new Template(template[i]);
		}
		return vmtemplate;
		}
		finally
		{
			browser.setDefaultWait();
		}
		
	}
	
}
