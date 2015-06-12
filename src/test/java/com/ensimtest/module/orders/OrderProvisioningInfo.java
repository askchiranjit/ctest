package com.ensimtest.module.orders;

import com.ensimtest.config.Browser;
import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class OrderProvisioningInfo extends AppData 
{
    public class ProvInfoLst extends Element
    {
   	
    	public ProvItemLst[] getProvInfos(Browser browser)
    	{
    		try
    		{
    		browser.setWait(1);
    		ElementSet elementSet = new ElementSet();
    		Element provInfoLst[]=elementSet.getElementSet("Xpath", "//table[@id='copy_width_from']//tbody//tr");
    		System.out.println("No of provisioning Item:- "+provInfoLst.length);
    		
    		ProvItemLst provItemLst[]=new ProvItemLst[provInfoLst.length];
    		for(int i=0;i<provInfoLst.length;i++)
    		{
    			provItemLst[i]=new ProvItemLst(provInfoLst[i]);
    		}
    		
			return provItemLst;
    		}
    		finally
    		{
    			browser.setDefaultWait();
    		}
    		
    	}
    }
    public ProvInfoLst provInfoLst= new ProvInfoLst();
    
    
    public class ProvItemLst
    {
    	public String itemName;
    	public Element textbox,dropDown;
    	
    	
    	public ProvItemLst(Element e)
    	{
    		this.itemName=null;
    		this.textbox=null;
 
          	ElementSet elementSet = new ElementSet();
          	Element ele[];
    		if((ele=elementSet.getSubElementSet(e, "Xpath", "td"))!=null)
    		{
    			this.itemName=ele[0].read();
    			if(ele.length>1)
    			{
    			provInfoType(ele[1]);
    			}
    		}
    	

    		
    	}
    	private Element setElement(Element []innerElements)
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
    	public void provInfoType(Element e)
    	{
    		//text area
    		ElementSet elementSet = new ElementSet();
    		textbox=setElement(elementSet.getSubElementSet(e, "Xpath","textarea|input"));
    		dropDown=setElement(elementSet.getSubElementSet(e, "Xpath", "select"));
    		
    		
    	}
    }
    
    
    
    
    
}
