package com.ensimtest.connector.vcenter34;

import com.ensimtest.config.Element;
import com.ensimtest.resource.AppData;

public class ControlPanelMenuVcent34 extends AppData
{

	public class ServiceOverviewLnk extends Element
	{
		public ServiceOverviewLnk()
		{
			setElement(readAppData(this));
		}
	}
	public ServiceOverviewLnk serviceOverviewLnk = new ServiceOverviewLnk();

	public class VirtualserversLnk extends Element
	{
		public VirtualserversLnk()
		{
			setElement(readAppData(this));
		}
	}
	public VirtualserversLnk virtualserversLnk = new VirtualserversLnk();

	public class NetworkLnk extends Element
	{
		public NetworkLnk()
		{
			setElement(readAppData(this));
		}
	}
	public NetworkLnk networkLnk = new NetworkLnk();

	public class TemplatesLnk extends Element
	{
		public TemplatesLnk()
		{
			setElement(readAppData(this));
		}
	}
	public TemplatesLnk templatesLnk = new TemplatesLnk();

	public class UsersLnk extends Element
	{
		public UsersLnk()
		{
			setElement(readAppData(this));
		}
	}
	public UsersLnk usersLnk = new UsersLnk();

	public class ActionLogsLnk extends Element
	{
		public ActionLogsLnk()
		{
			setElement(readAppData(this));
		}
	}
	public ActionLogsLnk actionLogsLnk = new ActionLogsLnk();

	public class VDCInformationLnk extends Element
	{
		public VDCInformationLnk()
		{
			setElement(readAppData(this));
		}
	}
	public VDCInformationLnk vDCInformationLnk = new VDCInformationLnk();

	public class DownloadVMRCLnk extends Element
	{
		public DownloadVMRCLnk()
		{
			setElement(readAppData(this));
		}
	}
	public DownloadVMRCLnk downloadVMRCLnk = new DownloadVMRCLnk();
	
}
