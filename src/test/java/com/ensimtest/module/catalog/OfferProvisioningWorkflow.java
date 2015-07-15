package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * To set provisioning work flow part of offer
 * @author Dip
 *
 */
public class OfferProvisioningWorkflow extends AppData {

	/*
	 * To select Provisioning Work flow type
	 */
	public class ProvisioningWorkflowLst extends Element{
		public ProvisioningWorkflowLst(){
			setElement(readAppData(this));
		}
		
		public void select(String data){
			super.selectVisibleText(data);
		}
	}
	
	public ProvisioningWorkflowLst provisioningWorkflowLst = new ProvisioningWorkflowLst();
	
	/*
	 * Organization must approve check
	 */
	public class OrganizationMustApproveChk extends Element{
		public OrganizationMustApproveChk(){
			setElement(readAppData(this));
		}
	}
	
	public OrganizationMustApproveChk organizationMustApproveChk = new OrganizationMustApproveChk();
	
	/*
	 * Provider must approve check
	 */
	public class ProviderMustApproveChk extends Element{
		public ProviderMustApproveChk(){
			setElement(readAppData(this));
		}
	}
	
	public ProviderMustApproveChk providerMustApproveChk = new ProviderMustApproveChk();
	
	/*
	 * Order must approve time
	 */
	public class OrderMustApproveTimeTxt extends Element{
		public OrderMustApproveTimeTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
			
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public OrderMustApproveTimeTxt orderMustApproveTimeTxt = new OrderMustApproveTimeTxt();
	
	/*
	 * Approval Notification To mail id
	 */
	public class ToMailIDTxt extends Element{
		public ToMailIDTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
			
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public ToMailIDTxt toMailIDTxt = new ToMailIDTxt();
	
	/*
	 * Approval Notification CC mail id
	 */
	public class CCMailIDTxt extends Element{
		public CCMailIDTxt(){
			setElement(readAppData(this));
		}
		
		@Override
		public void write(String data){
			
			String str = super.getAttributeValue("value");
			super.clearAllChars(str.length());
			super.write(data);
		}
	}
	
	public CCMailIDTxt cCMailIDTxt = new CCMailIDTxt();
}
