package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class OrderActionCustomer extends AppData
{
	public class EditBtn extends Element
	{
		public EditBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditBtn editBtn = new EditBtn();

	public class UpsizeBtn extends Element
	{
		public UpsizeBtn()
		{
			setElement(readAppData(this));
		}
	}
	public UpsizeBtn upsizeBtn = new UpsizeBtn();

	public class DownsizeBtn extends Element
	{
		public DownsizeBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DownsizeBtn downsizeBtn = new DownsizeBtn();

	public class ViewHistoryBtn extends Element
	{
		public ViewHistoryBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ViewHistoryBtn viewHistoryBtn = new ViewHistoryBtn();

	public class ConfigureBtn extends Element
	{
		public ConfigureBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ConfigureBtn configureBtn = new ConfigureBtn();

	public class CancelBtn extends Element
	{
		public CancelBtn()
		{
			setElement(readAppData(this));
		}
	}
	public CancelBtn cancelBtn = new CancelBtn();

	public class AbortBtn extends Element
	{
		public AbortBtn()
		{
			setElement(readAppData(this));
		}
	}
	public AbortBtn abortBtn = new AbortBtn();

	public class SuspendBtn extends Element
	{
		public SuspendBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SuspendBtn suspendBtn = new SuspendBtn();

	public class UpgradeBtn extends Element
	{
		public UpgradeBtn()
		{
			setElement(readAppData(this));
		}
	}
	public UpgradeBtn upgradeBtn = new UpgradeBtn();

	public class DowngradeBtn extends Element
	{
		public DowngradeBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DowngradeBtn downgradeBtn = new DowngradeBtn();

	public class ResumeBtn extends Element
	{
		public ResumeBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ResumeBtn resumeBtn = new ResumeBtn();

	public class SeekApprovalBtn extends Element
	{
		public SeekApprovalBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SeekApprovalBtn seekApprovalBtn = new SeekApprovalBtn();

	public class RetryBtn extends Element
	{
		public RetryBtn()
		{
			setElement(readAppData(this));
		}
	}
	public RetryBtn retryBtn = new RetryBtn();

	public class ApproveBtn extends Element
	{
		public ApproveBtn()
		{
			setElement(readAppData(this));
		}
	}
	public ApproveBtn approveBtn = new ApproveBtn();

	public class RectifyFailureBtn extends Element
	{
		public RectifyFailureBtn()
		{
			setElement(readAppData(this));
		}
	}
	public RectifyFailureBtn rectifyFailureBtn = new RectifyFailureBtn();

	public class DiscardDraftBtn extends Element
	{
		public DiscardDraftBtn()
		{
			setElement(readAppData(this));
		}
	}
	public DiscardDraftBtn discardDraftBtn = new DiscardDraftBtn();

	public class OrderNumberLbl extends Element
	{
		public OrderNumberLbl()
		{
			setElement(readAppData(this));
		}
	}
	public OrderNumberLbl orderNumberLbl = new OrderNumberLbl();

	public class Status extends Element
	{
		public Status()
		{
			setElement(readAppData(this));
		}
	}
	public Status status = new Status();

	public class GenerateQuotaBtn extends Element
	{
		public GenerateQuotaBtn()
		{
			setElement(readAppData(this));
		}
	}
	public GenerateQuotaBtn generateQuotaBtn = new GenerateQuotaBtn();
}
