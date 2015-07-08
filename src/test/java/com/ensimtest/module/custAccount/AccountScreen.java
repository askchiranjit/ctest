package com.ensimtest.module.custAccount;

import com.ensimtest.config.Element;
import com.ensimtest.config.ElementSet;
import com.ensimtest.module.orders.CreateOrderProvisioningInfo.CustomInfo;

import com.ensimtest.resource.AppData;

public class AccountScreen extends AppData{
	
	public class AccountMenu extends Element
	{
		public AccountMenu()
		{
			setElement(readAppData(this));
		}
	}	
	public AccountMenu accountMenu = new AccountMenu();
	
	public class OrganizationDetailsBtn extends Element
	{
		public OrganizationDetailsBtn()
		{
			setElement(readAppData(this));
		}
	}
	public OrganizationDetailsBtn organizationDetailsBtn = new OrganizationDetailsBtn();
	
	public class MyProfileBtn extends Element
	{
		public MyProfileBtn()
		{
			setElement(readAppData(this));
		}
	}
	public MyProfileBtn myProfileBtn = new MyProfileBtn();
	
	public class UserBtn extends Element
	{
		public UserBtn()
		{
			setElement(readAppData(this));
		}
	}
	public UserBtn userBtn = new UserBtn();
	
	public class BulkAssignmentBtn extends Element
	{
		public BulkAssignmentBtn()
		{
			setElement(readAppData(this));
		}
	}
	public BulkAssignmentBtn bulkAssignmentBtn = new BulkAssignmentBtn();
	
	public class InvoicesAndPaymentsBtn extends Element
	{
		public InvoicesAndPaymentsBtn()
		{
			setElement(readAppData(this));
		}
	}
	public InvoicesAndPaymentsBtn invoicesAndPaymentsBtn = new InvoicesAndPaymentsBtn();
		
	
	public class EditOrganizationDetailsBtn extends Element
	{
		public EditOrganizationDetailsBtn()
		{
			setElement(readAppData(this));
		}
	}
	public EditOrganizationDetailsBtn editOrganizationDetailsBtn = new EditOrganizationDetailsBtn();
	
	/////////////////////////////////////////////////////////////////////////////////////
	// Incomplete
	public class OrganizationDetailsTable extends Element
	{
		public OrganizationDetailsTable()
		{
			setElement(readAppData(this));
		}
	}
	
	public class OrganizationDetailsInfo
	{
		public String label=null;
		public Element element;
		
		public OrganizationDetailsInfo(Element element)
		{
			ElementSet set = new ElementSet();
			Element []list = set.getSubElementSet(element, "Xpath", "td");
			
			System.out.println("Length : " + list.length);
			
			if(list.length>0)
			{
				label=list[0].read();
				element=list[2];
			}
			
		}
	}
	
