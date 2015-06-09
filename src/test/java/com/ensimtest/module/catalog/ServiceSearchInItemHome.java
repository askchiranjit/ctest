package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class ServiceSearchInItemHome extends AppData
{
	private class RowInfo
	{
		public String []info;
		public RowInfo()
		{
			info = readAppData(this);
		}
	}
	
	private class Components
	{
		public String []info;
		public Components()
		{
			info = readAppData(this);
		}
	}
	
     public class ServiceResultRows extends Element
     {
    	 public ServiceResultRows()
    	 {
    		 setElement(readAppData(this));
    	 }
    	 
    	 public ServiceRowInItemHome[] getServiceRows()
    	 {
    		 ElementSet set = new ElementSet();
    		 RowInfo rowInfo=new RowInfo();
    		 Element []elements=set.getSubElementSet(super.getElement(), rowInfo.info[0], rowInfo.info[1]);
    		 ServiceRowInItemHome []rows = new ServiceRowInItemHome[elements.length];
    		 for(int i=0;i<elements.length;i++)
    		 {
    			 rows[i] = new ServiceRowInItemHome(elements[i]);
    		 }
    		 
    		 return rows;
    	 }
     }
     
     public ServiceResultRows serviceResultRow=new ServiceResultRows();
     
     public class ServiceRowInItemHome
     {
    	public Element serviceName,resellerPricePlan;
	
    	 
    	 ServiceRowInItemHome(Element element)
 		{
    		Components component=new Components();
 			ElementSet es=new ElementSet();
 			Element e[]=es.getSubElementSet(element, component.info[0], component.info[1]);
 			serviceName=e[0];
 			resellerPricePlan=e[1];
 		}
     }
}
