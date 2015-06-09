package com.ensimtest.module.catalog;

import org.openqa.selenium.Keys;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class AddBaseItem extends AppData
{
	public class ItemCodeTxt extends Element
	{
		public ItemCodeTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public ItemCodeTxt itemCodeTxt = new ItemCodeTxt();

	public class UniqueIdentifierTxt extends Element
	{
		public UniqueIdentifierTxt()
		{
			setElement(readAppData(this));
		}
		
		
	}
	public UniqueIdentifierTxt uniqueIdentifierTxt = new UniqueIdentifierTxt();

	public class ItemNameTxt extends Element
	{
		public ItemNameTxt()
		{
			setElement(readAppData(this));
		}
	}
	public ItemNameTxt itemNameTxt = new ItemNameTxt();

	public class DescriptionTxt extends Element
	{
		public DescriptionTxt()
		{
			setElement(readAppData(this));
		}
	}
	public DescriptionTxt descriptionTxt = new DescriptionTxt();

	public class BillOfMaterialCostTxt extends Element
	{
		public BillOfMaterialCostTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public void write(String msg)
		{
			super.write(Keys.CONTROL + "a");
			super.write(msg);
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public BillOfMaterialCostTxt billOfMaterialCostTxt = new BillOfMaterialCostTxt();

	public class PrimaryVendorCostTxt extends Element
	{
		public PrimaryVendorCostTxt()
		{
			setElement(readAppData(this));
		}
		@Override
		public void write(String msg)
		{
			super.write(Keys.CONTROL + "a");
			super.write(msg);
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public PrimaryVendorCostTxt primaryVendorCostTxt = new PrimaryVendorCostTxt();

	public class CustomField1 extends Element
	{
		public CustomField1()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField1 customField1 = new CustomField1();

	public class CustomField2 extends Element
	{
		public CustomField2()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField2 customField2 = new CustomField2();

	public class CustomField3 extends Element
	{
		public CustomField3()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField3 customField3 = new CustomField3();

	public class CustomField4 extends Element
	{
		public CustomField4()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField4 customField4 = new CustomField4();

	public class CustomField5 extends Element
	{
		public CustomField5()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField5 customField5 = new CustomField5();

	public class CustomField6 extends Element
	{
		public CustomField6()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField6 customField6 = new CustomField6();

	public class CustomField7 extends Element
	{
		public CustomField7()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField7 customField7 = new CustomField7();

	public class CustomField8 extends Element
	{
		public CustomField8()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField8 customField8 = new CustomField8();

	public class CustomField9 extends Element
	{
		public CustomField9()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField9 customField9 = new CustomField9();

	public class CustomField10 extends Element
	{
		public CustomField10()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField10 customField10 = new CustomField10();

	public class CustomField11 extends Element
	{
		public CustomField11()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField11 customField11 = new CustomField11();

	public class CustomField12 extends Element
	{
		public CustomField12()
		{
			setElement(readAppData(this));
		}
		@Override
		public String read()
		{
			return super.getAttributeValue("value");
		}
	}
	public CustomField12 customField12 = new CustomField12();

	public class CancleBtn extends Element
	{
		public CancleBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancleBtn cancleBtn = new CancleBtn();

	public class SaveBtn extends Element
	{
		public SaveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SaveBtn saveBtn = new SaveBtn();

	public class ResourceRefLst extends Element
	{
		public ResourceRefLst()
		{
			setElement(readAppData(this));
		}
		public void selectResourceRef(String resoRef)
		{
			super.selectVisibleText(resoRef);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public ResourceRefLst resourceRefLst = new ResourceRefLst();

	public class ItemTypeLst extends Element
	{
		public ItemTypeLst()
		{
			setElement(readAppData(this));
		}
		public void selectItemType(String itemType)
		{
			super.selectVisibleText(itemType);
		}
		public String getSelectedType()
		{
			return super.getSelectedType();
		}
	}
	public ItemTypeLst itemTypeLst = new ItemTypeLst();
	
	public class GuidAvailable extends Element
	{
		public GuidAvailable()
		{
			setElement(readAppData(this));
		}
	}
	
	public GuidAvailable guidAvailable=new GuidAvailable();
	
	public class ProvInfoReq extends Element
	{
		public ProvInfoReq()
		{
			setElement(readAppData(this));
		}
		
		public void selectProvInfo(String provInfo)
		{
			super.selectVisibleText(provInfo);
		}
		public String[] getAllSelectedIdfrs()
		{
			return super.getSelectedTypes();
		}
	}
	
	public ProvInfoReq provInfoReq=new ProvInfoReq();
	
}
