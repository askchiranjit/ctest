package com.ensimtest.module.orders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class CreateOrderSummary extends AppData
{
	public class EmailBCLbl extends Element
	{
		public EmailBCLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailBCLbl emailBCLbl = new EmailBCLbl();

	public class EmailTCLbl extends Element
	{
		public EmailTCLbl()
		{
			setElement(readAppData(this));
		}
	}
	public EmailTCLbl emailTCLbl = new EmailTCLbl();

	public class ServiceAccountLbl extends Element
	{
		public ServiceAccountLbl()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceAccountLbl serviceAccountLbl = new ServiceAccountLbl();

	public class BillableAccountLbl extends Element
	{
		public BillableAccountLbl()
		{
			setElement(readAppData(this));
		}
	}
	public BillableAccountLbl billableAccountLbl = new BillableAccountLbl();
	
	public class IAgreeTC extends Element
	{
		public IAgreeTC()
		{
			setElement(readAppData(this));
		}
	}
	public IAgreeTC iAgreeTC = new IAgreeTC();
	
	public class IDisagreeTC extends Element
	{
		public IDisagreeTC()
		{
			setElement(readAppData(this));
		}
	}
	public IDisagreeTC iDisagreeTC = new IDisagreeTC();
	
	public class InternalNotesTC extends Element
	{
		public InternalNotesTC()
		{
			setElement(readAppData(this));
		}
	}
	public InternalNotesTC internalNotesTC = new InternalNotesTC();
	
	public class CloseTCBtn extends Element
	{
		public CloseTCBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CloseTCBtn closeTCBtn = new CloseTCBtn();
	
	public class SubmitTCBtn extends Element
	{
		public SubmitTCBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SubmitTCBtn submitTCBtn = new SubmitTCBtn();
	
	public class ApproveOrder extends Element
	{
		public ApproveOrder()
		{
			setElement(readAppData(this));
		}
	}
	public ApproveOrder approveOrder = new ApproveOrder();
	
	public class ApproveOrderCancelBtn extends Element
	{
		public ApproveOrderCancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ApproveOrderCancelBtn approveOrderCancelBtn = new ApproveOrderCancelBtn();
	
	public class ApproveOrderApproveNowBtn extends Element
	{
		public ApproveOrderApproveNowBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ApproveOrderApproveNowBtn approveOrderApproveNowBtn = new ApproveOrderApproveNowBtn();
	
	public class ApproveOrderMsgLbl extends Element
	{
		public ApproveOrderMsgLbl()
		{
			setElement(readAppData(this));
		}
		public String getRefNumber()
		{
			String text = super.read();
			String re1=".*?";
		    String re2="((?:(?:[1]{1}\\d{1}\\d{1}\\d{1})|(?:[2]{1}\\d{3}))[-:\\/.](?:[0]?[1-9]|[1][012])[-:\\/.](?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])";	// YYYYMMDD 1
		    String re3="([-+]\\d+)";

		    Pattern p = Pattern.compile(re1+re2+re3,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    Matcher m = p.matcher(text);
		    String refNumber = null;
		    if (m.find())
		    {
		        String yyyymmdd1=m.group(1);
		        String signed_int1=m.group(2);
		        refNumber = yyyymmdd1.toString()+signed_int1.toString();
		        return refNumber;
		    }
		    else
		    {
		    	text = text.replaceAll("Order with reference number", "");
		    	text = text.replaceAll("has been submitted for provisioning", "");
		    	refNumber = text.trim();
		    }
		    return refNumber;
		}
	}
	public ApproveOrderMsgLbl approveOrderMsgLbl = new ApproveOrderMsgLbl();
	
	public class OrderNOCustomer extends Element
	{
		public OrderNOCustomer()
		{
			setElement(readAppData(this));
		}
	}
	
	public OrderNOCustomer orderNOCustomer= new OrderNOCustomer();
	
	
	public class GotoCartBtn extends Element
	{
		public GotoCartBtn()
		{
			setElement(readAppData(this));
		}
	}
	
	public GotoCartBtn gotoCartBtn= new GotoCartBtn();
	
	
	
}
