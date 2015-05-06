package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Organization Payment Addition screen
 * @author Karabi
 *
 */

public class PaymentCreation extends AppData
{

	public class PaymentReceivedRdo extends Element
	{
		public PaymentReceivedRdo()
		{
			setElement(readAppData(this));
		}
		

	}
	
	public PaymentReceivedRdo paymentReceivedRdo=new PaymentReceivedRdo();
	
	public class AdjustmentRdo extends Element
	{
		public AdjustmentRdo()
		{
			setElement(readAppData(this));
		}
				
	}
	
	public AdjustmentRdo adjustmentRdo=new AdjustmentRdo();

   public class PaymentDate extends Element
   {
	   public PaymentDate()
	   {
		   setElement(readAppData(this));
	   }
   }
   public PaymentDate paymentDate=new PaymentDate();

}
