package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;

public class SelectServiceFromSugList extends Element
{
   public SelectServiceFromSugList(String service)
   {
	   String Eliment[]=new String[2];
	   Eliment[0]="Xpath";
	   Eliment[1]="//div[@id='suggestedServiceDialog']//tr//td[contains(text(),'"+service+"')]//preceding::td[1]//label";
	   setElement(Eliment);
   }
	
}
