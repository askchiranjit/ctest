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
	}
	public ServicesList servicesList=new ServicesList(); 

}
