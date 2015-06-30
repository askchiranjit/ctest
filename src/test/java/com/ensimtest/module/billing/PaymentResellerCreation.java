package com.ensimtest.module.billing;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * Added for creating reseller payment
 * @author Karabi
 *
 */

public class PaymentResellerCreation extends AppData{
	
	public class ResellerPaymentTab extends Element{
		public ResellerPaymentTab()
		{
			setElement(readAppData(this));
		}
	}
	public ResellerPaymentTab resellerPaymentTab = new ResellerPaymentTab();

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
	
	public class ResellerId extends Element
	{
		public ResellerId()
		{
			setElement(readAppData(this));
		}
	}
	
	public ResellerId resellerId=new ResellerId();
	
	public class PaymentDate extends Element
	{
		public PaymentDate()
		{
			setElement(readAppData(this));
		}
	}
	public PaymentDate paymentDate=new PaymentDate();

	public class AmountPaid extends Element
	{
		public AmountPaid()
		{
			setElement(readAppData(this));
		}
	}
	public AmountPaid amountPaid=new AmountPaid();

	public class Currency extends Element
	{
		public Currency()
		{
			setElement(readAppData(this));
		}
	}
	public Currency currency=new Currency();
	
	public class ModeOfPaymentLst extends Element
	{
		public ModeOfPaymentLst()
		{
			setElement(readAppData(this));
		}
		public void selectPayment(String payment)
		{
			super.selectVisibleText(payment);
		}
	}
	public ModeOfPaymentLst modeOfPaymentLst=new ModeOfPaymentLst();
	

	/**
	 * Fields Based on the payment mode selected
	 */
	
	/**
	 * Field for NetBanking
	 */
	public class FinancialInstitutionLst extends Element
	{
		public FinancialInstitutionLst()
		{
			setElement(readAppData(this));
		}
	}
	public FinancialInstitutionLst financialInstitutionLst=new FinancialInstitutionLst();
	
	/**
	 * Fields when selecting Credit Card/Debit Card
	 */
	public class CardType extends Element
	{
		public CardType()
		{
			setElement(readAppData(this));
		}
	}
	public CardType cardType=new CardType();
	
	public class InstrumentNumber extends Element
	{
		public InstrumentNumber()
		{
			setElement(readAppData(this));
		}
	}
	public InstrumentNumber instrumentNumber=new InstrumentNumber();
	
	/**
	 * Field when selecting Cheque
	 */
	public class ChequeDate extends Element
	{
		public ChequeDate()
		{
			setElement(readAppData(this));
		}
	}
	public ChequeDate chequeDate=new ChequeDate();
	
	public class AdjustmentNumberTxt extends Element
	   {
		   public AdjustmentNumberTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public AdjustmentNumberTxt adjustmentNumberTxt = new AdjustmentNumberTxt();
	
	public class CommentsTxt extends Element
	   {
		   public CommentsTxt()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CommentsTxt commentsTxt = new CommentsTxt();
	
	/**
	 * Adjustment Type Fields
	 * @author Karabi
	 *
	 */
	public class CreditNoteRDo extends Element
	   {
		   public CreditNoteRDo()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CreditNoteRDo creditNoteRDo = new CreditNoteRDo();
	
	public class DebitNoteRDo extends Element
	   {
		   public DebitNoteRDo()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public DebitNoteRDo debitNoteRDo = new DebitNoteRDo();
	
	/**
	 * The Buttons present on the screen
	 * @author Karabi
	 *
	 */
	
	public class CancelBtn extends Element
	   {
		   public CancelBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public CancelBtn cancelBtn = new CancelBtn();
	
	public class SavePaymentBtn extends Element
	   {
		   public SavePaymentBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public SavePaymentBtn savePaymentBtn = new SavePaymentBtn();
	
	public class UploadCsvBtn extends Element
	   {
		   public UploadCsvBtn()
		   {
			   setElement(readAppData(this));
		   }
	   }
	public UploadCsvBtn uploadCsvBtn = new UploadCsvBtn();

	
}
