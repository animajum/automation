package com.w2a.pages;

import com.w2a.base.Page;

public class ViewLeadPage extends Page{

	public String getLead()
	{
		String url=driver.getCurrentUrl();
		return url;
		
	}
}
