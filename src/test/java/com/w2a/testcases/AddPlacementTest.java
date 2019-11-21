package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ATSHomePage;
import com.w2a.pages.AddCandPage;
import com.w2a.pages.AddJobPage;
import com.w2a.pages.AddPlacementPage;
import com.w2a.pages.ViewCandPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class AddPlacementTest extends BaseTest {
	
	
	@Test()
	public void openAddPlacementPageTest(){
		
		AddPlacementPage app = new AddPlacementPage();
		Assert.assertEquals(true,app.addplacement().isDisplayed());
		/*AddJobPage ajp = new AddJobPage();
		Assert.assertEquals(true,ajp.addJob().isDisplayed());*/
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp",dependsOnMethods={"openAddPlacementPageTest"})
	public void AddPlacementInfoTest(Hashtable<String,String> data) throws Exception{
		
		AddPlacementPage app = new AddPlacementPage();
		
		app.addGeneralInfo(data.get("JobId"), data.get("Status"),data.get("StartDate"), data.get("Duration"),data.get("JobTitle"));
		app.addFinInfo(data.get("Currency"),data.get("Hpd"),data.get("BillRate"), data.get("Payrate"), data.get("PayUnit"), data.get("OTBillRate"),data.get("OTPayRate"),data.get("OnCallRate"),data.get("ContractDuration"),data.get("EndDate"));
		//Assert.assertEquals(true,ahp.addCandidate().isDisplayed() );
	}
	

}
