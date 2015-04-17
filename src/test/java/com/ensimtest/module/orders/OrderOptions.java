package com.ensimtest.module.orders;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * This will open the Order menus
 * @author Pratap
 *
 */
public class OrderOptions extends AppData
{

	public class OrderMenu extends Element
	{
		public OrderMenu()
		{
			setElement(readAppData(this));
		}
		public void mouseHover()
		{
			super.mouseHover();
		}
	}
	public OrderMenu orderMenu = new OrderMenu();

	public class ListOrderLnk extends Element
	{
		public ListOrderLnk()
		{
			setElement(readAppData(this));
		}
	}
	public ListOrderLnk listOrderLnk = new ListOrderLnk();

	public class CreateOrderLnk extends Element
	{
		public CreateOrderLnk()
		{
			setElement(readAppData(this));
		}
	}
	public CreateOrderLnk createOrderLnk = new CreateOrderLnk();
}
