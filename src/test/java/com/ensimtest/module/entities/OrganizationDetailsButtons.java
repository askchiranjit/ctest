package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This module includes all buttons of Organization details wizard
 * Buttons included:
 * 1. Edit
 * 2. Add User
 * 3. List Users
 * 4. Import Users
 * 5. Add Account
 * 6. Create Order
 * 7. New Ticket
 * @author Dip
 *
 */

public class OrganizationDetailsButtons extends AppData{

	/**
	 * Click on Edit Button to edit Organization's details
	 *
	 */
	public class EditBtn extends Element
	{
		public EditBtn()
		{
			setElement(readAppData(this));
		}

	}
	public EditBtn editBtn = new EditBtn();

	/**
	 * Click on Add User Button to Add User under a Organization
	 *
	 */
	public class AddUserBtn extends Element
	{
		public AddUserBtn()
		{
			setElement(readAppData(this));
		}

	}
	public AddUserBtn addUserBtn = new AddUserBtn();

	/**
	 * Click on List Users Button to List down all User exists in a Organization
	 *
	 */
	public class ListUsersBtn extends Element
	{
		public ListUsersBtn()
		{
			setElement(readAppData(this));
		}

	}
	public ListUsersBtn listUsersBtn = new ListUsersBtn();

	/**
	 * Click on Import Users Button to Import Users under a Organization
	 *
	 */
	public class ImportUsersBtn extends Element
	{
		public ImportUsersBtn()
		{
			setElement(readAppData(this));
		}

	}
	public ImportUsersBtn importUsersBtn = new ImportUsersBtn();

	/**
	 * Click on Add Account Button to Add Account under a Organization
	 *
	 */
	public class AddAccountBtn extends Element
	{
		public AddAccountBtn()
		{
			setElement(readAppData(this));
		}

	}
	public AddAccountBtn addAccountBtn = new AddAccountBtn();

	/**
	 * Click on Create Order Button to place an order for a Organization
	 *
	 */
	public class CreateOrderBtn extends Element
	{
		public CreateOrderBtn()
		{
			setElement(readAppData(this));
		}

	}
	public CreateOrderBtn createOrderBtn = new CreateOrderBtn();

	/**
	 * Click on New Ticket Button to raise a new ticket for a Organization
	 *
	 */
	public class NewTicketBtn extends Element
	{
		public NewTicketBtn()
		{
			setElement(readAppData(this));
		}

	}
	public NewTicketBtn newTicketBtn = new NewTicketBtn();

}
