package com.ensimtest.module.settings;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class SettingsMenu extends AppData
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
	public Menu menu = new Menu();
	
	public class ConfigurationMenu extends Element
	{
		public ConfigurationMenu()
		{
			setElement(readAppData(this));
		}
	}
	public ConfigurationMenu configurationMenu = new ConfigurationMenu();
	
	public class ControlPanelMenu extends Element
	{
		public ControlPanelMenu()
		{
			setElement(readAppData(this));
		}
	}
	public ControlPanelMenu controlPanelMenu = new ControlPanelMenu();
}
