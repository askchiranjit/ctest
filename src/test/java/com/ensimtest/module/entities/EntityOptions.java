package com.ensimtest.module.entities;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

/**
 * This will open the entities menus
 * @author Chiranjit
 *
 */
public class EntityOptions extends AppData
{
	public class Menu extends Element
	{
		public Menu()
		{
			setElement(readAppData(this));
		}
		public void mouseHover()
		{
			super.mouseHover();
		}
	}
	public Menu menuBtn = new Menu();
	
	public class Org extends Element
	{
		public Org()
		{
			setElement(readAppData(this));
		}
	}
	public Org orglink = new Org();
	
	public class Agents extends Element
	{
		public Agents()
		{
			setElement(readAppData(this));
		}
	}
	public Agents agentlink = new Agents();
}
