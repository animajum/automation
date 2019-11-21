package com.w2a.testcases;																			

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ATSHomePage;
import com.w2a.pages.AddCandPage;
import com.w2a.pages.ViewCandPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class ViewCandidateTest extends BaseTest {
	
	
	@Test()
	public void openviewCandidatePageTest(){
		
		ATSHomePage ahp = new ATSHomePage();
		Assert.assertEquals(true,ahp.viewCandidate().isDisplayed() );
	}

	/*@Test(dataProviderClass=Utilities.class,dataProvider="dp",dependsOnMethods={"openAddCandidatePageTest"})
	public void AddCandidateInfoTest(Hashtable<String,String> data) throws InterruptedException {
		
		AddCandPage acp = new AddCandPage();
		acp.addBasicInfo(data.get("FirstName"), data.get("LastName"),data.get("Gender"), data.get("Source"),data.get("Ethnicity"),data.get("Nationality"));
		try {
			acp.addContactInfo(data.get("Email"), data.get("Phone").replace(".", ""),data.get("City"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acp.addWorkInfo(data.get("Company"), data.get("JobTitle"));
		acp.addWorkpermitInfo(data.get("WorkAuth"));
		acp.addEduInfo(data.get("School"), data.get("Degree"));
		acp.addSkillnfo(data.get("Skills"));
		ViewCandPage vcp = acp.saveCandInfo();
		Assert.assertTrue(vcp.getCandId().contains("viewCandidate"));
		vcp.uploadResume(data.get("Resume"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(true,ahp.addCandidate().isDisplayed() );
	}*/

}
