package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ServiceHome extends AppData
{
	public class AddServiceBtn extends Element
	{
		public AddServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AddServiceBtn addServiceBtn = new AddServiceBtn();

	public class ImportServiceBtn extends Element
	{
		public ImportServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ImportServiceBtn importServiceBtn = new ImportServiceBtn();
	
	public class EditServiceBtn extends Element
	{
		public EditServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditServiceBtn editServiceBtn = new EditServiceBtn();
	
	public class DeleteServiceBtn extends Element
	{
		public DeleteServiceBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DeleteServiceBtn deleteServiceBtn = new DeleteServiceBtn();
	
	public class NextImg extends Element
	{
		public NextImg()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").equalsIgnoreCase("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public NextImg nextImg=new NextImg();
	
	public class PreviousImg extends Element
	{
		public PreviousImg()
		{
			setElement(readAppData(this));
		}
		
		@Override
		public boolean isEnabled()
		{
			if(getAttributeValue("class").equalsIgnoreCase("disabledImage"))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	public PreviousImg previousImg=new PreviousImg();
	
	
	public class SearchServiceTxt extends Element
	{
		public SearchServiceTxt()
		{
			setElement(readAppData(this));
		}
	}
	public SearchServiceTxt searchServiceTxt = new SearchServiceTxt();
	
	public class SearchServiceImg extends Element
	{
		public SearchServiceImg()
		{
			setElement(readAppData(this));
		}
	}
	public SearchServiceImg searchServiceImg = new SearchServiceImg();
	
	public class ConfigurResourceBtn extends Element
	{
		public ConfigurResourceBtn()
		{
			setElement(readAppData(this));
		}
		
	}
	public ConfigurResourceBtn configurResourceBtn=new ConfigurResourceBtn();
}
