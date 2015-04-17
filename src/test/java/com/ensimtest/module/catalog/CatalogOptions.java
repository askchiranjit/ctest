package com.ensimtest.module.catalog;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;
/**
 * This will open the Catalog menus
 * @author Pratap
 *
 */

public class CatalogOptions extends AppData
{
	public class CatalogMenu extends Element
	{
		public CatalogMenu()
		{
			setElement(readAppData(this));
		}
		public void mouseHover()
		{
			super.mouseHover();
		}
	}
	public CatalogMenu catalogMenu=new CatalogMenu();

	public class OffersLnk extends Element
	{
		public OffersLnk()
		{
			setElement(readAppData(this));
		}
	}
	public OffersLnk offersLnk = new OffersLnk();

	public class RegionsLnk extends Element
	{
		public RegionsLnk()
		{
			setElement(readAppData(this));
		}
	}
	public RegionsLnk regionsLnk = new RegionsLnk();

	public class ItemsAndRPPLnk extends Element
	{
		public ItemsAndRPPLnk()
		{
			setElement(readAppData(this));
		}
	}
	public ItemsAndRPPLnk itemsAndRPPLnk = new ItemsAndRPPLnk();

	public class Serviceslnk extends Element
	{
		public Serviceslnk()
		{
			setElement(readAppData(this));
		}
	}
	public Serviceslnk serviceslnk = new Serviceslnk();
}