	public OrganizationDetailsInfo[] getCustomFields()
	{
		OrganizationDetailsTable OrgDetailsTable = new OrganizationDetailsTable();
		ElementSet set = new ElementSet();
		Element []elements = set.getSubElementSet(OrgDetailsTable, "Xpath","//table[@id='organizationData']/tbody/tr");
		System.out.println("Element length : " + elements.length);
		OrganizationDetailsInfo []orgDetailsFields = new OrganizationDetailsInfo[elements.length];
		for(int i=0; i<orgDetailsFields.length; i++)
		{
			orgDetailsFields[i] = new OrganizationDetailsInfo(elements[i]);
		}
		return orgDetailsFields;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	
	public class AddUserBtn extends Element
	{
		public AddUserBtn()
		{
			setElement(readAppData(this));
		} 
	}
	public AddUserBtn addUserBtn = new AddUserBtn();
	
	public class UserNameInNewUserPageTxt extends Element
	{
		public UserNameInNewUserPageTxt()
		{
			setElement(readAppData(this));
		} 
	}
	public UserNameInNewUserPageTxt userNameInNewUserPageTxt = new UserNameInNewUserPageTxt();
	
	public class PasswordInNewUserPageTxt extends Element
	{
		public PasswordInNewUserPageTxt()
		{
			setElement(readAppData(this));
		} 
	}
	public PasswordInNewUserPageTxt passwordInNewUserPageTxt = new PasswordInNewUserPageTxt();
	
	public class VerifyPasswordInNewUserPageTxt extends Element
	{
		public VerifyPasswordInNewUserPageTxt()
		{
			setElement(readAppData(this));
		} 
	}
	public VerifyPasswordInNewUserPageTxt verifyPasswordInNewUserPageTxt = new VerifyPasswordInNewUserPageTxt();
	
	public class AccountInNewUserPage extends Element
	{
		public AccountInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public AccountInNewUserPage accountInNewUserPage = new AccountInNewUserPage();
	
	public class LanguageInNewUserPage extends Element
	{
		public LanguageInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public LanguageInNewUserPage languageInNewUserPage = new LanguageInNewUserPage();
	
	public class PrimaryRoleInNewUserPage extends Element
	{
		public PrimaryRoleInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public PrimaryRoleInNewUserPage primaryRoleInNewUserPage = new PrimaryRoleInNewUserPage();
	
	public class SecondaryRolesInNewUserPage extends Element
	{
		public SecondaryRolesInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public SecondaryRolesInNewUserPage secondaryRolesInNewUserPage = new SecondaryRolesInNewUserPage();
	
	public class IsDefaultBCInNewUserPage extends Element
	{
		public IsDefaultBCInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public IsDefaultBCInNewUserPage isDefaultBCInNewUserPage = new IsDefaultBCInNewUserPage();
	
	public class IsDefaultTCInNewUserPage extends Element
	{
		public IsDefaultTCInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public IsDefaultTCInNewUserPage isDefaultTCInNewUserPage = new IsDefaultTCInNewUserPage();
	
	public class FirstNameInNewUserPage extends Element
	{
		public FirstNameInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public FirstNameInNewUserPage firstNameInNewUserPage = new FirstNameInNewUserPage();
	
	public class LastNameInNewUserPage extends Element
	{
		public LastNameInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public LastNameInNewUserPage lastNameInNewUserPage = new LastNameInNewUserPage();
	
	public class EmailAddressInNewUserPage extends Element
	{
		public EmailAddressInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public EmailAddressInNewUserPage emailAddressInNewUserPage = new EmailAddressInNewUserPage();
	
	public class SecondaryEmailAddressInNewUserPage extends Element
	{
		public SecondaryEmailAddressInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public SecondaryEmailAddressInNewUserPage secondaryEmailAddressInNewUserPage = new SecondaryEmailAddressInNewUserPage();
	
	public class PhoneNumberInNewUserPage extends Element
	{
		public PhoneNumberInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public PhoneNumberInNewUserPage phoneNumberInNewUserPage = new PhoneNumberInNewUserPage();
	
	public class MobileInNewUserPage extends Element
	{
		public MobileInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public MobileInNewUserPage mobileInNewUserPage = new MobileInNewUserPage();
	
	public class FaxCountryCodeNewUserPage extends Element
	{
		public FaxCountryCodeNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public FaxCountryCodeNewUserPage faxCountryCodeNewUserPage = new FaxCountryCodeNewUserPage();
	
	public class FaxAreaCodeInNewUserPage extends Element
	{
		public FaxAreaCodeInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public FaxAreaCodeInNewUserPage faxAreaCodeInNewUserPage = new FaxAreaCodeInNewUserPage();
	
	public class FaxNumberInNewUserPage extends Element
	{
		public FaxNumberInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public FaxNumberInNewUserPage faxNumberInNewUserPage = new FaxNumberInNewUserPage();
	
	public class AddressLine1InNewUserPage extends Element
	{
		public AddressLine1InNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public AddressLine1InNewUserPage addressLine1InNewUserPage = new AddressLine1InNewUserPage();
	
	public class AddressLine2InNewUserPage extends Element
	{
		public AddressLine2InNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public AddressLine2InNewUserPage addressLine2InNewUserPage = new AddressLine2InNewUserPage();
	
	public class CityInNewUserPage extends Element
	{
		public CityInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public CityInNewUserPage cityInNewUserPage = new CityInNewUserPage();
	
	public class StateInNewUserPage extends Element
	{
		public StateInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public StateInNewUserPage stateInNewUserPage = new StateInNewUserPage();
	
	public class ZipCodeInNewUserPage extends Element
	{
		public ZipCodeInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public ZipCodeInNewUserPage zipCodeInNewUserPage = new ZipCodeInNewUserPage();
	
	public class CountryInNewUserPage extends Element
	{
		public CountryInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public CountryInNewUserPage countryInNewUserPage = new CountryInNewUserPage();
	
	public class CreateUserBtnInNewUserPage extends Element
	{
		public CreateUserBtnInNewUserPage()
		{
			setElement(readAppData(this));
		} 
	}
	public CreateUserBtnInNewUserPage createUserBtnInNewUserPage = new CreateUserBtnInNewUserPage();
	
	public class SearchUserTextBox extends Element
	{
		public SearchUserTextBox()
		{
			setElement(readAppData(this));
		}
	}
	public SearchUserTextBox searchUserTextBox = new SearchUserTextBox();
	
	public class SearchUserBtn extends Element
	{
		public SearchUserBtn()
		{
			setElement(readAppData(this));
		}
	}
	public SearchUserBtn searchUserBtn = new SearchUserBtn();
	
	public class SelectUserFromUserList extends Element
	{
		public SelectUserFromUserList()
		{
			setElement(readAppData(this));
		}
	}
	public SelectUserFromUserList selectUserFromUserList = new SelectUserFromUserList();
	
	//Email address for correspondence*
	public class EmailAddressInEditOrgPage extends Element
	{
		public EmailAddressInEditOrgPage()
		{
			setElement(readAppData(this));
		}
	}
	public EmailAddressInEditOrgPage emailAddressInEditOrgPage = new EmailAddressInEditOrgPage();
	
	public class CommunicationLanguageInEditOrgPage extends Element
	{
		public CommunicationLanguageInEditOrgPage()
		{
			setElement(readAppData(this));
		}
	}
	public CommunicationLanguageInEditOrgPage communicationLanguageInEditOrgPage = new CommunicationLanguageInEditOrgPage();
	
	public class BillingLanguageInEditOrgPage extends Element
	{
		public BillingLanguageInEditOrgPage()
		{
			setElement(readAppData(this));
		}
	}
	public BillingLanguageInEditOrgPage billingLanguageInEditOrgPage = new BillingLanguageInEditOrgPage();
	
	public class DateTimeFormatInEditOrgPage extends Element
	{
		public DateTimeFormatInEditOrgPage()
		{
			setElement(readAppData(this));
		}
	}
	public DateTimeFormatInEditOrgPage dateTimeFormatInEditOrgPage = new DateTimeFormatInEditOrgPage();
	
	public class SaveOrgDetailsBtnInEditOrgPage extends Element
	{
		public SaveOrgDetailsBtnInEditOrgPage()
		{
			setElement(readAppData(this));
		}
	}
	public SaveOrgDetailsBtnInEditOrgPage saveOrgDetailsBtnInEditOrgPage = new SaveOrgDetailsBtnInEditOrgPage();
}
