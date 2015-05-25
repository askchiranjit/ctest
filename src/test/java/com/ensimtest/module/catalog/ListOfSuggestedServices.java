package com.ensimtest.module.catalog;



import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ListOfSuggestedServices extends AppData
{

	public class OkBtn extends Element
	{
		public OkBtn()
		{
			setElement(readAppData(this));
		}
	}
	public OkBtn okBtn=new OkBtn();
	
	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn=new CancelBtn();
	
	public class ServicesList
	{
		public ServicesList(){}
	
		public void selectServices(String serives)
		{
		
		String[] serviceslst=serives.split(";");
		for(int i=0;i<serviceslst.length;i++)
		{
		    SelectServiceFromSugList selService=new SelectServiceFromSugList(serviceslst[i].trim());
			selService.click();
		}
		
		}
		
		public boolean isServicesSelected(String services)
		{
			boolean flag=true;
			String[] serviceslst=services.split(";");
			for(int i=0;i<serviceslst.length;i++)
			{
			    SelectServiceFromSugList selService=new SelectServiceFromSugList(serviceslst[i].trim());
				if(!selService.getAttributeValue("class").contains("c_on"))
				{
					flag=false;
					break;
				}
			}
			return flag;
		}
		
	}
	public ServicesList servicesList=new ServicesList(); 

}
