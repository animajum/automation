package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.pages.AddLeadPage;
import com.w2a.pages.ViewLeadPage;
import com.w2a.pages.crmHomePage;
import com.w2a.utilities.Utilities;

public class AddLeadTest extends BaseTest{

	@Test()
	public void openAddLeadPageTest()
	{
		crmHomePage chp=new crmHomePage();
		Assert.assertEquals(true, chp.addLead().isDisplayed());
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp",dependsOnMethods={"openAddLeadPageTest"})
	public void AddLeadInfoTest(Hashtable<String,String> data) throws InterruptedException
	{
		AddLeadPage alp=new AddLeadPage();
		alp.addBasicInfo(data.get("FirstName"), data.get("LastName"), data.get("Account"), data.get("JobTitle"), data.get("Source"));
		alp.saveLeadInfo();
		ViewLeadPage vlp=new ViewLeadPage();
		//Assert.assertEquals(true, vlp.getLead().contains("viewLead"));
	}
}
