package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Added for Billing List
 * @author Karabi
 *
 */

public class BillingOptions extends AppData
{
	public class BillingMenu extends Element
	{

		public BillingMenu()
		{
			setElement(readAppData(this));
		}
		public void mouseHover()
		{
			super.mouseHover();
		}	

	}
	public BillingMenu billingMenu = new BillingMenu();

	public class InvoicesLink extends Element{
		public InvoicesLink()
		{
			setElement(readAppData(this));
		}
	}
	public InvoicesLink invoicesLink = new InvoicesLink();

	public class PaymentLink extends Element{
		public PaymentLink()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentLink paymentLink = new PaymentLink();

}
