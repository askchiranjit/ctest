package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ItemLandingPage extends AppData
{
	
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
	
	public class BaseItemBtn extends Element
	{
		public BaseItemBtn()
		{
			setElement(readAppData(this));
		}
	}
	public BaseItemBtn baseItemBtn = new BaseItemBtn();

	public class BundleItemBtn extends Element
	{
		public BundleItemBtn()
		{
			setElement(readAppData(this));
		}
	}
	public BundleItemBtn bundleItemBtn = new BundleItemBtn();

	public class CompositeItemBtn extends Element
	{
		public CompositeItemBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CompositeItemBtn compositeItemBtn = new CompositeItemBtn();
	
	
	public class HeadingTxt extends Element
	{
		public HeadingTxt()
		{
			setElement(readAppData(this));
		}
	}
   public HeadingTxt headingTxt=new HeadingTxt();

}
