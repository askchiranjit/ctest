package com.ensimtest.base;

public interface IElement
{
	public void click();
	public boolean isExists();
	public boolean isDisplayed();
	public boolean isEnabled();
	public String read();
	public void write(String s);
}
