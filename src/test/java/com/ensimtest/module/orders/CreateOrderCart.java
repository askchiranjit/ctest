package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.resource.AppData;

public class CreateOrderCart extends AppData
{
	
	public class CartOrderDetails
	{
		
		public String offerName,totalAmount;
		public Element orderNo,checkBox,editBtn,removeBtn;
				
		public CartOrderDetails(Element e)
		{
			ElementSet elementSet=new ElementSet();
			this.offerName=setElement(elementSet.getSubElementSet(e, "Xpath", "td[3]")).read();
			this.orderNo=setElement(elementSet.getSubElementSet(e, "Xpath", "td[2]//div//a"));
			this.checkBox=setElement(elementSet.getSubElementSet(e, "Xpath", "td[1]//div//input"));
			this.editBtn=setElement(elementSet.getSubElementSet(e, "Xpath", "td[4]//table//tbody//tr//td//a[@id='edit']"));
			this.removeBtn=setElement(elementSet.getSubElementSet(e, "Xpath", "td[4]//table//tbody//tr//td//a[@id='abort']"));
			String []temp = setElement(elementSet.getSubElementSet(e, "Xpath", "td[4]//table//tbody//tr//td[@class='borderAllAroundgrey']")).read().split(" ");
			this.totalAmount = temp[temp.length-1].trim();
			System.out.println(this.offerName);
			System.out.println(this.orderNo);
			System.out.println(this.checkBox);
			System.out.println(this.editBtn);
			System.out.println(this.removeBtn);
			System.out.println(this.totalAmount);
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
	
	public class CartDetails extends Element
	{

		public CartOrderDetails[] getOrderList()
		{
			ElementSet elementSet=new ElementSet();
			Element e[]=elementSet.getElementSet("Xpath", "//table[@class='borderAllArounddotted']/tbody/tr");
			CartOrderDetails cartOrderLst[]=new CartOrderDetails[e.length-1];
			for(int i=1;i<e.length;i++)
			{
				cartOrderLst[i-1]=new CartOrderDetails(e[i]);
			}
			return cartOrderLst;
			
			
		}
	}
	
	public CartDetails cartDetails=new CartDetails();
	
	public class CheckoutBtn extends Element
	{
		public CheckoutBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public CheckoutBtn checkoutBtn=new CheckoutBtn();
	
	public class YesBtn extends Element
	{
		public YesBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public YesBtn yesBtn=new YesBtn();
	
	
	public class OrderSuccessMsg extends Element
	{
		public OrderSuccessMsg()
		{
			setElement(readAppData(this));
		}
	}
	
	public OrderSuccessMsg orderSuccessMsg=new OrderSuccessMsg();

}
